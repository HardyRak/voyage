    function activite() {
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var userData = JSON.parse(this.responseText);
            var select = document.getElementById("activite");
            userData.forEach(function(user) {
                var option = document.createElement("option");
                option.value=user.idActivite;
                option.textContent=user.nom;
                select.appendChild(option); 
            });
        }
        };
        xhr.open("GET", "/Voyage/getactivite.json", true);
        xhr.send();
    }

    function activite2() {
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var userData = JSON.parse(this.responseText);
            var select = document.getElementById("activite");
            userData.forEach(function(user) {
                var option = document.createElement("option");
                option.value=user.idActivite;
                option.textContent=user.nom;
                option.onclick=Recherche;
                select.appendChild(option); 
            });
        }
        };

        xhr.open("GET", "/Voyage/getactivite.json", true);
        xhr.send();
    }

    function emplacement() {
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var userData = JSON.parse(this.responseText);
            var select = document.getElementById("emplacement");
            userData.forEach(function(user) {
                var option = document.createElement("option");
                option.value=user.idtype;
                option.textContent=user.nom;
                select.appendChild(option); 
            });
        }
        };

        xhr.open("GET", "/Voyage/getType.json", true);
        xhr.send();
    }
    
    function activiteByBouquet() {
        var xhr = new XMLHttpRequest();
        var select = document.getElementById("bouquet");
        var selecttype=document.getElementById("emplacement");
        xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var userData = JSON.parse(this.responseText);
            var table=document.getElementById("listActivite");
            var tbody=table.children[1];
            var table_title=document.getElementById("table_title");
            table_title.innerHTML="";
            var titre=document.createElement("b");
            titre.textContent=select.children[select.selectedIndex].textContent+" "+selecttype.children[selecttype.selectedIndex].textContent;
            table_title.textContent="Activité du bouquet ";
            table_title.appendChild(titre);
            tbody.innerHTML="";
            userData.forEach(function(user) {
                var newtr=document.createElement("tr");
                var td1=document.createElement("td");
                var td2=document.createElement("td");
                var td3=document.createElement("td");
                td1.textContent=user.idActivite;
                td2.textContent=user.nom;
                td3.textContent=user.prix;
                newtr.appendChild(td1);
                newtr.appendChild(td2);
                newtr.appendChild(td3);
                tbody.appendChild(newtr);
            });
        }
        };
        xhr.open("GET", "/Voyage/activiteBouquet.json?idbouquet="+select.value, true);
        xhr.send();
    }
    
    function getBouquetType() {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var userData = JSON.parse(this.responseText);
                var select = document.getElementById("emplacement");
                var card = document.getElementById("card");
                if(card.children[2]){
                    var child=card.children[2];
                    card.removeChild(child);
                }
                var cardbody=document.createElement("div");
                cardbody.className="card-body";
                var formgroup = document.createElement("div");
                formgroup.className = "form-group"; // Use "className" instead of "class"
                var label = document.createElement("label");
                label.htmlFor = "exampleInputEmail1"; // Use "htmlFor" instead of "for"
                label.textContent="Bouquet";

                var select2 = document.createElement("select");
                select2.id="bouquet";
                select2.className = "form-control"; // Use "className" instead of "class"
                formgroup.appendChild(label);
                formgroup.appendChild(select2);
                cardbody.appendChild(formgroup);
                userData.forEach(function (user) {
                    if (user.idType == select.value) {
                        var option = document.createElement("option");
                        option.value = user.idBouquet;
                        option.textContent = user.nom;
                        option.onclick=activiteByBouquet;
                        select2.appendChild(option);
                    }
                });
                card.appendChild(cardbody);
            }
        };

        xhr.open("GET", "/Voyage/getbouquet.json", true);
        xhr.send();
    }

    
    function emplacement2() {
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var userData = JSON.parse(this.responseText);
            var select = document.getElementById("emplacement");
            userData.forEach(function(user) {
                var option = document.createElement("option");
                option.value=user.idtype;
                option.textContent=user.nom;
                option.onclick=getBouquetType;
                select.appendChild(option);
            });
        }
        };

        xhr.open("GET", "/Voyage/getType.json", true);
        xhr.send();
    }
    
    function getBouquetType3() {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var userData = JSON.parse(this.responseText);
                var select = document.getElementById("emplacement");
                var allbouquet=document.getElementById("Bouquet");
                allbouquet.innerHTML="";
                userData.forEach(function (user) {
                    if (user.idType == select.value) {
                        var option=document.createElement("option");
                        option.value = user.idBouquet;
                        option.textContent = user.nom;
                        allbouquet.appendChild(option);
                    }
                });
                card.appendChild(cardbody);
            }
        };

        xhr.open("GET", "/Voyage/getbouquet.json", true);
        xhr.send();
    }
    
    
    function emplacement3() {
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var userData = JSON.parse(this.responseText);
            var select = document.getElementById("emplacement");
            userData.forEach(function(user) {
                var option = document.createElement("option");
                option.value=user.idtype;
                option.textContent=user.nom;
                option.onclick=getBouquetType3;
                select.appendChild(option);
            });
        }
        };

        xhr.open("GET", "/Voyage/getType.json", true);
        xhr.send();
    }
    
    function getAllVoyage() {
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var userData = JSON.parse(this.responseText);
            var table=document.getElementById("donnee");
            var tbody=table.tBodies[0];
            
            userData.forEach(function(user) {
                var tr=document.createElement("tr");
                var td1=document.createElement("td");
                var td2=document.createElement("td");
                var td3=document.createElement("td");
                var td4=document.createElement("td");
                var td5=document.createElement("td");
                
                td1.textContent=user.voyage;
                td2.textContent=user.libelle;
                td3.textContent=user.prix;
                td4.textContent=user.dateDebut;
                td5.textContent=user.dateFin;
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);
                tr.appendChild(td4);
                tr.appendChild(td5);
                
                tbody.appendChild(tr);
            });
        }
        };

        xhr.open("GET", "/Voyage/getvoyage.json", true);
        xhr.send();
    }
    
    function Recherche() {
        var xhr = new XMLHttpRequest();
        var select = document.getElementById("activite");
        xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var userData = JSON.parse(this.responseText);
            var table=document.getElementById("listActivite");
            var tbody=table.children[1];
            tbody.innerHTML="";
            userData.forEach(function(user) {
                var newtr=document.createElement("tr");
                var td1=document.createElement("td");
                var td2=document.createElement("td");
                var td3=document.createElement("td");
                td1.textContent=user.voyage.libelle+" "+user.voyage.bouquet.nom+" "+user.voyage.type.nom+" "+user.dure.typeDure;
                td2.textContent=user.activite.nom;
                td3.textContent=user.nombre;
                newtr.appendChild(td1);
                newtr.appendChild(td2);
                newtr.appendChild(td3);
                tbody.appendChild(newtr);
            });
        }
        };
        xhr.open("GET", "/Voyage/activitevoyage.json?idactivite="+select.value, true);
        xhr.send();
    }