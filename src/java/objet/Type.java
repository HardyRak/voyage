package objet;
import dao.DAO;
import dao.annotation.Columns;
import dao.annotation.Serialized;
import java.sql.Connection;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HARDY
 */
public class Type extends DAO{
    @Serialized(serial=true)
    @Columns(name="idtype")
    int idtype;
    
    @Columns(name="nom")
    String nom;

    public int getIdtype() {
        return idtype;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public static Type[] getAllType(Connection c) throws Exception{
        Type p=new Type();
        Object[] all=p.selectAll(c);
        Vector<Type> vect=new Vector<>();
        for(int i=0;i<all.length;i++){
            vect.add((Type)all[i]);
        }
        return vect.toArray(new Type[vect.size()]);
    }
    
}
