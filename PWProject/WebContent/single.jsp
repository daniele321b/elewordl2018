<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="prodotto"  class="it.unisa.data.ProdottiBean" scope="request"></jsp:useBean>    
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
function disableB(){
	var x =  document.getElementById("product-qty").innerHTML;
	console.log(x);
	var y = document.getElementsByClassName("item_add");
	var child = y[0].childNodes;
	  for (var i = 0; i < child.length; i++) {
		    if (x==0) {
		    	  if (child[i].tagName=="A" )
		    		  child[i].removeAttribute("href");
		    	  if (child[i].tagName=="input" ) {
		    		  child[i].disabled = true;
		    }
		  }
	  }
}
</script>
</head>
<body onload="disableB()">
<%@ include file="header.jsp"%>

<!-- products -->
	<div class="products">
		<div class="container">
			<div class="products-grids">
				<div class="col-md-8 products-single">
				<div class="col-md-5 grid-single">
          <div class="thumb-image" style=" width: 100%; display: block;">
						<img src=images/<%=prodotto.getImmagine()%>>
</div>
					</div>
				<div class="col-md-7 single-text">
					<div class="details-left-info simpleCart_shelfItem">
						<h3><jsp:getProperty property="nome" name="prodotto"/></h3>
						<p class="availability">Disponibile: 
						<span class="color">
							<%if (prodotto.getGiacenza()>0){%>
								Si
							<%}else {%>
								No
								<%} %>
						</span></p>
						<div class="price_single">
							<%if((prodotto.getPrezzoScontato() == 0) || (prodotto.getPrezzoScontato()== 0.0) || (prodotto.getPrezzoScontato()== prodotto.getPrezzo())) {%>
							<span class="actual item_price">€<%= prodotto.getPrezzo()%></span>
							<%}else {%>
							<span class="reducedfrom">€<%= prodotto.getPrezzo()%></span>
							<span class="actual item_price">€<%= prodotto.getPrezzoScontato()%></span>
							<%} %>
						</div>
						<h2 class="quick">Descrizione</h2>
						<p class="quick_desc">PRODUTTORE <jsp:getProperty property="produttore" name="prodotto"/><br>
						MISURE <jsp:getProperty property="altezza" name="prodotto"/>x<jsp:getProperty property="larghezza" name="prodotto"/>x<jsp:getProperty property="profondita" name="prodotto"/><br>
						<jsp:getProperty property="descrizione" name="prodotto"/></p>
						<div class="quantity_box">
						    <span>Quantità:</span>
							<div class="product-qty">
								<span id="product-qty"><%= prodotto.getGiacenza() %></span>
							</div>
						</div>
					<div class="clearfix"> </div>
				<div class="single-but item_add">
					<a href="Cart?codiceM=<%=prodotto.getCodiceModello()%>"><input type="submit" value="add to cart"/></a>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>

<!-- //products -->
	

<%@ include file="footer.jsp"%>
</body>
</html>
