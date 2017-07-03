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
		            <input type="text" id="matricula" class="form-control input-sm chat-input" 
		            		placeholder="matricula" />
		            <br />
		            <input type="password" id="oldSenha" class="form-control input-sm chat-input" 
		            		placeholder="Antiga Senha" />
		            <br />
		            <input type="password" id="newSenha" class="form-control input-sm chat-input" 
		            		placeholder="Nova Senha" />
		            <br />
		            <div class="wrapper">
		            <span class="group-btn">     
		                <a href="javascript:void(0)" onclick="mudarSenha();" class="btn btn-primary btn-md"
		                		>Alterar Senha</a>
		            </span>
		            </div>
		         </div>
		        
		        </div>
		    </div>
		</div>
		
		<!-- /container -->
		<script type="text/javascript">
			function mudarSenha() {
				var matricula = document.getElementById("matricula").value;
				var oldSenha = document.getElementById("oldSenha").value;
				var newSenha = document.getElementById("newSenha").value;
				
				var form = document.createElement("form");
			    form.setAttribute("method", "post");
			    form.setAttribute("action", "/madodis/login/mudarSenha");
			    
			    var hiddenMatriculaField = document.createElement("input");
			    hiddenMatriculaField.setAttribute("type", "hidden");
			    hiddenMatriculaField.setAttribute("name", "matricula");
			    hiddenMatriculaField.setAttribute("value", matricula);
			    form.appendChild(hiddenMatriculaField);
			    
			    var hiddenOldSenhaField = document.createElement("input");
			    hiddenOldSenhaField.setAttribute("type", "hidden");
			    hiddenOldSenhaField.setAttribute("name", "oldSenha");
			    hiddenOldSenhaField.setAttribute("value", oldSenha);
			    form.appendChild(hiddenOldSenhaField);
			    
			    var hiddenNewSenhaField = document.createElement("input");
			    hiddenNewSenhaField.setAttribute("type", "hidden");
			    hiddenNewSenhaField.setAttribute("name", "newSenha");
			    hiddenNewSenhaField.setAttribute("value", newSenha);
			    form.appendChild(hiddenNewSenhaField);
			    
			    document.body.appendChild(form);
			    form.submit();
			}
		</script>
	</body>
</html>