<%-- 
    Document   : L_bouquet
    Created on : 13 déc. 2023, 21:41:48
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
        <div id="card" class="card card-primary" >
            <div class="card-header">
               <h3 class="card-title">Liste des bouquet</h3>
            </div>
            
            <div class="card-body">
                <div class="form-group">
                    <label for="exampleInputEmail1">Emplacement</label>
                    <select class="form-control" id="emplacement" name="type">
                        <option disabled>Emplacement</option>
                    </select>
                </div>
            </div>
            
        </div>
        <div class="card">
            <div class="card-header">
                <h3 class="card-title" id="table_title">Activit&eacute;s </h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                  <table id="listActivite" class="table table-bordered">
                    <thead>
                      <tr>
                        <th style="width: 10px">Numero</th>
                        <th>Nom</th>
                        <th>Activite</th>
                      </tr>
                    </thead>
                    <tbody>
                      
                    </tbody>
                </table>
              </div>
        </div>
     <script src="../assets/plugins/jquery/jquery.min.js"></script>
    <script src="../assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="../assets/dist/js/adminlte.min.js"></script>
    <script src="../assets/dist/js/demo.js"></script>
    <script src="../assets/ajax/ajax.js"></script>
    <script>
        emplacement2();
    </script>
    </body>
</html>
