<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.*"%>
 <%@page import="it.unisa.data.ProdottiBean"%>

<%
List<ProdottiBean> prodotti = (LinkedList<ProdottiBean>) request.getAttribute("prodotti");
%>
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

</head>
<body>
  <%@ include file="header.jsp"%>

<!--products-->
	<div class="products">
		<div class="container">
			<div class="products-grids">
				<div class="col-md-8 products-grid-left">
					
					
					<!-- MODIFICA -->
					
					<% int i, cont=3;
						if(prodotti.size()!=0){
							for (i=0;i<prodotti.size();i++){%>
							<%if(cont%3 == 0) {%>
								<div class="products-grid-lft">
							<%} cont++;%>
							<div class="products-grd">
								<div class="p-one simpleCart_shelfItem prd">
									<a href="Prodotto?codiceM=<%=prodotti.get(i).getCodiceModello()%>">
											<img src="images/<%=prodotti.get(i).getImmagine()%>" alt="" class="img-responsive" />
									</a>
									<h4><%=  prodotti.get(i).getNome() %></h4> <h4 id="Codice<%=i+1%>"></h4>
									<p><a class="item_add" href="#"><i class="glyphicon glyphicon-shopping-cart"></i> <span class=" item_price valsa">€<%=  prodotti.get(i).getPrezzo() %></span></a></p>
									
								</div>
							</div>
							
							
							<%if ((cont+3)%3 == 0) {%>
									<div class="clearfix"> </div>
									</div>
								<%} 
								} 
							} else {%>
								<h3>Spiacente nessun prodotto per questa categoria</h3>
							<% }%>
					<div class="clearfix"> </div>
					
					</div>
				</div>
			</div>
		</div>
	  

<%@ include file="footer.jsp"%>
</body>
</html>
