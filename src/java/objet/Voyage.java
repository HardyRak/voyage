/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import dao.DAO;
import dao.annotation.Columns;
import dao.annotation.Serialized;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;

public class Voyage extends DAO{
    @Serialized(serial=true)
    @Columns(name="idvoyage")
    int voyage;

    @Columns(name="libelle")
    String libelle;

    @Columns(name="idtype")
    int idType;

    @Columns(name="datedebut")
    Date dateDebut;

    @Columns(name="datefin")    
    Date dateFin;
    
    @Columns(name="idbouquet")
    int idbouquet;
    
    @Columns(name = "prixvente")
    int prixVente;
            
    Bouquet bouquet;

    Type type;

    public int getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }
    
    public Bouquet getBouquet() {
        return bouquet;
    }

    public void setBouquet(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    
    public int getIdbouquet() {
        return idbouquet;
    }

    public void setIdbouquet(int idbouquet) {
        this.idbouquet = idbouquet;
    }
    
    public int getVoyage() {
        return voyage;
    }

    public void setVoyage(int voyage) {
        this.voyage = voyage;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    
    
    public static Voyage getLastVoyage(Connection c) throws Exception{
        String query="SELECT * FROM voyage order by idvoyage desc limit 1";
        Statement statement=c.createStatement();
        ResultSet rset=statement.executeQuery(query);
        Voyage voyage=null;
        if(rset.next()){
            voyage=new Voyage();
            voyage.setVoyage(rset.getInt("idvoyage"));
            voyage.setLibelle(rset.getString("libelle"));
            voyage.setIdType(rset.getInt("idtype"));
            voyage.setDateDebut(rset.getDate("datedebut"));
            voyage.setDateFin(rset.getDate("datefin"));
            voyage.setIdbouquet(rset.getInt("idbouquet"));
            voyage.setBouquet(Bouquet.getBouquetById(c, voyage.getIdbouquet()));
            voyage.setType((Type)(new Type().selectWithOneCondition(c, "idtype",""+rset.getInt("idtype"))[0]));
        }
        rset.close();
        statement.close();
        return voyage;
    }
    
    public static Voyage[] getAllVoyage(Connection c) throws Exception{
        String query="SELECT * FROM voyage";
        Statement statement=c.createStatement();
        ResultSet rset=statement.executeQuery(query);
        Vector<Voyage> all=new Vector<>();
        while(rset.next()){
            Voyage voyage=new Voyage();
            voyage.setVoyage(rset.getInt("idvoyage"));
            voyage.setLibelle(rset.getString("libelle"));
            voyage.setIdType(rset.getInt("idtype"));
            voyage.setDateDebut(rset.getDate("datedebut"));
            voyage.setDateFin(rset.getDate("datefin"));
            voyage.setIdbouquet(rset.getInt("idbouquet"));
            voyage.setBouquet(Bouquet.getBouquetById(c, voyage.getIdbouquet()));
            voyage.setType((Type)(new Type().selectWithOneCondition(c, "idtype",""+rset.getInt("idtype"))[0]));
            all.add(voyage);
        }
        rset.close();
        statement.close();
        return all.toArray(new Voyage[all.size()]);
    }
    
    public static Voyage getVoyageById(Connection con,int id) throws Exception{
        Voyage[] all=Voyage.getAllVoyage(con);
        Voyage voyage=null;
        for (int i = 0; i < all.length; i++) {
            if (all[i].getVoyage()==id) {
                voyage=all[i];
            }
        }
        return voyage;
    }
    
    public Bouquet getBouquetPerVoyage(Connection c) throws Exception{
        return Bouquet.getBouquetById(c, this.getIdbouquet());
    }
    
    public static java.sql.Date getStringToDate(String dateString) throws Exception {
        String inputDateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(inputDateFormat);
        java.util.Date date = sdf.parse(dateString);
        return new java.sql.Date(date.getTime());
    }
    
    public void insetionVoyage(Connection c,String[] idType) throws Exception{
        this.insertion(c);
        Voyage last=Voyage.getLastVoyage(c);
        Statement st=c.createStatement();
        for(int i=0;i<idType.length;i++){
            String query="INSERT INTO voyage_dure values("+last.getVoyage()+","+Integer.parseInt(idType[i])+")";
            st.executeUpdate(query);
        }
        st.close();
    }
    
    public Bouquet[] getAllBouquet(Connection con) throws Exception{
        String query="SELECT*FROM V_voyage_bouquet_R where idvoyage="+this.getVoyage();
        Statement statement=con.createStatement();
        ResultSet rset=statement.executeQuery(query);
        Vector<Bouquet> all=new Vector<>();
        while(rset.next()){
            Bouquet b=new Bouquet();
            b.setIdBouquet(rset.getInt("idbouquet"));
            b.setNom(rset.getString("nom"));
            b.setIdType(rset.getInt("idtype"));
            all.add(b);
        }
        return all.toArray(new Bouquet[all.size()]);
    }
    
    public Dure[] getDureVoyage(Connection con) throws Exception{
        String requete="SELECT*FROM v_voyage_dure where idvoyage='"+this.getVoyage()+"'";
        Statement st=con.createStatement();
        ResultSet rset=st.executeQuery(requete);
        Vector<Dure> all=new Vector<>();
        while(rset.next()){
            Dure dure=new Dure();
            dure.setIddure(rset.getInt("iddure"));
            dure.setTypeDure(rset.getString("typeDure"));
            all.add(dure);
        }
        return all.toArray(new Dure[all.size()]);
    }
    
    public void insertNbrActivite(Connection c,Dure dure,String[] idActivite,String[] nombre) throws Exception{
        Statement st=c.createStatement();
        for (int i = 0; i < idActivite.length; i++) {
            String req="INSERT INTO voyage_activite values('"+this.getVoyage()+"','"+idActivite[i]+"','"+nombre[i]+"','"+dure.getIddure()+"')";
            st.executeUpdate(req);
        }
    }
    
    public HashMap<String,Double> getCout(Connection con) throws Exception{
        Voyage_activite[] allvoyage=Voyage_activite.getByIdVoyage(con, this.getVoyage());
        HashMap<String,Double> allCout=new HashMap<>();
        Dure[] dure=this.getDureVoyage(con);
            for (int j = 0; j < dure.length; j++) {
                double cout=0;
                for (int i = 0; i < allvoyage.length; i++) {      
                    if(dure[j].getIddure()==allvoyage[i].getDure().getIddure()){
                        cout+=allvoyage[i].getActivite().getCout();
                    }
                }
                Double d=cout;
                allCout.put(dure[j].getTypeDure(), d);
            }
        return allCout;
    }
    
    public void reservationThis(Connection c,Client client,Dure dure) throws Exception{
        Voyage_activite[] allAct=Voyage_activite.getByIdVoyage(c, this.getVoyage());
        Vector<Voyage_activite> all=new Vector<>();
        for (int i = 0; i < allAct.length; i++) {
            if(allAct[i].getDure().getIddure()==dure.getIddure()){
                all.add(allAct[i]);
            }
        }
        for(int i=0;i<all.size();i++){
            System.err.println("update activite set quota="+(all.get(i).getActivite().getQuota()-1)+" where idactivite="+all.get(i).getActivite().getIdActivite());
            DAO.updateOrDelete(c, "update activite set quota="+(all.get(i).getActivite().getQuota()-1)+" where idactivite="+all.get(i).getActivite().getIdActivite());
        }
        if(client.clientExiste(c, client)){
            String req="INSERT INTO client_voyage values('"+this.getVoyage()+"','"+dure.getIddure()+"','"+client.getIdclient()+"')";
            System.err.println(req);
            DAO.updateOrDelete(c, req);
        }else{
            client.insertion(c);
            client=Client.getLast(c);
            String req="INSERT INTO client_voyage values('"+this.getVoyage()+"','"+dure.getIddure()+"','"+client.getIdclient()+"')";
            System.err.println(req);
            DAO.updateOrDelete(c, req);
        }
    }
    
    public Mpiasa[] getMpiasaVoyage(Connection con) throws Exception{
        String req="SELECT * FROM V_FonctionnaireFonction where idvoyage="+this.getVoyage();
        Statement st=con.createStatement();
        Vector<Mpiasa> mpiasas=new Vector<>();
        ResultSet rset=st.executeQuery(req);
        Mpiasa[] all=Mpiasa.findAll(con);
        while(rset.next()){
            for (int i = 0; i < all.length; i++) {
                if(all[i].getIdMpiasa()==rset.getInt("idMpiasa")){
                    all[i].setKarama(rset.getDouble("salaire"));
                    all[i].setHeure(rset.getInt("heure"));
                    mpiasas.add(all[i]);
                }
            }
        }
        st.close();
        rset.close();
        return mpiasas.toArray(new Mpiasa[mpiasas.size()]);
    }
    
    public double getsalaireEmp(Connection con) throws Exception{
        Mpiasa[] mpiasa=this.getMpiasaVoyage(con);
        double salaire=0;
        for (int i = 0; i < mpiasa.length; i++) {
            salaire+=(mpiasa[i].getKarama()*mpiasa[i].getHeure());
        }
        return salaire;
    }
    
    public double getAchatActivite(Connection con) throws Exception{
        Voyage_activite[] v_act=Voyage_activite.getByIdVoyage(con, this.getVoyage());
        double prix=0;
        for (int i = 0; i < v_act.length; i++) {
            prix+=(v_act[i].getActivite().getPrixAchat()*v_act[i].getNombre());
        }
        return prix;
    }
    
    public double getPrixDeRevient(Connection con) throws Exception{
        double revient=this.getAchatActivite(con)+this.getsalaireEmp(con);
        return revient;
    }
    
    public double getBenefice(Connection con) throws Exception{
        double benefice=this.getPrixVente()-this.getPrixDeRevient(con);
        return benefice;
    }
    
}
