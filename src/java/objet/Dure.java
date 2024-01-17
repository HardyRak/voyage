/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import dao.DAO;
import dao.annotation.Columns;
import java.sql.Connection;

/**
 *
 * @author HARDY
 */
public class Dure extends DAO{
    @Columns(name = "iddure")
    int iddure;
    @Columns(name= "typedure")
    String typeDure;

    public int getIddure() {
        return iddure;
    }

    public void setIddure(int iddure) {
        this.iddure = iddure;
    }

    public String getTypeDure() {
        return typeDure;
    }

    public void setTypeDure(String typeDure) {
        this.typeDure = typeDure;
    }
    
    public static Dure[] getAllDure(Connection c) throws Exception{
        Dure d=new Dure();
        Dure[] all=new Dure[d.selectAll(c).length];
        for(int i=0;i<d.selectAll(c).length;i++){
            all[i]=(Dure)d.selectAll(c)[i];
        }
        return all;
    }
    
    public static Dure getDureId(Connection c,int iddure) throws Exception{
        Dure d=null;
        Dure[] all=Dure.getAllDure(c);
        for (int i = 0; i < all.length; i++) {
            if(all[i].getIddure()==iddure){
                d=all[i];
            }
        }
        return d;
    }
    
}
