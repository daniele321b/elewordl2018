<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE HTML>
<html>
<head>
<title>EleWorld Administrator</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style2.css" rel='stylesheet' type='text/css' />
<link href="/css/slide2.css" rel='stylesheet' type='text/css' />
<script src="js/jquery-1.11.1.min.js"></script>
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/menu_jquery.js"></script>
<!--web-fonts-->
 <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,300italic,600,700' rel='stylesheet' type='text/css'>
 <link href='//fonts.googleapis.com/css?family=Roboto+Slab:300,400,700' rel='stylesheet' type='text/css'>
<!--//web-fonts-->
<!--/script-->
<script src="js/ajax.js"></script>
<script type="text/javascript">

function autoFillProd() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      var x = JSON.parse(this.responseText);
      removeOP();
      fill(x);
    }
  }
  var cod = document.getElementById("codiceM").value;
  xhttp.open("GET", "FillAdmin?codice="+cod, true);
  xhttp.send();
}


function fill(prod) {
  var nome = document.getElementsByName("nome")[0];
  nome.setAttribute("value", prod.nome);
  var produttore = document.getElementsByName("produttore")[0];
  produttore.setAttribute("value", prod.produttore);
  var colore = document.getElementsByName("colore")[0];
  colore.setAttribute("value", prod.colore);
  var prezzo = document.getElementsByName("prezzo")[0];
  prezzo.setAttribute("value", prod.prezzo);
  var prezzoS= document.getElementsByName("prezzoScont")[0];
  prezzoS.setAttribute("value", prod.prezzoS);
  var peso = document.getElementsByName("peso")[0];
  peso.setAttribute("value", prod.peso);
  var  altezza = document.getElementsByName("altezza")[0];
  altezza.setAttribute("value", prod.altezza);
  var profondita = document.getElementsByName("profondita")[0];
  profondita.setAttribute("value", prod.profondita);
  var larghezza = document.getElementsByName("larghezza")[0];
  larghezza.setAttribute("value", prod.larghezza);
  var  descrizione = document.getElementsByName("descrizione")[0];
  descrizione.setAttribute("value", prod.descrizione);
  var giacenza = document.getElementsByName("giacenza")[0];
  giacenza.setAttribute("value", prod.giacenza);


  var select = document.getElementById("category");
  var op = document.createElement("option");
  op.setAttribute("value", prod.categoria);
  op.appendChild(document.createTextNode(prod.categoria));
  select.appendChild(op);
}

function removeOP() {
  var selectR = document.getElementById("category");
  var opR = selectR.childNodes[0];
  selectR.removeChild(opR);
}

function validateField(field, format)
{
    if(field.value.match(format))
		return true;
    else
		return false;
}

function isEmpty(field){
    if(field.value.length <= 0)
		return true;
    else
		return false;
}

function validateModifica(form) {
  var err=[];
  var j=0;

  if (isEmpty(form.nome)) {
    err[j] = "Il nome non può essere vuoto ";
    j++;
  }else if (!alphanumeric(form.nome)) {
    err[j] = "Il nome deve contenere solo lettere ";
    j++;
  }
  if (isEmpty(form.produttore)) {
    err[j] = "Il produttore non può essere vuoto ";
    j++;
  }else if (!allLetter(form.produttore)) {
    err[j] = "Il produttore deve contenere solo lettere ";
    j++;
  }
  if (isEmpty(form.colore)) {
    err[j] = "Il colore non può essere vuoto ";
    j++;
  }else if (!allLetter(form.colore)) {
    err[j] = "Il colore deve contenere solo lettere ";
    j++;
  }
  if (isEmpty(form.prezzo)) {
    err[j] = "Il prezzo non può essere vuoto ";
    j++;
  }else if (!decimalNumber(form.prezzo)) {
    err[j] = "Formato del prezzo non valido";
    j++;
  }
  if (isEmpty(form.prezzoScont)) {
    err[j] = "Il prezzo non può essere vuoto ";
    j++;
  }else if (!decimalNumber(form.prezzoScont)) {
    err[j] = "Formato del prezzo scontato non valido";
    j++;
  }
  if (isEmpty(form.peso)) {
    err[j] = "Il peso non può essere vuoto ";
    j++;
  }else if (!decimalNumber(form.peso)) {
    err[j] = "Formato del peso non valido";
    j++;
  }
  if (isEmpty(form.altezza)) {
    err[j] = "L'altezza non può essere vuoto ";
    j++;
  }else if (!decimalNumber(form.peso)) {
    err[j] = "Formato dell' altezza non valido";
    j++;
  }
  if (isEmpty(form.profondita)) {
    err[j] = "La profondita non può essere vuoto ";
    j++;
  }else if (!decimalNumber(form.profondita)) {
    err[j] = "Formato della profondita non valido";
    j++;
  }
  if (isEmpty(form.larghezza)) {
    err[j] = "La larghezza non può essere vuoto ";
    j++;
  }else if (!decimalNumber(form.larghezza)) {
    err[j] = "Formato della larghezza non valido";
    j++;
  }
  if (isEmpty(form.descrizione)) {
    err[j] = "La descrizione non può essere vuoto ";
    j++;
  }else if (!allLetterSpace(form.descrizione)) {
    err[j] = "La descrizione deve contenere solo lettere ";
    j++;
  }
  if (isEmpty(form.giacenza)) {
    err[j] = "La giacenza non può essere vuoto ";
    j++;
  }else if (!allNumber(form.giacenza)) {
    err[j] = "La giacenza deve contenere solo numeri ";
    j++;
  }

  if (err.length>0) {
    removeError();
    for (var i = 0; i < err.length; i++) {
      addError(err[i]);
    }
    return false;
  }

  return true;
}

function alphanumeric(uadd)  
{   
	var letters = /^[0-9a-zA-Z\s]+$/;  
	return validateField(uadd, letters);
}
function allNumber(uadd)
{
	var letters = /^[0-9]+$/;
	return validateField(uadd, letters);
}
function allLetterSpace(uname)
{
	var letters = /^[a-zA-Z\s]*$/;
	return validateField(uname, letters);
}

function allLetter(uname)
{
	var letters = /^[A-Za-z]+$/;
	return validateField(uname, letters);
}
function decimalNumber(uadd)
{
	var letters = /^[0-9]\d*(\.\d{0,2})?$/;
	return validateField(uadd, letters);
}
function removeError() {
  var err  = document.getElementById("error");
  var child = document.getElementById("error").childNodes;
  for (var i = 0; i < child.length; i++) {
    if (child[i].tagName=="P" || child[i].tagName=="H4") {
      err.removeChild(child[i]);
      i=0;
    }
  }
}

function addError(text) {
  var err  = document.getElementById("error");
  var node = document.createElement("P");
  node.appendChild(document.createTextNode(text));
  node.style.color = "#ff0000";
  err.appendChild(node);
  err.scrollIntoView()
}
</script>
</head>
<body onload="getCod()">
<%@ include file="header2.jsp"%>
   <div class="account">
	  <div class="container">
	  	<span id="error" class=" container">
						<%if(request.getParameter("errore")!=null){ %>
						<h4><%=request.getParameter("errore") %></h4>
						<%} %>
					</span>
	       <div class="account-bottom">
				<div class="col-md-6 account-left">
					<form name="form-ins" action="ModificaIteamAdmin" method="post" onsubmit="return validateModifica(this);">
					<div class="account-top heading">
						<h3>Modifica un prodotto</h3>
					</div>
					</span>
					<div class="insert">
		            		<span>CODICE MODELLO</span>

		       		     <select class="" name="codiceModello" id="codiceM" onchange="autoFillProd()">

			            </select>
			          </div>
					<div class="insert">
						<span>NOME</span>
						<input type="text" name="nome">
					</div>
					<div class="insert">
						<span>PRODUTTORE</span>
						<input type="text" name="produttore">
					</div>
					<div class="insert">
						<span>COLORE</span>
						<input type="text" name="colore">
					</div>
					<div class="insert">
						<span>PREZZO €</span>
						<input type="text" name="prezzo">
					</div>
					<div class="insert">
						<span>PREZZO SCONTATO €</span>
						<input type="text" name="prezzoScont">
					</div>
					<div class="insert">
						<span>PESO (kg)</span>
						<input type="text" name="peso">
					</div>
					<div class="insert">
						<span>ALTEZZA (cm)</span>
						<input type="text" name="altezza">
					</div>
					<div class="insert">
						<span>PROFONDITA' (cm)</span>
						<input type="text" name="profondita" >
					</div>
					<div class="insert">
						<span>LARGHEZZA (cm)</span>
						<input type="text" name="larghezza">
					</div>
					<div class="insert">
						<span>DESCRIZIONE</span>
						<input type="text" name="descrizione">
					</div>
					<div class="insert">
						<span>GIACENZA</span>
						<input type="text" name="giacenza">
					</div>
		          <div class="insert">
		            <span>CATEGORIA</span>
		            <select class="" name="categoria" id="category">

		            </select>
		          </div>
					<div class="insert new">
						<input type="submit"  value="Invia">
					</div>
					</form>
				</div>

				<div class="clearfix"></div>
			</div>
	  </div>

<%@ include file="footer2.jsp"%>

</body>
</html>
