<%-- 
    Document   : F_choixVoyage.jsp
    Created on : 09-Jan-2024, 15:12:06
    Author     : rohyr
--%>

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
            <form method="post" action="../getVoyagePrix.json">
              <div class="card-body">
                <div class="form-group">
                        <label for="exampleInputEmail1">entrez montant</label>
                        <input type="number" class="form-control" id="exampleInputEmail1" placeholder="Libelle" name="libelle">
                </div>
              </div>
                <div class="card-footer">
                    <button type="submit" class="btn btn-primary">Inser&eacute;</button>
                </div>
            </form>
            
        </div>
    </body>
</html>
