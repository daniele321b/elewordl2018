<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.*"%>
 <%@page import="it.unisa.data.ProdottiBean"%>
<jsp:useBean id="admin" class="it.unisa.data.UtenteBean" scope="session"></jsp:useBean>

<!DOCTYPE HTML>
<html>
<head>
<!--<title>EleWorld Administrator</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style2.css" rel='stylesheet' type='text/css' />
<link href="/css/slide2.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="css/search.css">
<script src="js/jquery-1.11.1.min.js"></script>
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/menu_jquery.js"></script>
 <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,300italic,600,700' rel='stylesheet' type='text/css'>
 <link href='//fonts.googleapis.com/css?family=Roboto+Slab:300,400,700' rel='stylesheet' type='text/css'>
 <script src="js/scripts.js" type="text/javascript"></script>
<script src="js/modernizr.custom.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
script-->

</head>
<body>
<!--start-home-->
<div class="top_bg" id="home">
</div>
<!--header-->
<div class="header_bg">
   <div class="container">
	<div class="header">
	  <div class="head-t">
		 <div class="logo">
       <table>
          <tr>
              <td>
              			  <a href="index2.jsp">	
          <img src="img/logo1.png " >
        </a>
        </td>
          
</tr>
</table>

		  </div>
		  <div class="header_right">
		  	<!-- Modifica -->
		  	<div class ="user">
		  		
		  			<span>
		  				<%if(admin.getNome()!=null){ %>
		  				<h3><%= admin.getNome()%></h3>
		  				<%} %>
		  			</span>
		  		</a>
		  	</div>
		  	<!-- Modifica -->
			
		</div>
		<div class="clearfix"></div>
	    </div>
		<!--start-header-menu-->
		<ul class="megamenu skyblue">
			<li class="active grid"><a class="color1" href="LogoutAdmin">LOGOUT</a></li>

		<li><a class="color5" href="inserisci.jsp">INSERISCI</a></li>
        <li><a class="color5" href="modifica.jsp">MODIFICA</a></li>
        <li><a class="color5" href="cancella.jsp">ELIMINA</a></li>
</ul>

	</div>
</div>
</div>
 <!--start-content-->
		 <!--start-banner-->

</body>
</html>
