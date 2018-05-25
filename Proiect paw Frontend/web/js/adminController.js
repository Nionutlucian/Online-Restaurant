var app = angular.module('myApp',[]);
app.controller('admincontroller' ,function($scope,$http,$window) {

    $scope.denumire_categorie = null;


    $scope.adaugareCategorie = function (denumireCategorie){
        var obj = {
            denumire_categorie : denumireCategorie
        };

        console.log(JSON.stringify(obj));
        $http({ method:'POST',
            url:'http://localhost:8080/adaugareCategorie',
            data:JSON.stringify(obj),
            headers:{'Content-type':'application/json'}})
            .then(function (response){
                console.log("a intrat" + response.data);
                window.alert("Categorie a fost adaugata cu succes!");
                window.location.href = "/dashboard.html"
                // $scope.mesaj = JSON.parse(response);
            }).catch(function (error){
            window.alert("A aparut o eroare : " + error);
            console.log(error);
        });
    };



    $scope.afisareCategorii = function () {
        $http({
            method : "GET",
            url : "http://localhost:8080/afisareCategorii"
        }).then(function (response) {
            $scope.listaCategorii = response.data;
            console.log(listaCategorii);
        }).catch( function (response) {

        });
    };
    $scope.afisareCategorii();




    $scope.adaugareProdus = function (denumireProdus,pretProdus,detaliiProdus,id_categorie){
        var obj = {
            denumire_produs : denumireProdus,
            pret_produs : pretProdus,
            detalii_produs : detaliiProdus,
            imagine:document.getElementById("imagine").value,
            id_categorie:id_categorie
        };

        console.log(JSON.stringify(obj));
        $http({ method:'POST',
            url:'http://localhost:8080/adaugareProdus',
            data:JSON.stringify(obj),
            headers:{'Content-type':'application/json'}})
            .then(function (response){
                console.log("a intrat" + response.data);
                window.alert("Produsul a fost adaugata cu succes!");
                window.location.href = "/dashboard.html"
            }).catch(function (error){
            window.alert("A aparut o eroare : " + error);
            console.log(error);
        });
    };


    $scope.afisareCategorii = function () {
        $http({
            method : "GET",
            url : "http://localhost:8080/afisareCategorii"
        }).then(function (response) {
            $scope.listaCategorii = response.data;
            console.log(listaCategorii);
        }).catch( function (response) {

        });
    };
    $scope.afisareCategorii();

    $scope.denumireCategorie = null;

    $scope.updateCategory = function (){
        var obj = {
            denumire_categorie : document.getElementById("denumireCategorie").value
        };

        console.log( document.getElementById("denumireCategorie").value);
        $http({ method:'POST',
            url:'http://localhost:8080/updateCategorie',
            data:JSON.stringify(obj),
            headers:{'Content-type':'application/json'}})
            .then(function (response){
                window.alert("Modificarile au fost salvate");
                window.location.href="gestionarecategorii.html";
                // $scope.mesaj = JSON.parse(response);
            }).catch(function (error){
            window.alert("A aparut o eroare : " + error);
        });
    };


    $scope.stergeCategorie = function () {
        console.log(document.getElementById("id_categorie").value);
        $http({
            method : "DELETE",
            url : "http://localhost:8080/stergeCategorie",
            params: {
                id: document.getElementById("id_categorie").value
            }
        }).then(function (response) {
            window.alert("Categorie stearsa cu succes!");
            window.location.href="gestionarecategorii.html";
        }).catch( function (response) {
            window.alert("A aparut o eroare");
        });
    };





    $scope.afisareProduse = function () {
        $http({
            method : "GET",
            url : "http://localhost:8080/afisareProduseToate"
        }).then(function (response) {
            $scope.listaProduse = response.data;

        }).catch( function (response) {

        });
    };

    $scope.afisareProduse();


    $scope.afisareComenzi = function () {
        $http({
            method : "GET",
            url : "http://localhost:8080/afisareComenzi"
        }).then(function (response) {
            $scope.listaComenzi = response.data;

        }).catch( function (response) {

        });
    };

    $scope.afisareComenzi();

    $scope.aprobaComanda = function (id_comanda) {
        $http({
            method: "GET",
            url: "http://localhost:8080/updateStatusComanda",
            params: {
                id_comanda: id_comanda,
                status: "0"
            }
        }).then(function (response) {
            window.alert("Comanda aprobata!");
            window.location.href = "administrarecomenzi.html"

        }).catch(function (response) {
            window.alert("A aparut o eroare!");
            window.location.href = "administrarecomenzi.html"
        });
    };




        $scope.refuzaComanda = function (id_comanda) {
            $http({
                method : "GET",
                url : "http://localhost:8080/updateStatusComanda",
                params: {
                    id_comanda: id_comanda,
                    status:"2"
                }
            }).then(function (response) {
                window.alert("Comanda refuzata!");
                window.location.href="administrarecomenzi.html"

            }).catch( function (response) {
                window.alert("A aparut o eroare!");
                window.location.href="administrarecomenzi.html"
            });

        };












});