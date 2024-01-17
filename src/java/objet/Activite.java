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
import java.util.Vector;

/**
 *
 * @author HARDY
 */
public class Activite extends DAO{
    @Serialized(serial=true)
    @Columns(name="idactivite")
    int idActivite;
    
    @Columns(name="nom")
    String nom;
   
    @Columns(name = "cout")
    double cout;
    
    @Columns(name="quota")
    int quota;

    int prixAchat;

    public int getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }
    
    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }
    
    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }
    
    public int getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(int idActivite) {
        this.idActivite = idActivite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
   
    
    public static Activite[] getAllActivite(Connection c) throws Exception{
        Activite activite=new Activite();
        Object[] all=activite.selectAll(c);
        Vector<Activite> activites=new Vector<>();
        for(int i=0;i<all.length;i++){
            activites.add((Activite)all[i]);
        }
        return activites.toArray(new Activite[activites.size()]);
    }
    
    
}
