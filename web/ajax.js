function sendData(dest,form) {
    var xhr; 
    try {  xhr = new ActiveXObject('Msxml2.XMLHTTP');   }
    catch (e) 
    {
        try {   xhr = new ActiveXObject('Microsoft.XMLHTTP'); }
        catch (e2) 
        {
           try {  xhr = new XMLHttpRequest();  }
           catch (e3) {  xhr = false;   }
         }
    }
    var formData = new FormData(form);// Liez l'objet FormData et l'élément form
    xhr.addEventListener("load", function(event){ // Définissez ce qui se passe si la soumission s'est opérée avec succès
      $msg=(event.target.responseText!="")?event.target.responseText:"OK";
      //alert($msg);
    });
    // Definissez ce qui se passe en cas d'erreur
    xhr.open("POST",dest);// Configurez la requête
    xhr.send(formData);// Les données envoyées sont ce que l'utilisateur a mis dans le formulaire
}


  function submitForm(destination)
  { 
      var xhr;
      try {  xhr = new ActiveXObject('Msxml2.XMLHTTP');   }
      catch (e) 
      {
          try {   xhr = new ActiveXObject('Microsoft.XMLHTTP'); }
          catch (e2) 
          { 
            try {  xhr = new XMLHttpRequest();  }
             catch (e3) {  xhr = false;   }
           }
      }
    
      xhr.onreadystatechange  = function() 
      { 
            if(xhr.readyState  == 4){
                if(xhr.status  == 200) {
                    // alert(xhr.responseText);
                    var retour = JSON.parse(xhr.responseText);
                    createInput(retour);
            } else {document.numero="Error code " + xhr.status;}
    }
      }; 
     //XMLHttpRequest.open(method, url, async)
     xhr.open("GET",destination,true); 
     //XMLHttpRequest.send(body)
     xhr.send(null); 
}

  function createInput(table)
    {
        var div=document.getElementById("submitRes");
        var input=document.createElement("select");
        var label=document.createElement("label");
        label.className="col-sm-2";
        label.textContent="dure";
        input.className="form-control";
        input.name="iddure";
        var referenceChild=document.getElementById("next");
        div.insertBefore(label,referenceChild);
        div.insertBefore(input,referenceChild);
        table.forEach(function(user) {
          var option = document.createElement("option");
          option.value=user.iddure;
          option.textContent=user.typeDure;
          input.appendChild(option); 
      });
        referenceChild.disabled=true;
        var sub=document.getElementById("submit");
        sub.disabled=false;
    }

    window.addEventListener("load",function () {
        var sub=this.document.getElementById("next");
        sub.addEventListener("click",function() {
          var idVoyage=document.getElementById("voyage").value;
          submitForm("getDureVoyage.json?idvoyage="+idVoyage);
        });
    });
