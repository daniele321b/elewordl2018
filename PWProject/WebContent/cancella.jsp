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
function deleteProd() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      var x = this.responseText;
	      getCod();
	    }
	  }
	  var cod = document.getElementById("codiceM").value;
	  xhttp.open("GET", "EliminaIteamAdmin?codice="+cod, true);
	  xhttp.send();
	}

</script>
<body onload="getCod()">
<%@ include file="header2.jsp"%>


<!--account-->
   <div class="account">
	  <div class="container">
	       <div class="account-bottom">
				<div class="col-md-6 account-left">
				
					<form name="form-ins" action="EiminaIteamAdmin" method="get" >
					<div class="account-top heading">
						<h3>elimina un prodotto</h3>
					</div>
					<span class="errore container">
						<%if(request.getParameter("errore")!=null){ %>
							<h4 ><%=request.getParameter("errore") %></h4>
						<%} %>
					</span>
					<div class="insert">
		            		<span>CODICE MODELLO</span>

		       		     <select class="" name="codiceModello" id="codiceM" >

			            </select>
			          </div>

					<div class="insert new">
						<input type="submit" name="reg-submit" value="INVIA" >
					</div>
					</form>
				</div>

				<div class="clearfix"></div>
			</div>
	  </div>
<!-- checkout -->

<%@ include file="footer2.jsp"%>

</body>
</html>
