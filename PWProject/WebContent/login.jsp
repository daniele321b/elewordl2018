<!DOCTYPE HTML>
<html>
<head>
<title>Login </title>

</head>
<body>
<form method="post" action="LoginAmministratore">
<div>
<fieldset>
<legend><img src="img/logo1.png"></img></legend>
<span class="errore container">
	<%if(request.getParameter("errore")!=null){ %>
		<h4 ><%=request.getParameter("errore") %></h4>
	<%} %>
					</span>
<label>Email: <input type="text" value="" name="mail" maxlength="30" /> <br />
<label>Password: <input type="password" value="" name="password" maxlength="20" /><br/>

<input type="submit" value="login" name="loginSubmit" /></label>
</fieldset>
</div>
</form>
</body>
</html>