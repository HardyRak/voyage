<%-- 
    Document   : F_voyage
    Created on : 14 déc. 2023, 07:43:06
    Author     : HARDY
--%>

<%@page import="objet.Dure"%>
<%@page import="connexion.Connex"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../assets/plugins/fontawesome-free/css/all.min.css">
        <link rel="stylesheet" href="../assets/dist/css/adminlte.min.css">
    </head>
    <body>
        <div class="card card-primary" >
            <div class="card-header">
               <h3 class="card-title">Inertion voyage</h3>
            </div>
            <form method="post" action="../voyage.ins">
                <div class="card-body">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Libelle</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Libelle" name="libelle">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputEmail1">Emplacement</label>
                        <select class="form-control" id="emplacement" name="type">
                            <option disabled>Emplacement</option>
                        </select>
                    </div>  

                    <div class="form-group">
                        <label>Date du d&eacute;part:</label>
                          <div class="input-group date" id="reservationdate" data-target-input="nearest">
                              <input type="date" class="form-control datetimepicker-input" data-target="#reservationdate" name="dateD"/>
                          </div>
                    </div>
                    
                    <div class="form-group">
                        <label>Date de retour:</label>
                          <div class="input-group date" id="reservationdate" data-target-input="nearest">
                              <input type="date" class="form-control datetimepicker-input" data-target="#reservationdate" name="dateR"/>
                          </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">Activité</label>
                        <select class="form-control" id="Bouquet" name="bouquet">
                            <option disabled>Bouquet disponible </option>         
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Duree</label>
                        <select class="form-control" id="Bouquet" name="idtype" multiple>
                            <option disabled>Duree </option>
                            <%
                                Connection c=Connex.connexionPostgres();
                                Dure[] dures=Dure.getAllDure(c);
                                c.close();
                                for(int i=0;i<dures.length;i++){
                                    %><option value="<%=dures[i].getIddure() %>"><%=dures[i].getTypeDure() %></option><%
                                }
                            %>
                        </select>
                    </div>
                </div>
                <div class="card-footer">
                    <button type="submit" class="btn btn-primary">Inser&eacute;</button>
                </div>
            </form>
    </div>
    </body>
    <script src="../assets/plugins/jquery/jquery.min.js"></script>
    <script src="../assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="../assets/dist/js/adminlte.min.js"></script>
    <script src="../assets/dist/js/demo.js"></script>
    <script src="../assets/ajax/ajax.js"></script>
    <script>
        emplacement3();
    </script>
</html>
