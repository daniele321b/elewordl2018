<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--web-fonts<jsp:useBean id="prodotti"  class="java.util.LinkedList"  type="LinkedList<it.unisa.data.ProdottiBean>" scope="request"></jsp:useBean>-->


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
</head>
<body>
  <%@ include file="header.jsp"%>
     <div class="mid-content">
                 <div class="container">
     			  <div class="middle">
     			    <div class="mid-top">
     			      <h3>Eleworld is the site for you</h3>
     				  <p>All electrical appliances for your needs</p>
     			    </div>
     			 </div>
     	       </div>
     		 </div>
         		<div class="fashion-section">
         		 <div class="container">
         		     <h3 class="tittle">I nostri prodotti</h3>

         		   <div class="fashion-info">
         				<div class="col-md-4 fashion-grids">
         					<figure class="effect-bubba">
         						<img src="images/lavasIndex.png" alt=""/>
         						<figcaption>
         							<h4>Lavastoviglie</h4>
         							<p class="cart"><a href="Prodotti?categoria=Lavasto">Shop</a></p>
         						</figcaption>
         					</figure>
         				</div>
         				<div class="col-md-4 fashion-grids">
         					<figure class="effect-bubba">
         						<img src="images/tvIndex.png" alt=""/>
         						<figcaption>
         							<h4>Tv</h4>
         								<p class="cart"><a href="Prodotti?categoria=Tv">Shop</a></p>
         						</figcaption>
         					</figure>
         				</div>
         				<div class="col-md-4 fashion-grids">
         					<figure class="effect-bubba">
         						<img src="images/scopaIndex.png" alt=""/>
         						<figcaption>
         							<h4>Scope</h4>
         							<p class="cart"><a href="Prodotti?categoria=Scope">Shop</a></p>
         						</figcaption>
         					</figure>
         				</div>
         				<div class="clearfix"></div>
         			</div>
         		</div>
         	</div>
         		<div class="collection-section">
         		 <div class="container">
         		     <h3 class="tittle fea">Altri Prodotti</h3>

         		   <div class="fashion-info">
         				<div class="col-md-4 fashion-grids">
         					<figure class="effect-bubba">
         						<img src="images/frigoIndex.png" alt=""/>
         						<figcaption>
         							<h4>Frigoriferi</h4>
         							<p class="cart"><a href="Prodotti?categoria=Frigo">Shop</a></p>
         						</figcaption>
         					</figure>
         				</div>
         				<div class="col-md-4 fashion-grids">
         					<figure class="effect-bubba">
         						<img src="images/lavaIndex.png" alt=""/>
         						<figcaption>
         							<h4>Lavatrici</h4>
         								<p class="cart"><a href="Prodotti?categoria=Lavatrici">Shop</a></p>
         						</figcaption>
         					</figure>
         				</div>
         				<div class="col-md-4 fashion-grids">
         					<figure class="effect-bubba">
         						<img src="images/fornoIndex.png" alt=""/>
         						<figcaption>
         							<h4>Cottura</h4>
         							<p class="cart"><a href="Prodotti?categoria=Cottura">Shop</a></p>
         						</figcaption>
         					</figure>
         				</div>
         				<div class="clearfix"></div>
         			</div>
         		</div>
         	</div>

		  

<%@ include file="footer.jsp"%>
</body>
</html>
