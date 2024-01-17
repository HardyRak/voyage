/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import connexion.Connex;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import objet.Activite;
import objet.Bouquet;
import objet.Dure;
import objet.Type;
import objet.Voyage;
import objet.Voyage_activite;
import simpleController.CtrlAnnotation;
import simpleController.MereController;

/**
 *
 * @author HARDY
 */
@WebServlet(name = "GetAjax", value = "*.json")
public class GetAjax extends MereController{
    @CtrlAnnotation(name = "getactivite")
    public void getActivite() throws IOException{
        try (PrintWriter out = response.getWriter()) {
            Connection c=Connex.connexionPostgres();
            try {
                Activite[] allActivite=Activite.getAllActivite(c);
                Gson gson=new Gson();
                
                out.println(gson.toJson(allActivite));
                c.close();
            } catch (Exception ex) {
                Logger.getLogger(GetAjax.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @CtrlAnnotation(name="getType")
    public void getType() throws IOException{
        try (PrintWriter out = response.getWriter()) {
            Connection c=Connex.connexionPostgres();
            try {
                Type[] alltype=Type.getAllType(c);
                Gson gson=new Gson();
                out.println(gson.toJson(alltype));
                c.close();
            } catch (Exception ex) {
                Logger.getLogger(GetAjax.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @CtrlAnnotation(name="activiteBouquet")
    public void getActiviteBouquet() throws IOException{
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String idBouquet=request.getParameter("idbouquet");
            Bouquet b=new Bouquet();
            b.setIdBouquet(Integer.parseInt(idBouquet));
            Connection c=Connex.connexionPostgres();
            try {
                Activite[] all=b.getActivite(c);
                Gson gson=new Gson();
                out.println(gson.toJson(all));
            } catch (Exception ex) {
                Logger.getLogger(GetAjax.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    c.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GetAjax.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }
    
    @CtrlAnnotation(name="getbouquet")
    public void getBouquet() throws IOException{
        try (PrintWriter out = response.getWriter()) {
            Connection con=Connex.connexionPostgres();
            try {
                Bouquet[] bouquets=Bouquet.getAllBouquet(con);
                Gson gson=new Gson();
                out.println(gson.toJson(bouquets));
                con.close();
            } catch (Exception ex) {
                Logger.getLogger(GetAjax.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @CtrlAnnotation(name="getvoyage")
    public void getVoyage() throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Connection c=Connex.connexionPostgres();
            try {
                Voyage[] all=Voyage.getAllVoyage(c);
                Gson gson=new Gson();
                out.println(gson.toJson(all));
                c.close();
            } catch (Exception ex) {
                Logger.getLogger(GetAjax.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @CtrlAnnotation(name="activitevoyage")
    public void getActiviteVoyage() throws Exception{
        PrintWriter out=response.getWriter();
        Connection con=Connex.connexionPostgres();
        Voyage_activite[] all=Voyage_activite.getByIdActivite(con, Integer.parseInt(request.getParameter("idactivite")));
        Gson gson=new Gson();
        out.println(gson.toJson(all));
        con.close();
    }
    
    @CtrlAnnotation(name = "getVoyagePrix")
    public void getVoyagePrix() throws Exception{
        String vola=request.getParameter("libelle");
        Connection c=Connex.connexionPostgres();
        Voyage[] getAVoyages=Voyage.getAllVoyage(c);
        Vector<Voyage> v=new Vector<>();
        
        for (int i = 0; i < getAVoyages.length; i++) {
            Set<String> key=getAVoyages[i].getCout(c).keySet();
            Object[] keyS=key.toArray();
            for (int j = 0; j < keyS.length; j++) {
                if(getAVoyages[i].getCout(c).get(keyS[j].toString())==Double.parseDouble(vola)){
                    getAVoyages[i].setLibelle(getAVoyages[i].getLibelle()+" "+getAVoyages[i].getCout(c).get(keyS[j]));
                    v.add(getAVoyages[i]);
                }
            }
        }
        c.close();
        HttpSession session=request.getSession();
        session.setAttribute("prixV", v);
        response.sendRedirect("pages/List_P.jsp");
    }
    
    @CtrlAnnotation(name="getDureVoyage")
    public void getDureVoyage() throws Exception{
        Connection con=Connex.connexionPostgres();
        int idVoyage=Integer.parseInt(request.getParameter("idvoyage"));
        System.err.println(idVoyage);
        Voyage v=Voyage.getVoyageById(con, idVoyage);
        Dure[] d=v.getDureVoyage(con);
        Gson gson=new Gson();
        PrintWriter out= response.getWriter();
        out.println(gson.toJson(d));
        con.close();
    }
    
}
