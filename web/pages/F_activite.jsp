<%-- 
    Document   : F_activite
    Created on : 13 déc. 2023, 20:15:51
    Author     : HARDY
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
            <div class="card-header">
                <h3 class="card-title">Inertion Activit&eacute;</h3>
            </div>
            <form method="post" action="../activite.ins">
                <div class="card-body">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Nom</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nom" name="nom">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputEmail1">Prix (Ariary)</label>
                        <input type="number" step="0.01" class="form-control" id="exampleInputEmail1" placeholder="Co&ucirc;t de l'activit&eacute;" name="prix">
                    </div> 
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">Quota</label>
                        <input type="number" step="1" class="form-control" id="exampleInputEmail1" placeholder="Co&ucirc;t de l'activit&eacute;" name="quota">
                    </div> 
                    
                </div>
                <div class="card-footer">
                    <button type="submit" class="btn btn-primary">Valid&eacute;</button>
                </div>
            </form>
    </div>
    </body>
    <script src="../assets/plugins/jquery/jquery.min.js"></script>
    <script src="../assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="../assets/dist/js/adminlte.min.js"></script>
    <script src="../assets/dist/js/demo.js"></script>
    <script src="../assets/ajax/ajax.js"></script>
</html>
