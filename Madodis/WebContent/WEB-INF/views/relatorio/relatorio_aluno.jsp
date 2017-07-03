<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Madodis - Relatorio</title>
<link rel="favicon" href="/madodis/resources/images/favicon.png">
<link rel="stylesheet" media="screen"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
<link rel="stylesheet" href="/madodis/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="/madodis/resources/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/madodis/resources/css/bootstrap-theme.css" media="screen">
<link rel="stylesheet" href="/madodis/resources/css/style.css">
<link rel='stylesheet' id='camera-css'
	href='/madodis/resources/css/camera.css' type='text/css' media='all'>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	<script src="/madodis/resources/js/html5shiv.js"></script>
	<script src="/madodis/resources/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<jsp:include page="../menu.jsp">
		<jsp:param value="${user}" name="user"/>
	</jsp:include>
	
		<div class="container">
			<h3>
				<legend>
					<a href="javascript:void(0)">Relatorio Discentes</a>
				</legend>
			</h3>
		</div>
		
		<div class="container">
			<div class="col-mod-4">
				<h4>Notas</h4>
			</div>
		</div>
		
		<div class="container">
			<div class="col-mod-4"></div>
			<br>
			<div class="col-mod-4">
				<table class="table table-striped">
					<tr>
						<th>Discente</th>
						<th>Turma</th>
						<th>1 Avaliacao</th>
						<th>2 Avaliacao</th>
						<th>2 Chamada 1 Avaliacao</th>
						<th>2 Chamada 2 Avaliacao</th>
						<th>Prova Final</th>
						<th>Média</th>
						<th>Situacao</th>
					</tr>
					<c:forEach items="${prova}" var="dado">
						<tr>
							<td>${dado.aluno.nome}</td>
							<td>${dado.turma.nome}</td>
							<td>${dado.nota1}</td>
							<td>${dado.nota2}</td>
							<td>${dado.nota3}</td>
							<td>${dado.nota4}</td>
							<td>${dado.nota5}</td>
							<td>${dado.media}</td>
							<td>${dado.situacao}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-mod-4"></div>
		</div>
		
		<div class="container">
			<div class="col-mod-4">
				<h4>Frequencia</h4>
			</div>
		</div>
		
		<div class="container">
			<div class="col-mod-4"></div>
			<br>
			<div class="col-mod-4">
				<table class="table table-striped">
					<tr>
						<th>Discente</th>
						<th>Turma</th>
						<th>Faltas</th>
					</tr>
					<c:forEach items="${frequencia}" var="dado">
						<tr>
							<td>${dado.aluno.nome}</td>
							<td>${dado.turma.nome}</td>
							<td>${dado.faltas}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-mod-4"></div>
		</div>
		
		<div class="container">
			<div class="col-mod-4"></div>
			<div class="col-mod-4">
				<a href="javscript:void(0)" onclick="window.print()"><span
									class="glyphicon glyphicon-print"></span></a>	
			</div>
		</div>
		
		<jsp:include page="../rodape.jsp" />
		
	</body>
</html>