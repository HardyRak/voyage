/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connexion.Connex;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import objet.Activite;
import objet.Bouquet;
import objet.Client;
import objet.Dure;
import objet.Voyage;
import simpleController.CtrlAnnotation;
import simpleController.MereController;

/**
 *
 * @author HARDY
 */
@WebServlet(name = "Insert", value = "*.ins")
public class Insert extends MereController{
    
    @CtrlAnnotation(name="activite")
    public void insertActivite() throws IOException{
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nom=request.getParameter("nom");
            double vola=Double.parseDouble(request.getParameter("prix"));
            int quota=Integer.parseInt(request.getParameter("quota"));
            Connection c=Connex.connexionPostgres();
            try{
                Activite activite=new Activite();
                activite.setNom(nom);
                activite.setCout(vola);
                activite.setQuota(quota);
                activite.insertion(c);
                response.sendRedirect("pages/F_activite.jsp?reponse=Insertion reussi");
            }catch(Exception e){
                response.sendRedirect("pages/F_activite.jsp?reponse="+e.getMessage());
            }finally{
                try {
                    c.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @CtrlAnnotation(name="bouquet")
    public void ajoutBouquet() throws IOException{
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nom=request.getParameter("nom");
            String type=request.getParameter("type");
            String[] activite=request.getParameterValues("activite");
            
            Connection c=Connex.connexionPostgres();
            try{
                Bouquet bouquet=new Bouquet();
                bouquet.setNom(nom);
                bouquet.setIdType(Integer.parseInt(type));
                bouquet.insertBouquet(c, activite);
                response.sendRedirect("pages/F_bouquet.jsp?reponse=Insertion reussi");
            }catch(Exception e){
                e.printStackTrace();
                response.sendRedirect("pages/F_bouquet.jsp?reponse="+e.getMessage());                
            }finally{
                try {
                    c.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }
    
    @CtrlAnnotation(name="voyage")
    public void ajoutVoyage() throws IOException{
        try (PrintWriter out = response.getWriter()) {
            Connection con=Connex.connexionPostgres();
            try {
                String libelle=request.getParameter("libelle");
                int type = Integer.parseInt(request.getParameter("type"));
                Date dateD=Voyage.getStringToDate(request.getParameter("dateD"));
                Date dateR=Voyage.getStringToDate(request.getParameter("dateR"));
                int bouquet=Integer.parseInt(request.getParameter("bouquet"));
                String[] idtype=request.getParameterValues("idtype");
                Voyage voyage=new Voyage();
                voyage.setLibelle(libelle);
                voyage.setIdType(type);
                voyage.setDateDebut(dateD);
                voyage.setDateFin(dateR);
                voyage.setIdbouquet(bouquet);
                voyage.insetionVoyage(con, idtype);
                HttpSession session=request.getSession();
                session.setAttribute("l_voyage", Voyage.getLastVoyage(con));
                response.sendRedirect("pages/F_DureActivite.jsp?reponse=Insertion reussi");
            } catch (Exception ex) {
                Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("pages/F_voyage.jsp?reponse="+ex.getMessage());
            }finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @CtrlAnnotation(name = "insertNbrActivite")
    public void insertNbrActivite() throws IOException {
        Connection c=Connex.connexionPostgres();
        Voyage voyage;
        try {
            voyage = Voyage.getLastVoyage(c);
            Dure[] dure=voyage.getDureVoyage(c);
            for (int i = 0; i < dure.length; i++) {
                String[] activite=request.getParameterValues("activite"+dure[i].getIddure());
                String[] nombre=request.getParameterValues("nombreDure"+dure[i].getIddure());
                voyage.insertNbrActivite(c,dure[i],activite, nombre);
            }
            response.sendRedirect("pages/F_voyage.jsp?reponse=Insertion reussi");
        } catch (Exception ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("pages/F_DureActivite.jsp?reponse="+ex.getMessage());
        }finally{
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @CtrlAnnotation(name = "reservation")
    public void reservation() throws Exception{
        Connection con=Connex.connexionPostgres();
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        Date naissance=Voyage.getStringToDate(request.getParameter("naissance"));
        Voyage voyage=Voyage.getVoyageById(con, Integer.parseInt(request.getParameter("idvoyage")));
        Dure dure=Dure.getDureId(con, Integer.parseInt(request.getParameter("iddure")));
        Client cl=new Client(nom,prenom,1,naissance);
        try {
            voyage.reservationThis(con, cl, dure);
        } catch (Exception ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
