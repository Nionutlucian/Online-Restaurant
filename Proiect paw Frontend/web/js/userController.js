var app = angular.module('myApp',[]);
app.controller('usercontroller' ,function($scope,$http,$window) {
    $scope.userLogat = JSON.parse($window.sessionStorage.getItem("userLogat"));
    $scope.nume = null;
    $scope.prenume = null;
    $scope.adresa = null;
    $scope.telefon = null;
    $scope.email = null;
    $scope.parola = null
    $scope.emailLogin = null;
    $scope.parolaLogin = null;

    var checkSession = function () {

        if($window.sessionStorage.getItem("userLogat") == null){

        }
        else{
            $scope.nume1 = $scope.userLogat.nume;
            $scope.prenume1 = $scope.userLogat.prenume;
            $scope.adresa1 = $scope.userLogat.adresa;
            $scope.telefon1 = $scope.userLogat.telefon;
            $scope.email1 = $scope.userLogat.email;
        }

    };

    checkSession();




    $scope.initFunction = function () {

        console.log("sesiune:" + JSON.stringify($scope.userLogat + " " + window.location.href) + " " + $window.sessionStorage.getItem("load"));
        if(window.location.href =="http://localhost:8888/register.html" && $scope.userLogat != null){
            $window.sessionStorage.setItem("load","1");
            window.location.href = "/index.html"
        }
        else if(window.location.href =="http://localhost:8888/register.html" && $scope.userLogat == null && $window.sessionStorage.getItem("loadRegister") == null){
            $window.sessionStorage.setItem("loadRegister","1");
            window.location.href="/register.html";
        }

        if(window.location.href =="http://localhost:8888/customer-account.html" && $scope.userLogat == null){
            window.location.href = "/register.html"
        }
        else if(window.location.href =="http://localhost:8888/customer-account.html" && $scope.userLogat != null && $window.sessionStorage.getItem("loadAccount") == null){
            $window.sessionStorage.setItem("loadAccount","1");
            window.location.href="/customer-account.html";
        }

        if(window.location.href =="http://localhost:8888/customer-orders.html" && $scope.userLogat == null){
            window.location.href = "/register.html"
        }
        else if(window.location.href =="http://localhost:8888/customer-orders.html" && $scope.userLogat != null && $window.sessionStorage.getItem("loadAccount") == null){
            $window.sessionStorage.setItem("loadAccount","1");
            window.location.href="/customer-account.html";
        }


    };

    $scope.registerFunction = function (nume,prenume,adresa,telefon,email,parola){
        var obj = {
            nume : nume,
            prenume : prenume,
            adresa : adresa,
            telefon : telefon,
            email : email,
            parola : parola
        };

        console.log(JSON.stringify(obj));
        $http({ method:'POST',
            url:'http://localhost:8080/register',
            data:JSON.stringify(obj),
            headers:{'Content-type':'application/json'}})
            .then(function (response){
                console.log("a intrat");
                window.alert("Contul a fost creat cu succes!Va rugam sa va logati.")
                window.location.href = "/register.html"
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


    $scope.getIdCategorie = function (id_categorie) {
        $window.sessionStorage.setItem("id_categorie",id_categorie);
        $window.location.href = '/category.html';
    };


    $scope.afisareProduse = function () {
        $http({
            method : "GET",
            url : "http://localhost:8080/afisareProduse",
            params: {
                id_categorie: $window.sessionStorage.getItem("id_categorie")
            }
        }).then(function (response) {
            $scope.listaProduse = response.data;
            $scope.afisareCategorieCurenta();
            console.log(response.data + $window.sessionStorage.getItem("id_categorie"));
        }).catch( function (response) {
            console.log("dadsasdasdas" + $window.sessionStorage.getItem("id_categorie"));
        });
    };

    $scope.afisareComenzi = function () {
        $scope.initFunction();
        $http({
            method : "GET",
            url : "http://localhost:8080/afisareComenziDupaEmail",
            params: {
                email: JSON.parse(JSON.stringify($scope.userLogat)).email
            }
        }).then(function (response) {
            $scope.listaComenzi = response.data;
        }).catch( function (response) {
            console.log("A aparut o eroare!");
        });
    };

    $scope.cautareProdus = function () {
        $http({
            method : "GET",
            url : "http://localhost:8080/cautaProdus",
            params: {
                denumire: $window.sessionStorage.getItem("produs_cautat")
            }
        }).then(function (response) {
            $scope.listaProduse = response.data;
        }).catch( function (response) {
            console.log("A aparaut o problema!");
        });
    };

    $scope.cautatDupa=$window.sessionStorage.getItem("produs_cautat");

    $scope.cautareProdusSesiune = function (denumire) {
        $window.sessionStorage.setItem("produs_cautat",denumire);
        $window.location.href="paginacautare.html";
    };



    $scope.afisareCategorieCurenta = function () {
        $http({
            method : "GET",
            url : "http://localhost:8080/afisareCategoriiDupaId",
            params: {
                id_categorie: $window.sessionStorage.getItem("id_categorie")
            }
        }).then(function (response) {
            $scope.categorieCurenta = response.data;
            console.log("Categoria curenta este "+ $scope.categorieCurenta)
        }).catch( function (response) {
            window.alert(response);
        });
    };


    $scope.userLogin = JSON.parse($window.sessionStorage.getItem("userLogat"));


    $scope.logoutFunction = function () {
        $window.sessionStorage.clear();
        $window.localStorage.clear();
        window.location.href="/index.html"
    };


    $scope.isLogin = function () {

        if($scope.userLogat == null){
            return false;
        }
        else{
            return true;
        }

    }

    $scope.loginFunction = function (email,parola){
        console.log("suntem in login!");
        var obj = {
            email : email,
            parola : parola
        };

        console.log(JSON.stringify(obj));
        $http({ method:'POST',
            url:'http://localhost:8080/login',
            data:JSON.stringify(obj),
            headers:{'Content-type':'application/json'}})
            .then(function (response){
                console.log("Response:" + response.data);
                if(response.data != ""){
                      $window.sessionStorage.setItem("userLogat",JSON.stringify(response.data));
                    $window.location.href = '/index.html';
                }
                else{
                    window.alert("Email-ul sau parola sunt incorecte!");
                }
            }).catch(function (error){
            $scope.error = error;
            console.log(error);
            window.alert("A aparut o eroare: " + error);
        });
    };

    $scope.userLogat = JSON.parse($window.sessionStorage.getItem("userLogat"));
    $scope.getUserLogat = function () {

        if($window.sessionStorage.getItem("userLogat")!=null){

            return $scope.userLogat.nume + " " + $scope.userLogat.prenume;
        }
        else{
            return " ";
        }
    }


    $scope.updateFunction = function (nume,email,adresa,telefon,prenume){
        var obj = {
            nume : nume,
            prenume : prenume,
            adresa : adresa,
            telefon : telefon,
            email : email,
            id_user : $scope.userLogat.id_user
        };

        console.log(JSON.stringify(obj));
        $http({ method:'POST',
            url:'http://localhost:8080/update',
            data:JSON.stringify(obj),
            headers:{'Content-type':'application/json'}})
            .then(function (response){
                console.log("a intrat" + response.data);
                $window.sessionStorage.setItem("userLogat",JSON.stringify(response.data))
                console.log($window.sessionStorage.getItem("userLogat"));
                window.alert("Modificarile au fost salvate");
                window.location.href = "/customer-account.html"
                // $scope.mesaj = JSON.parse(response);
            }).catch(function (error){
            window.alert("A aparut o eroare : " + error);
            console.log(error);
        });
    };


    $scope.adaugaInCos = function (id_produs,nume_produs,pret_produs,cantitate) {


        if(!$window.sessionStorage.getItem("check")){
            $window.localStorage.setItem('cosCumparaturi',JSON.stringify([]));
        }
        $window.sessionStorage.setItem("check",1);

        var produs = {
            id:id_produs,
            denumire : nume_produs,
            pret : pret_produs,
            cantitate:cantitate
        };

        var cos =  JSON.parse($window.localStorage.getItem('cosCumparaturi'));


        if(cos.length > 0){
            for (i = 0; i < cos.length; i++) {
                if (cos[i].denumire == nume_produs) {
                    cos[i].cantitate++;
                    $window.localStorage.setItem("cosCumparaturi", JSON.stringify(cos));
                    console.log("pe if");
                    console.log(cos);
                    $scope.numarProduseCos();
                    console.log($scope.numarProduse);
                    return;
                }
            }
            $scope.numarProduseCos();
            cos.push(produs);
            $window.localStorage.setItem("cosCumparaturi",JSON.stringify(cos));
            console.log("pe else");
        }
        else{
            cos.push(produs);
            $window.localStorage.setItem("cosCumparaturi",JSON.stringify(cos));
            $scope.numarProduseCos();
        }
        console.log(cos);

    };

    $scope.numarProduseCos = function () {
        var cos = JSON.parse($window.localStorage.getItem("cosCumparaturi"));
        var count = 0;
        if(cos == null){

        }else {
            for (i = 0; i < cos.length; i++) {
                count += cos[i].cantitate;
            }
        }
       $scope.numarProduse = count;
        console.log($scope.numarProduse);
    };
    $scope.numarProduseCos();

    $scope.cos = JSON.parse($window.localStorage.getItem("cosCumparaturi"));
    console.log($scope.cos);

    $scope.getSumaTotala = function () {
        var cos = JSON.parse($window.localStorage.getItem("cosCumparaturi"));
        var suma = 0;
        if(cos!=null) {
            if (cos.length > 0) {
                for (i = 0; i < cos.length; i++) {
                    suma += (cos[i].pret * cos[i].cantitate);
                }
                return suma;
            }
            else {
                return;
            }
        }
        else{
            return 0;
        }
    }
    //$scope.getSumaTotala();


// $scope.numeC = $scope.userLogat.

    if($scope.userLogat != null) {
        $scope.numeC = JSON.parse(JSON.stringify($scope.userLogat)).nume;
        $scope.prenumeC = JSON.parse(JSON.stringify($scope.userLogat)).prenume;
        $scope.adresaC = JSON.parse(JSON.stringify($scope.userLogat)).adresa;
        $scope.telefonC = JSON.parse(JSON.stringify($scope.userLogat)).telefon;
        $scope.emailC = JSON.parse(JSON.stringify($scope.userLogat)).email;
    }
    $scope.adaugaComanda = function (nume,email,adresa,telefon,prenume){
        var id_produs = new Array();
        var pret_produs = new Array();

        var cos = JSON.parse($window.localStorage.getItem("cosCumparaturi"));


        for(i=0;i<cos.length;i++){
            id_produs.push(cos[i].id);
            pret_produs.push(cos[i].pret);
        }
        var obj = {
            data_comanda:new Date(),
            suma_totala:$scope.getSumaTotala(),
            status : 1,
            id_produs : id_produs,
            pret_produs: pret_produs,
            user_nume : nume,
            user_prenume : prenume,
            user_email : email,
            user_adresa:adresa,
            user_telefon:telefon
        };

        console.log(JSON.stringify(obj));
        $http({ method:'POST',
            url:'http://localhost:8080/adaugareComanda',
            data:JSON.stringify(obj),
            headers:{'Content-type':'application/json'}})
            .then(function (response){
                window.alert("Comanda a fost trimisa!");
                window.location.href = "/index.html"
                $window.localStorage.clear();
                $window.sessionStorage.removeItem("check");
            }).catch(function (error){
            window.alert("A aparut o eroare : " + error);
            console.log(error);
        });
    };


});

