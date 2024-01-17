/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import dao.DAO;
import dao.annotation.Columns;

/**
 *
 * @author HARDY
 */
public class Fonction extends DAO{
    @Columns(name="idfonction")
    int idfonction;
    @Columns(name = "intitule")
    String intitule;
    @Columns(name = "salaire")
    double salaire;
    
    public int getIdfonction() {
        return idfonction;
    }

    public void setIdfonction(int idfonction) {
        this.idfonction = idfonction;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    
    
}
