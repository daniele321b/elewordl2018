<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.*"%>
 <%@page import="it.unisa.data.ProdottiBean"%>
<jsp:useBean id="utente" class="it.unisa.data.UtenteBean" scope="session"></jsp:useBean>
<%
	LinkedList<ProdottiBean> cart = (LinkedList<ProdottiBean>) request.getSession().getAttribute("cart");
	if(cart == null ){
		cart= new LinkedList<>();
	}

	request.getSession().setAttribute("cart", cart);
%>
<!DOCTYPE HTML>
<html>
<head>
<script>
function mouseOver() {
   var user = document.getElementsByClassName("user");
   var out = document.createElement("A");
   out.setAttribute("href", "LogoutS");
   out.appendChild(document.createTextNode("Logout"));
   user[0].appendChild(out);
}

function mouseOut() {
	console.log("aspetto");
	 var user = document.getElementsByClassName("user");
	 var child = user[0].childNodes;
	 for (var i = 0; i < child.length; i++) {
		    if (child[i].tagName=="A") {
		      user[0].removeChild(child[i]);
		      i=0;
		    }
		  }
}
</script>
</head>
<body>
<!--start-home-->
<div class="top_bg" id="home">
	<div class="container">
		<div class="header_top">
			<div class="top_right">
				<ul>
					<li><a href="account.jsp">Accedi</a></li>
          <li><a href="account.jsp">Registrati</a></li>
					<li><a href="contact.jsp">Contatti</a></li>

				</ul>
			</div>
				<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!--header-->
<div class="header_bg">
   <div class="container">
	<div class="header">
	  <div class="head-t">
		 <div class="logo">
       <table class="logoT"">
          <tr> <td id="1"> <a href="index.jsp"><img src="img/logo1.png " ></a></td>
	
		
    </tr>
			</table>

		  </div>
		  <div class="header_right">
		  	<!-- Modifica -->
		  	<div class ="user" >
		  			<span>
		  				<%if(utente.getNome()!=null){ %>
		  				<a href="accountInfo.jsp"><h3 onmouseover="setTimeout(mouseOver, 500);" onmouseout="setTimeout(mouseOut, 500);"><%= utente.getNome()%></h3></a>
		  				<%} %>
		  			</span>
		  	</div>

		  	<!-- Modifica -->
			<div class="cart box_1">
				<a href="checkout.jsp">
				<div class="total">
					 (<span ><%=cart.size()%></span> Prodotti)</div>
					<i class="glyphicon glyphicon-shopping-cart"></i></a>
				<p><a><% if (cart.size()== 0){%>Carrello vuoto<%} %></a></p>
				<div class="clearfix"> </div>
			</div>
		</div>
		<div class="clearfix"></div>
	    </div>
		<!--start-header-menu-->
		<ul class="megamenu skyblue">
			<li class="active grid"><a class="color1" href="index.jsp">Home</a></li>
			<li class="grid"><a class="color2" href="#">GRANDI ELETRODOMESTICI</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>Cottura</h4>
								<ul>
									<li><a href="Prodotti?categoria=Cottura">cottura1</a></li>
									<li><a href="Prodotti?categoria=Cottura">cottura2</a></li>
									<li><a href="Prodotti?categoria=Cottura">cottura3</a></li>
									<li><a href="Prodotti?categoria=Cottura">cottura4</a></li>
									<li><a href="Prodotti?categoria=Cottura">cottura5</a></li>
									<li><a href="Prodotti?categoria=Cottura">cottura6</a></li>
								</ul>
							</div>
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>Frigoriferi</h4>
								<ul>
									<li><a href="Prodotti?categoria=Frigo">frigo1</a></li>
									<li><a href="Prodotti?categoria=Frigo">frigo2</a></li>
									<li><a href="Prodotti?categoria=Frigo">frigo3</a></li>
									<li><a href="Prodotti?categoria=Frigo">frigo4</a></li>
									<li><a href="Prodotti?categoria=Frigo">frigo5</a></li>
									<li><a href="Prodotti?categoria=Frigo">frigo6</a></li>
								</ul>
							</div>
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>Lavastoviglie</h4>
								<ul>
									<li><a href="Prodotti?categoria=Lavasto">lavasto1</a></li>
									<li><a href="Prodotti?categoria=Lavasto">lavasto2</a></li>
									<li><a href="Prodotti?categoria=Lavasto">lavasto3</a></li>
									<li><a href="Prodotti?categoria=Lavasto">lavasto4</a></li>
									<li><a href="Prodotti?categoria=Lavasto">lavasto5</a></li>
									<li><a href="Prodotti?categoria=Lavasto">lavasto6</a></li>
								</ul>
							</div>
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>Lavatrici</h4>
								<ul>
									<li><a href="Prodotti?categoria=Lavatrici">lavatrici1</a></li>
									<li><a href="Prodotti?categoria=Lavatrici">lavatrici2</a></li>
									<li><a href="Prodotti?categoria=Lavatrici">lavatrici3</a></li>
									<li><a href="Prodotti?categoria=Lavatrici">lavatrici4</a></li>
									<li><a href="Prodotti?categoria=Lavatrici">lavatrici5</a></li>
									<li><a href="Prodotti?categoria=Lavatrici">lavatrici6</a></li>
								</ul>
							</div>
						</div>
            <div class="col1">
							<div class="h_nav">
								<h4>Tv</h4>
								<ul>
									<li><a href="Prodotti?categoria=Tv">tv1</a></li>
									<li><a href="Prodotti?categoria=Tv">tv2</a></li>
									<li><a href="Prodotti?categoria=Tv">tv3</a></li>
									<li><a href="Prodotti?categoria=Tv">tv4</a></li>
									<li><a href="Prodotti?categoria=Tv">tv5</a></li>
									<li><a href="Prodotti?categoria=Tv">tv6</a></li>
								</ul>
							</div>
						</div>

				</div>
			</div>
				</li>
			<li><a class="color4" href="#">PICCOLI ELETRODOMESTICI</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>Scope Elettriche</h4>
								<ul>
									<li><a href="Prodotti?categoria=Scope">scope1</a></li>
									<li><a href="Prodotti?categoria=Scope">scope2</a></li>
									<li><a href="Prodotti?categoria=Scope">scope3</a></li>
									<li><a href="Prodotti?categoria=Scope">scope4</a></li>
									<li><a href="Prodotti?categoria=Scope">scope5</a></li>
									<li><a href="Prodotti?categoria=Scope">scope6</a></li>
								</ul>
							</div>
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>Microonde</h4>
								<ul>
									<li><a href="Prodotti?categoria=Microonde">microonde1</a></li>
									<li><a href="Prodotti?categoria=Microonde">microonde2</a></li>
									<li><a href="Prodotti?categoria=Microonde">microonde3</a></li>
									<li><a href="Prodotti?categoria=Microonde">microonde4</a></li>
									<li><a href="Prodotti?categoria=Microonde">microonde5</a></li>
									<li><a href="Prodotti?categoria=Microonde">microonde6</a></li>
								</ul>
							</div>
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>Ferri da stiro</h4>
								<ul>
									<li><a href="Prodotti?categoria=Ferri">ferri1</a></li>
									<li><a href="Prodotti?categoria=Ferri">ferri2</a></li>
									<li><a href="Prodotti?categoria=Ferri">ferri3</a></li>
									<li><a href="Prodotti?categoria=Ferri">ferri4</a></li>
									<li><a href="Prodotti?categoria=Ferri">ferri5</a></li>
									<li><a href="Prodotti?categoria=Ferri">ferri6</a></li>
								</ul>
							</div>
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>Caffettiere</h4>
								<ul>
									<li><a href="Prodotti?categoria=Caffe">caffe1</a></li>
								    <li><a href="Prodotti?categoria=Caffe">caffe2</a></li>
									<li><a href="Prodotti?categoria=Caffe">caffe3</a></li>
									<li><a href="Prodotti?categoria=Caffe">caffe4</a></li>
									<li><a href="Prodotti?categoria=Caffe">caffe5</a></li>
									<li><a href="Prodotti?categoria=Caffe">caffe6</a></li>
								</ul>
							</div>
						</div>

						</div>
					</div>
				</li>
				<li><a class="color5" href="Offerte">OFFERTE</a></li>
				</ul>
	</div>
</div>
</div>
 <!--start-content-->
		 <!--start-banner-->

</body>
</html>
