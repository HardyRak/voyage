package objet;

import dao.DAO;
import dao.annotation.Columns;
import dao.annotation.Serialized;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author HARDY
 */
public class Bouquet extends DAO{
    @Serialized(serial=true)
    @Columns(name="idBouquet")
    int idBouquet;
    
    @Columns(name="nom")
    String nom;
    
    @Columns(name="idType")
    int idType;
    
    Activite[] activite;

    public Activite[] getActivite() {
        return activite;
    }

    public void setActivite(Activite[] activite) {
        this.activite = activite;
    }
    
    public int getIdBouquet() {
        return idBouquet;
    }

    public void setIdBouquet(int idBouquet) {
        this.idBouquet = idBouquet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }
    
    
    public static Bouquet getLastBouquet(Connection c) throws Exception{
        String query="SELECT * FROM bouquet order by idbouquet desc limit 1";
        Statement statement=c.createStatement();
        ResultSet rset=statement.executeQuery(query);
        Bouquet bouquet=null;
        if(rset.next()){
            bouquet=new Bouquet();
            bouquet.setIdBouquet(rset.getInt("idbouquet"));
            bouquet.setNom(rset.getString("nom"));
        }
        rset.close();
        statement.close();
        return bouquet;
    }
    
    public void insertBouquet(Connection c,String[] listIdActivite) throws Exception{
        this.insertion(c);
        Bouquet last=Bouquet.getLastBouquet(c);
        Statement st=c.createStatement();
        for(int i=0;i<listIdActivite.length;i++){
            String query="INSERT INTO bouquet_activite values("+last.getIdBouquet()+","+Integer.parseInt(listIdActivite[i])+")";
            st.executeUpdate(query);
        }
        st.close();
    }
    
    public Activite[] getActivite(Connection c) throws Exception{
        String query="SELECT*FROM V_bouquet_activite_R where idbouquet="+this.getIdBouquet();
        Statement statement = c.createStatement();
        ResultSet rset=statement.executeQuery(query);
        Vector<Activite> acticite=new Vector<>();
        while(rset.next()){
            Activite activ=new Activite();
            activ.setIdActivite(rset.getInt("idactivite"));
            activ.setNom(rset.getString("nom"));
            acticite.add(activ);
        }
        rset.close();
        statement.close();
        return acticite.toArray(new Activite[acticite.size()]);
    }
    
    public static Bouquet[] getAllBouquet(Connection con) throws Exception{
        Bouquet b=new Bouquet();
        Object[] all=b.selectAll(con);
        Vector<Bouquet> bouquets=new Vector<>();
        for(int i=0;i<all.length;i++){
            b=(Bouquet)all[i];
            bouquets.add(b);
        }
        return bouquets.toArray(new Bouquet[bouquets.size()]);
    }
    
    public static Bouquet getBouquetById(Connection con,int id) throws Exception{
        Bouquet[] all=Bouquet.getAllBouquet(con);
        Bouquet b=null;
        for(int i=0;i<all.length;i++){
            if(all[i].getIdBouquet()==id){
                b=all[i];
                break;
            }
        }
        return b;
    }
    
    
    
}
