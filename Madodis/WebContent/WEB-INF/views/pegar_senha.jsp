<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="">
		<meta name="author" content="">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<spring:url value="/resources/js/jquery.min.js" var="jqueryJS" />
		<spring:url value="/resources/js/jquery-2.1.3.min.js" var="jquery213JS" />
		<spring:url value="/resources/js/bootstrap-3.3.4.min.js"
			var="bootstrap334JS" />
		<script src="${jqueryJS}"></script>
		<script src='${jquery213JS}'></script>
		<script src="${bootstrap334JS}"></script>
		
		<spring:url value="/resources/css/font-awesome.min.css" var="awesomeCSS" />
		<link rel='stylesheet' href="${awesomeCSS}" />
		
		<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
		<link rel='stylesheet' href="${bootstrapCSS}" />
		
		<!-- Optional theme -->
		<spring:url value="/resources/css/bootstrap-theme.css"
			var="bootstrapThemeCSS" />
		<link rel="stylesheet" href="${bootstrapThemeCSS}" />
		
		<!-- Latest compiled and minified JavaScript -->
		<spring:url value="/resources/js/bootstrap.js" var="bootstrapJS" />
		<script src="${bootstrapJS}"></script>
		
		<spring:url value="/resources/css/login.css" var="loginCSS" />
		<link rel="stylesheet" href="${loginCSS}"></link>
		
		<title>Madodis - Login</title>
	</head>
	<body>
		<div class="container">
			<div style="height:200px;"></div>
		    <div class="row">
		        <div class="col-md-offset-5 col-md-3">
		            <div class="form-login">
		            <h4>Madodis - Login</h4> 
		            <input type="text" id="email" class="form-control input-sm chat-input" 
		            		placeholder="email" />
		            <br />
		            <div class="wrapper">
		            <span class="group-btn">     
		                <a href="javascript:void(0)" onclick="enviarSenha();" class="btn btn-primary btn-md"
		                		>Enviar Senha</a>
		            </span>
		            </div>
		         </div>
		        
		        </div>
		    </div>
		</div>
		
		
		<script type='text/javascript' src='/madodis/resources/js/jquery-2.1.3.min.js'></script>
<script type='text/javascript'
	src='/madodis/resources/js/jquery.mask.js'></script>
<script type='text/javascript'
	src='/madodis/resources/js/fancybox/jquery.fancybox.pack.js'></script>
<script type='text/javascript'
	src='/madodis/resources/js/jquery.easing.1.3.js'></script>
		<!-- /container -->
		<script type="text/javascript">
			function enviarSenha() {
				var email = document.getElementById("email").value;
				
				var form = document.createElement("form");
			    form.setAttribute("method", "post");
			    form.setAttribute("action", "/madodis/login/email");
			    
			    var hiddenEmailField = document.createElement("input");
			    hiddenEmailField.setAttribute("type", "hidden");
			    hiddenEmailField.setAttribute("name", "email");
			    hiddenEmailField.setAttribute("value", email);
			    form.appendChild(hiddenEmailField);
			    
			    document.body.appendChild(form);
			    form.submit();
			}
		</script>
		
		<script>
			jQuery(document).ready(function() {
				jQuery('#cpf').mask('000.000.000-00', {reverse: true});
				jQuery('#rg').mask('0.000.000', {reverse: true});
			});
		</script>
	</body>
</html>