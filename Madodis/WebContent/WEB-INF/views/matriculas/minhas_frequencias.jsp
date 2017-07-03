<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Madodis - Minhas Notas</title>
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
					<a href="javascript:void(0)">Minhas Notas</a>
				</legend>
			</h3>
		</div>
		<c:if test="${empty dados}">
			<div class="container">
				<div class="col-mod-4">
					<h4>Não existe registro de notas para mostrar!</h4>
				</div>
			</div>
		</c:if>
		<div class="container">
			<div class="col-mod-4"></div>
			<br>
			<br>
			<br>
			<div class="col-mod-4">
				<table class="table table-striped">
					<tr>
						<th>Discente</th>
						<th>Turma</th>
						<th>Letra</th>
						<th>Turno</th>
						<th>Disciplina</th>
						<th>Faltas</th>
					</tr>
					<c:forEach items="${dados}" var="dado">
						<tr>
							<td>${dado.aluno.nome}</td>
							<td>${dado.turma.nome}</td>
							<td>${dado.turma.turmaLetra}</td>
							<td>${dado.turma.turno}</td>
							<td>${dado.turma.disciplina.nome}</td>
							<td>${dado.faltas}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-mod-4"></div>
		</div>
		
		<jsp:include page="../rodape.jsp" />
		
	</body>
</html>