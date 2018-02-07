<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.*"%>
 <%@page import="it.unisa.data.ProdottiBean"%>

<html>
<head>
<title>EleWorld</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/slide2.css" rel='stylesheet' type='text/css' />
<script src="js/jquery-1.11.1.min.js"></script>
<!-- start menu -->
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
<!-- checkout -->

	<div class="products">
		<div class="container">
			<div class="products-grids">
				<div class="col-md-8 products-grid-left">


					

					<% int i, cont=3;
						if(cart.size()!=0){
							for (i=0;i<cart.size();i++){%>
							<%if(cont%3 == 0) {%>
								<div class="products-grid-lft">
							<%} cont++;%>
							<div class="products-grd">
							
								<a href="RemoveFromCart?el=<%=i%>"><div class="close1"></div></a>
						
								<div class="p-one simpleCart_shelfItem prd">
											<h6><span>Cod.<%=cart.get(i).getCodiceModello() %></span></h6>
											<img src="images/<%=cart.get(i).getImmagine()%>" alt="" class="img-responsive" />
									<h4><%=  cart.get(i).getNome() %></h4>
									<p> <span class=" item_price valsa">€<%=  cart.get(i).getPrezzo() %></span></p>

								</div>
							</div>


							<%if ((cont+3)%3 == 0) {%>
									<div class="clearfix"> </div>
									</div>
								<%} %>
						<%		 }

							} else {%>

								<h3>Nessun prodotto nel carrello</h3>

							<% } %>
					<div class="clearfix"> </div>



					</div>

					</div>
				</div>
				<%if(cart.size()!=0){ %>
					<%if(utente.getNome()!=null){ %>
	
						<div class="single-but item_add ">
								<a href="Acquista" ><input type="submit" name="reg-submit" value="Pagamento"></a>
							</div>
							<% } else { %>
	
							<div class="single-but item_add">
								<a href="account.jsp" ><input type="submit" name="reg-submit" value="Login per Acqu."></a>
							</div>
	
								<%} %>
				<%} %>
			</div>

		</div>


<%@ include file="footer.jsp"%>

</body>
</html>
