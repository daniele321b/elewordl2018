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

function validateInserisci(form) {
  var err=[];
  var j=0;

  if (isEmpty(form.nome)) {
    err[j] = "Il nome non può essere vuoto ";
    j++;
  }else if (!alphanumeric(form.nome)) {
    err[j] = "Il nome deve contenere solo lettere e numeri";
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
<body onload="getCat()">
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
					<form name="form-ins" action="InsertIteamAdmin" method="post" enctype="multipart/form-data" onsubmit="return validateInserisci(this);">
					<div class="account-top heading">
						<h3>Inserisci un prodotto</h3>
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
						<input type="text" name="profondita">
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
		            <span>Categoria</span>
		            <select class="" name="categoria" id="category">

		            </select>
		          </div>
					<div class="insert">
						<span>IMMAGINE</span>
						<input type="file" name="img">
					</div>

					<div class="insert new">
						<input type="submit" value="Invia">
					</div>
					</form>
				</div>

				<div class="clearfix"></div>
			</div>
	  </div>

<%@ include file="footer2.jsp"%>

</body>
</html>
