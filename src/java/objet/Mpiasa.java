/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import dao.DAO;
import dao.annotation.Columns;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author HARDY
 */
public class Mpiasa extends DAO{
    @Columns(name="idmpiasa")
    int idMpiasa;
    @Columns(name="nom")
    String nom;
    @Columns(name="naissance")
    Date naissance;
    
    Fonction fonction;
    //---------------------------
    double karama;
    
    int heure;

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }
    
    
    public int getIdMpiasa() {
        return idMpiasa;
    }

    public void setIdMpiasa(int idMpiasa) {
        this.idMpiasa = idMpiasa;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getNaissance() {
        
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    public double getKarama() {
        return karama;
    }

    public void setKarama(double karama) {
        this.karama = karama;
    }
    
    public static Mpiasa[] findAll(Connection con) throws Exception{
        String requete="SELECT*FROM mpiasa";
        Statement st=con.createStatement();
        ResultSet rset=st.executeQuery(requete);
        Vector<Mpiasa> all=new Vector<>();
        while(rset.next()){
            Mpiasa mp=new Mpiasa();
            mp.setIdMpiasa(rset.getInt("idmpiasa"));
            mp.setNaissance(rset.getDate("naissance"));
            mp.setNom(rset.getString("nom"));
            Fonction fonction=(Fonction) new Fonction().selectWithOneCondition(con, "idfonction", rset.getString("idFonction"))[0];
            mp.setFonction(fonction);
            all.add(mp);
        }
        return all.toArray(new Mpiasa[all.size()]);
    }
}
