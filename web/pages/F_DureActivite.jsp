<%-- 
    Document   : F_DureActivite
    Created on : 4 janv. 2024, 07:11:22
    Author     : HARDY
--%>

<%@page import="objet.Activite"%>
<%@page import="objet.Bouquet"%>
<%@page import="objet.Dure"%>
<%@page import="objet.Voyage"%>
<%@page import="java.sql.Connection"%>
<%@page import="connexion.Connex"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Connection con=Connex.connexionPostgres();
    Voyage last=Voyage.getLastVoyage(con);
    Dure[] dure=last.getDureVoyage(con);
    Bouquet bouquet=last.getBouquet();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
        <link rel="stylesheet" href="../assets/plugins/fontawesome-free/css/all.min.css">
        <link rel="stylesheet" href="../assets/dist/css/adminlte.min.css">
    </head>
    <body>
        <form method="POST" action="../insertNbrActivite.ins">
            <%
            for(int i=0;i<dure.length;i++){
            %>
                <div class="card">
                  <div class="card-header">
                    <h3 class="card-title"><%=dure[i].getTypeDure() %></h3>
                    <p></p>
                    <h3 class="card-title"><%=bouquet.getNom() %></h3>
                  </div>
                  <!-- /.card-header -->
                  <div class="card-body">
                    <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th style="width: 10px">#</th>
                          <th>Activite</th>
                          <th>Nombre</th>
                        </tr>
                      </thead>
                      <tbody>
                        <%
                            Activite[] activites=bouquet.getActivite(con);
                            for(int j=0;j<activites.length;j++){
                            %>
                                <tr>
                                    <td></td>
                                    <td><%=activites[j].getNom() %><input type="hidden" name="activite<%=dure[i].getIddure() %>" value="<%=activites[j].getIdActivite()%>"></td>
                                    <td>
                                      <div class="form-group">
                                          <input type="number" class="form-control" name="nombreDure<%=dure[i].getIddure() %>">
                                      </div>
                                    </td>
                                  </tr>
                            <% }
                        %>
                      </tbody>
                    </table>
                  </div>
            </div>
            <% }
        %>
        <input type="submit" class="form-control bg-light" value="valider">
        </form>
    </body>
</html>
<%
    con.close();
%>