<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.*"%>

<!DOCTYPE HTML>
<html>
<head></head>
<body>

<!--start-bottom-->
		   <!--start-image-cursuals-->
                  <div class="scroll-slider">
                  	<div class="container">
							<div class="nbs-flexisel-container"><div class="nbs-flexisel-inner"><ul class="flexiselDemo3 nbs-flexisel-ul" style="left: -253.6px; display: block;">
							<li  class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c3.png" alt=""/></li><li  class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c4.png" alt=""/></li><li  class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c1.png" alt=""/></li><li onclick="location.href='#';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c2.png" alt=""/></li><li  class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c3.png" alt=""/></li><li  class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c4.png" alt=""/></li><li  class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c1.png" alt=""/></li><li  class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c2.png" alt=""/></li></ul><div class="nbs-flexisel-nav-left" style="top: 21.5px;"></div><div class="nbs-flexisel-nav-right" style="top: 21.5px;"></div></div></div>
							<div class="clearfix"> </div>
						  <!--start-image-->
								<script type="text/javascript" src="js/jquery.flexisel.js"></script>
								<!--//end-->
								<script type="text/javascript">
								$(window).load(function() {
								    $(".flexiselDemo3").flexisel({
								        visibleItems: 5,
								        animationSpeed: 1000,
								        autoPlay: true,
								        autoPlaySpeed: 3000,
								        pauseOnHover: true,
								        enableResponsiveBreakpoints: true,
								        responsiveBreakpoints: {
								            portrait: {
								                changePoint:480,
								                visibleItems: 2
								            },
								            landscape: {
								                changePoint:640,
								                visibleItems: 3
								            },
								            tablet: {
								                changePoint:768,
								                visibleItems: 3
								            }
								        }
								    });
								});
								</script>
						<!---->
				  </div>
			</div>
 <!--//end-bottom-->



		<!--start-footer-->
	     <div class="footer">
		   <div class="container">
			<div class="footer-top">
				<div class="col-md-2 footer-left">
					<h3>CHI SIAMO</h3>
					<ul>
						<li><a href="chisiamo.jsp">Chi siamo</a></li>
						<li><a href="contact.jsp">Contatti</a></li>
						<li><a href="#">Siti collegati</a></li>
						<li><a href="">News</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-left">
					<h3>IL TUO PROFILO</h3>
					<ul>
						<li><a href="account.jsp">Account</a></li>
						<li><a href="#">Informazioni Personali</a></li>
						<li><a href="contact.jsp">Indirizzo</a></li>
						<li><a href="#">Traccia il tuo ordine</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-left">
					<h3>Dove Siamo</h3>
					<ul>
						<li><a href="#">Mappa</a></li>
						<li><a href="#">Indirizzi</a></li>
						<li><a href="#">####</a></li>
						<li><a href="#">####</a></li>

					</ul>
				</div>
				<div class="col-md-2 footer-left ">
					<h3>CATEGORIE</h3>
					<ul>
						<li><a href="#">Grandi Elettrodomestici</a></li>
						<li><a href="#">Piccoli Elettrodomestici</a></li>
						<li><a href="#">Offerte</a></li>
						<li><a href="#">Nuovi Arrivi</a></li>

					</ul>
				</div>
				<div class="col-md-2 footer-left lost">
					<h3>Lavora con noi</h3>
					<ul>
						<li><a href="#">Invia il curriculum</a></li>
						<li><a href="#">Vieni a trovarci</a></li>
						<li><a href="#">Nostre esperienze</a></li>

					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>

		</div>
	</div>
	<ul class="socials">
				    <li><a class="soc1" href="#"></a></li>
				    <li><a class="soc2" href="#"></a></li>
				    <li><a class="soc3" href="#"></a></li>
				</ul>
	 <!--/start-copyright-->
	 <div class="copy">
		<div class="container">
			<p>&copy; 2017 ElettroWorld. All Rights Reserved .</p>
		</div>
	</div>
	<!--end-footer-->
		<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>


</body>
</html>