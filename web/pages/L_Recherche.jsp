<%-- 
    Document   : F_Recherche
    Created on : 4 janv. 2024, 09:17:05
    Author     : HARDY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../assets/plugins/fontawesome-free/css/all.min.css">
        <link rel="stylesheet" href="../assets/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="../assets/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
        <link rel="stylesheet" href="../assets/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
        <link rel="stylesheet" href="../assets/dist/css/adminlte.min.css">

    </head>
    <body>
        <div id="card" class="card card-primary" >
            <div class="card-header">
               <h3 class="card-title">Recherche</h3>
            </div>
            
            <div class="card-body">
                <div class="form-group">
                    <label for="exampleInputEmail1">Activit&eacute;</label>
                    <select class="form-control" id="activite" name="activite">
                        <option disabled>Activité disponible </option>         
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
                        <th>Nom</th>
                        <th>Avtivite</th>
                        <th>Nombre</th>
                      </tr>
                    </thead>
                    <tbody>
                      
                    </tbody>
                </table>
              </div>
        </div>
    </body>
    <script src="../assets/plugins/jquery/jquery.min.js"></script>
    <script src="../assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="../assets/plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="../assets/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
    <script src="../assets/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
    <script src="../assets/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
    <script src="../assets/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
    <script src="../assets/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
    <script src="../assets/plugins/jszip/jszip.min.js"></script>
    <script src="../assets/plugins/pdfmake/pdfmake.min.js"></script>
    <script src="../assets/plugins/pdfmake/vfs_fonts.js"></script>
    <script src="../assets/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
    <script src="../assets/plugins/datatables-buttons/js/buttons.print.min.js"></script>
    <script src="../assets/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
    <script src="../assets/dist/js/adminlte.min.js"></script>
    <script src="../assets/dist/js/demo.js"></script>
    <script src="../assets/ajax/ajax.js"></script>
    <script>
        activite2();
    </script>
</html>
