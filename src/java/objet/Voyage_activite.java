/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author HARDY
 */
public class Voyage_activite {
    Voyage voyage;
    Activite activite;
    int nombre;
    Dure dure;

    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public Dure getDure() {
        return dure;
    }

    public void setDure(Dure dure) {
        this.dure = dure;
    }
    
    public static Voyage_activite[] getByAll(Connection con) throws Exception{
        String req="SELECT*FROM voyage_activite";
        Statement st=con.createStatement();
        ResultSet rset=st.executeQuery(req);
        Vector<Voyage_activite> all=new Vector<>();
        while(rset.next()){
            Voyage_activite va=new Voyage_activite();
            System.err.println(rset.getInt("idvoyage"));
            va.setVoyage(Voyage.getVoyageById(con, rset.getInt("idvoyage")));
            va.setActivite((Activite)(new Activite().selectWithOneCondition(con, "idActivite", ""+rset.getInt("idactivite"))[0]));
            va.setDure((Dure)(new Dure().selectWithOneCondition(con, "iddure", ""+rset.getInt("iddure"))[0]));
            va.setNombre(rset.getInt("nombreFoi"));
            all.add(va);
        }
        return all.toArray(new Voyage_activite[all.size()]);
    }
    
    public static Voyage_activite[] getByIdActivite(Connection con,int idActivite) throws Exception{
        Voyage_activite[] all=Voyage_activite.getByAll(con);
        Vector<Voyage_activite> va=new Vector<>();
        for (int i = 0; i < all.length; i++) {
            if (all[i].getActivite().getIdActivite()==idActivite) {
                va.add(all[i]);
            }
        }
        return va.toArray(new Voyage_activite[va.size()]);
    }
    
    public static Voyage_activite[] getByIdVoyage(Connection con,int idvoyage) throws Exception{
        Voyage_activite[] all=Voyage_activite.getByAll(con);
        Vector<Voyage_activite> va=new Vector<>();
        for (int i = 0; i < all.length; i++) {
            if (all[i].getVoyage().getVoyage()==idvoyage) {
                va.add(all[i]);
            }
        }
        return va.toArray(new Voyage_activite[va.size()]);
    }
    
}

