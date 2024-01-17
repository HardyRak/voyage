<%
    
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>reservation</title>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="ajax.js"></script>
    <link rel="stylesheet" href="assets/css/myCss.css">
</head>
<body>

    <div class="container" id="reservation">
        <form method="POST" action="reservation.ins" class="form-horizontal" role="form">
            <div class="form-group">
                <div class="col-sm-6 col-sm-offset-3">
                    <legend>Reservation</legend>
                </div>  
        </div>
            <div class="form-group">
                <div class="col-sm-6 col-sm-offset-3">
                    <label for="input-id" class="col-sm-2">nom</label>
                    <input type="nom" name="nom" id="nom" class="form-control" value="" required="required" title="" placeholder="nom">
                </div>
            </div>
                <div class="form-group">
                    <div class="col-sm-6 col-sm-offset-3">
                        <label for="input-id" class="col-sm-2">prenom</label>
                        <input type="text" name="prenom" id="prenom" class="form-control" value="" required="required" title="" placeholder="prenom">
                    </div>
                </div>
            <div class="form-group">
                <div class="col-sm-6 col-sm-offset-3">
                    <label for="input-id" class="col-sm-2">Date de naissance</label>
                    <input type="Date" name="naissance" id="DateNaissance" class="form-control" value="" required="required" title="" placeholder="Date de naissance">
                   
                </div>
            </div>

        <div class="form-group" >
            <div class="col-sm-6 col-sm-offset-3" id="submitRes">
                    <label for="input-id" class="col-sm-2">voyage</label>
                    <select name="idvoyage" id="voyage" class="form-control" required="required">
                        <option value="11" >gold</option>
                    </select>
                    <button type="button" class="btn btn-primary submit" id="next">next</button>
                    <button type="submit" class="btn btn-primary submit" id="submit" disabled="true">submit</button>

            </div>
                
        </div>
            
    </form>
</div>
    
</body>
</html>