<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE HTML>
<html>
<head>
<title>EleWorld</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/slide2.css" rel='stylesheet' type='text/css' />
<script src="js/jquery-1.11.1.min.js"></script>
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/menu_jquery.js"></script>
<!--web-fonts-->
 <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,300italic,600,700' rel='stylesheet' type='text/css'>
 <link href='//fonts.googleapis.com/css?family=Roboto+Slab:300,400,700' rel='stylesheet' type='text/css'>
<!--//web-fonts-->
 <script src="js/scripts.js" type="text/javascript"></script>
<script type="text/javascript" src="js/easing.js"></script>

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



function validateInfo(form) {
  var err=[];
  var j=0;

  if (isEmpty(form.paese)) {
    err[j] = "Il paese non può essere vuoto ";
    j++;
  }else if (!allLetter(form.paese)) {
    err[j] = "Il paese deve contenere solo lettere ";
    j++;
  }
  if (isEmpty(form.provincia)) {
    err[j] = "La provincia non può essere vuoto ";
    j++;
  }else if (!allLetter(form.provincia)) {
    err[j] = "La provincia deve contenere solo lettere ";
    j++;
  }
  if (isEmpty(form.citta)) {
    err[j] = "La citta non può essere vuoto ";
    j++;
  }else if (!allLetterSpace(form.citta)) {
    err[j] = "La citta deve contenere solo lettere ";
    j++;
  }
  if (isEmpty(form.via)) {
    err[j] = "La via non può essere vuoto ";
    j++;
  }else if (!allLetterSpace(form.via)) {
    err[j] = "La via deve contenere solo lettere ";
    j++;
  }
  if (isEmpty(form.cap)) {
    err[j] = "Il cap non può essere vuoto ";
    j++;
  }else if (!allNumber(form.cap)) {
    err[j] = "Il cap deve contenere solo numeri ";
    j++;
  }
  if (isEmpty(form.civico)) {
    err[j] = "Il civico non può essere vuoto ";
    j++;
  }else if (!allNumber(form.civico)) {
    err[j] = "Il civico deve contenere solo numeri ";
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
function allNumber(uadd)
{
	var letters = /^[0-9]+$/;
	return validateField(uadd, letters);
}
function allLetter(uname)
{
	var letters = /^[A-Za-z]+$/;
	return validateField(uname, letters);
}
function allLetterSpace(uname)
{
	var letters = /^[a-zA-Z\s]*$/;
	return validateField(uname, letters);
}
function validateEmail(uemail)
{
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	return validateField(uemail, mailformat);
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
<body>
<%@ include file="header.jsp"%>

<!--account-->
   <div class="account">
	  <div class="container">

      <span id="error" class=" container">
						<%if(request.getParameter("errore")!=null){ %>
						<h4><%=request.getParameter("errore") %></h4>
						<%} %>
					</span>
	       <div class="account-bottom">
				<div class="col-md-6 account-left">
					<form name="form-ins" action="AddInfoUtente" method="get" onsubmit="return validateInfo(this);">
					<div class="account-top heading">
						<h3>Aggiungi infromazioni</h3>
					</div>
					<input type="hidden" name="mail" value="<%=request.getParameter("email") %>" />
					<div class= "address">
						<span>PAESE</span>
						<input type="text" name="paese">
					</div>
					<div class= "address">
						<span>PROVINCIA (iniziali)</span>
						<input type="text" name="provincia">
					</div>
					<div class= "address">
						<span>CITTA'</span>
						<input type="text" name="citta">
					</div>
					<div class= "address">
						<span>VIA'</span>
						<input type="text" name="via" >
					</div>
					<div class= "address">
						<span>CAP</span>
						<input type="text" name="cap">
					</div>
					<div class= "address">
						<span>CIVICO</span>
						<input type="text" name="civico">
					</div>

					

					<div class="address new">
						<input type="submit"  value="Invia">
					</div>
					</form>
				</div>

				<div class="clearfix"></div>
			</div>
	  </div>
<!-- checkout -->

<%@ include file="footer.jsp"%>

</body>
</html>
