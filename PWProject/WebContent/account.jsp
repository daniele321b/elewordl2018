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
<!--/script-->
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

function validateLogin(form) {
  var err=[];
  var j=0;

  if (isEmpty(form.email)) {
    err[j] = "Email non può essere vuoto ";
    j++;
  }else if (!validateEmail(form.email)) {
    err[j] = "L'indirizzo e-mail non è valido";
    j++;
  }

  if (isEmpty(form.password)) {
      err[j] = "Inserisci una password";
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

function validateRegistrati(form) {
  var err=[];
  var j=0;

  if (isEmpty(form.nome)) {
    err[j] = "Il nome non può essere vuoto ";
    j++;
  }else if (!allLetter(form.nome)) {
    err[j] = "Il nome deve contenere solo lettere ";
    j++;
  }
  if (isEmpty(form.cognome)) {
    err[j] = "Il cognome non può essere vuoto ";
    j++;
  }else if (!allLetter(form.cognome)) {
    err[j] = "Il cognome deve contenere solo lettere ";
    j++;
  }
  if (isEmpty(form.email)) {
    err[j] = "Email non può essere vuoto ";
    j++;
  }else if (!validateEmail(form.email)) {
    err[j] = "L'indirizzo e-mail non è valido";
    j++;
  }

  if (isEmpty(form.password) || isEmpty(form.repassword)) {
      err[j] = "Inserisci una password";
      j++;
  }else if(form.password.value!=form.repassword.value){
    err[j] = "Inserire correttamente la password nelle opportune caselle";
    j++;
  }
  if (isEmpty(form.carta)) {
	    err[j] = "Il numero di carta di credito non puo essere vuoto";
	    j++;
	 }else if (!validateCarta(form.carta)) {
	    err[j] = "Il numero di carta di credito non è corretto";
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

function allLetter(uname)
{
	var letters = /^[A-Za-z]+$/;
	return validateField(uname, letters);
}

function validateEmail(uemail)
{
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	return validateField(uemail, mailformat);
}
function validateCarta(ucarta)
{
    var cartaformat = /^[0-9]{16}$/;
	return validateField(ucarta, cartaformat);
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
  node.classList.add("errore");
  err.appendChild(node);
  err.scrollIntoView()
}
</script>
</head>
<body>
<%@ include file="header.jsp"%>


   <div class="account">
	  <div class="container">
					
				   	<span id="error" class=" container">
						<%if(request.getParameter("errore")!=null){ %>
						<p style="color: #ff0000" class="errore"><%=request.getParameter("errore") %></p>
						<%} %>
					</span>
	       <div class="account-bottom">
				<div class="col-md-6 account-left">
					<form name="form-reg" action="Register" method="post" onsubmit="return validateRegistrati(this);">
          <div class="account-top heading">
						<h3>REGISTRATI</h3>
					</div>
					<div class="address">
						<span>NOME</span>
						<input type="text" name="nome">
					</div>
					<div class="address">
						<span>COGNOME</span>
						<input type="text" name="cognome">
					</div>
					<div class="address">
						<span>EMAIL</span>
						<input type="text" name="email">
					</div>
					<div class="address">
						<span>PASSWORD</span>
						<input type="password" name="password">
					</div>
					<div class="address">
						<span>RE-INSERISCI PASSWORD</span>
						<input type="password" name="repassword">
					</div>
					<div class= "address">
						<span>NUMERO DI CARTA</span>
						<input type="text" name="carta">
					</div>
					<div class="address new">
						<input type="submit" name="reg-submit" value="Registrati">
					</div>
					</form>
				</div>
				<div class="col-md-6 account-left second">
				<%if(utente.getNome()==null){ %>
						
					<form action="Login" method="post" onsubmit="return validateLogin(this);">
						<div class="account-top heading">
							<h3>Login</h3>
						</div>
						<div class="address">
							<span>Email di registrazione</span>
							<input type="text" name="email" id="loginMail">
						</div>
						<div class="address">
							<span>Password</span>
							<input type="password" name="password" id="loginPassword">
						</div>
						<div class="address">
							<a class="forgot" href="passwordlost.jsp">Hai dimenticato la  Password?</a>
							<input type="submit" name="login" value="Login">
						</div>
					 </form>
					 <%}else{ %>
					 <div class="address">
					
					 <h3>Sei gia loggato</h3>
					  </div>
					 <%} %>
					  </div>
				 </div>
				<div class="clearfix"></div>
			</div>
	  </div>

<%@ include file="footer.jsp"%>

</body>
</html>
