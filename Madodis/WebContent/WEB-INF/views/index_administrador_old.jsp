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
		
		<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />
		<link rel='stylesheet' href="${bootstrapCSS}" />
		
		<!-- Optional theme -->
		<spring:url value="/resources/css/bootstrap-theme.min.css" var="bootstrapThemeCSS" />
		<link rel="stylesheet" href="${bootstrapThemeCSS}" />
		
		<!-- Latest compiled and minified JavaScript -->
		<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
		<script src="${bootstrapJS}"></script>
		
		<title>Início</title>
	</head>
	<body>
		<div class="container">
	
			<!-- Static navbar -->
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar" aria-expanded="false"
							aria-controls="navbar">
							<span class="sr-only"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Madodis</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class=""><a href="#">Home</a></li>
							<li><a href="#">Sobre</a></li>
							<li><a href="#">Contato</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">Cadastros<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="/madodis/listarProfessores">Docentes</a></li>
									<li><a href="/madodis/listarAlunos">Discentes</a></li>
									<li><a href="/madodis/listarCursos">Cursos</a></li>
									<li><a href="/madodis/listarInstituicoes">Instituições</a></li>
									<li><a href="/madodis/listarSecretarias">Secretarias</a></li>
									<li><a href="/madodis/listarDisciplinas">Disciplinas</a></li>
									<li><a href="/madodis/listarCoordenadores">Coordenadores</a></li>
									<li><a href="/madodis/listarAulas">Aulas</a></li>
									<li><a href="/madodis/listarTurmas">Turmas</a></li>
									<li><a href="/madodis/listarMatriculas">Matriculas</a></li>
								</ul></li>
						</ul>
					</div>
					<!--/.nav-collapse -->
				</div>
				<!--/.container-fluid -->
			</nav>
		</div>
		<!-- /container -->
	
	
		<!-- Bootstrap core JavaScript
	    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<spring:url value="/resources/js/jquery.min.js" var="jqueryJS" />
		<spring:url value="/resources/js/jquery-2.1.3.min.js" var="jquery213JS" />
		<spring:url value="/resources/js/bootstrap-3.3.4.min.js" var="bootstrap334JS" />
		<script src="${jqueryJS}"></script>
		<script src='${jquery213JS}'></script>
		<script src="${bootstrap334JS}"></script>
	</body>
</html>