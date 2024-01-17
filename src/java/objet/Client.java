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
import java.sql.Statement;

/**
 *
 * @author HARDY
 */
public class Client extends  DAO{
    @Columns(name="idclient")
    @Serialized(serial = true)
    int idclient;
    
    @Columns(name="nom")
    String nom;
    
    @Columns(name="prenom")
    String prenom;
    
    @Columns(name="idsex")
    int idsex;
    
    @Columns(name="naissance")
    Date naissance;

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getIdsex() {
        return idsex;
    }

    public void setIdsex(int idsex) {
        this.idsex = idsex;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }
    
    public static Client[] getAll(Connection con) throws Exception{
        Client cl=new Client();
        DAO[] all=cl.selectAll(con);
        Client[] allc=new Client[all.length];
        for (int i = 0; i < 10; i++) {
            allc[i]=(Client)all[i];
        }
        return allc;
    }
    public static Client getById(Connection con,int idClient) throws Exception{
        Client ret=null;
        String req="SELECt*FROM client where idclient="+idClient;
        Statement st=con.createStatement();
        ResultSet rset=st.executeQuery(req);
        if (rset.next()) {
            Client cl=new Client();
            cl.setIdclient(rset.getInt("idclient"));
            cl.setIdsex(rset.getInt("idsex"));
            cl.setNom(rset.getString("nom"));
            cl.setPrenom(rset.getString("prenom"));
            cl.setIdsex(rset.getInt("idsex"));
            ret=cl;
        }
        return ret;
    }
    
    public static Client getLast(Connection con) throws Exception{
        Client ret=null;
        String req="SELECt*FROM client order  by idclient desc limit 1";
        Statement st=con.createStatement();
        ResultSet rset=st.executeQuery(req);
        if (rset.next()) {
            Client cl=new Client();
            cl.setIdclient(rset.getInt("idclient"));
            cl.setIdsex(rset.getInt("idsex"));
            cl.setNom(rset.getString("nom"));
            cl.setPrenom(rset.getString("prenom"));
            cl.setIdsex(rset.getInt("idsex"));
            ret=cl;
        }
        return ret;
    }
    
    public boolean clientExiste(Connection con,Client cl) throws Exception{
        Client cli=Client.getById(con, cl.getIdclient());
        if(cli!=null){
            return true;
        }else{
            return false;
        }
    }
    
    public Client(String nom, String prenom, int idsex, Date naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.idsex = idsex;
        this.naissance = naissance;
    }
    
    public Client(int idclient, String nom, String prenom, int idsex, Date naissance) {
        this.idclient = idclient;
        this.nom = nom;
        this.prenom = prenom;
        this.idsex = idsex;
        this.naissance = naissance;
    }
    
    public Client() {
    }
    
}
