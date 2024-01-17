
import connexion.Connex;
import java.sql.Connection;
import java.sql.Date;
import java.util.Set;
import objet.Client;
import objet.Dure;
import objet.Voyage;
import objet.Voyage_activite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HARDY
 */
public class Main {
    public static  void main(String[] args) throws Exception{
        Connection c=Conn.connexionPostgres();
        Voyage voyage=Voyage.getLastVoyage(c);
        Client cl=new Client("KOTO","BEMA",1,Voyage.getStringToDate("02-02-1999"));
        Dure d=Dure.getAllDure(c)[0];
        voyage.reservationThis(c, cl, d);
        c.close();
    }
}
