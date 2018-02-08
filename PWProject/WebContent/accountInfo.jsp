<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
</head>
<body>
<%@ include file="header.jsp"%>

<div class="account-top heading">
	
</div>
<!--account-->
   <div class="account">
	  <div class="container">
	       <div class="account-bottom">
				<div class="col-md-6 account-left">
					<div class="account-top heading">
						<h3>Le tue infromazioni</h3>
					</div>
					<div class= "address">
						<span>E-Mail</span>
						<h3><%=utente.getMail() %></h3> <a style="color: #ff0000" class="h4" href="LogoutS">ESCI</a>
					</div>
					<div class= "address">
						<span>Nome</span>
						<h3><%=utente.getNome() %></h3>
					</div>
					<div class= "address">
						<span>Cognome</span>
						<h3><%= utente.getCognome() %></h3>
					</div>
					<div class= "address">
						<span>Indirizzo</span>
						<h3><jsp:getProperty property="paese" name="utente"/></h3>
						<h3><jsp:getProperty property="citta" name="utente"/></h3>
						<h3><jsp:getProperty property="via" name="utente"/> <jsp:getProperty property="civico" name="utente"/>, <jsp:getProperty property="provincia" name="utente"/></h3>
						<h3><jsp:getProperty property="cap" name="utente"/></h3>
					</div>
				</div>

				<div class="clearfix"></div>
			</div>
	  </div>
<!-- checkout -->

<%@ include file="footer.jsp"%>
</body>
</html>