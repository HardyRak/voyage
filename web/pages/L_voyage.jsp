<%-- 
    Document   : L_voyage
    Created on : 14 déc. 2023, 12:09:48
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
        <div class="card">
              <div class="card-header">
                  <h3 class="card-title">Liste des voyage organis&eacute;</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="donnee" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>Numero</th>
                    <th>Libelle</th>
                    <th>Prix</th>
                    <th>Date du Depart</th>
                    <th>Date de retour</th>
                  </tr>
                  </thead>
                  <tbody>
                      
                  </tbody>
                  <tfoot>
                  <tr>
                    <th>Numero</th>
                    <th>Libelle</th>
                    <th>Prix</th>
                    <th>Date du Depart</th>
                    <th>Date de retour</th>
                  </tr>
                  </tfoot>
                </table>
              </div>
              <!-- /.card-body -->
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
      getAllVoyage();
    </script>
    
</html>
