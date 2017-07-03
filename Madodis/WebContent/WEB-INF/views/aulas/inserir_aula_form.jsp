<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Madodis - Cadastrar/Alterar Aulas</title>
<link rel="favicon" href="/madodis/resources/images/favicon.png">
<link rel="stylesheet" media="screen"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
<link rel="stylesheet" href="/madodis/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="/madodis/resources/css/font-awesome.min.css">
<link rel="stylesheet" href="/madodis/resources/css/bootstrap-theme.css"
	media="screen">
<link rel="stylesheet" href="/madodis/resources/css/style.css">
<link rel='stylesheet' id='camera-css'
	href='/madodis/resources/css/camera.css' type='text/css' media='all'>
	<link rel='stylesheet' href="/madodis/resources/css/jAlert.css" />
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	<script src="/madodis/resources/js/html5shiv.js"></script>
	<script src="/madodis/resources/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<jsp:include page="../menu.jsp">
		<jsp:param value="${user}" name="user" />
	</jsp:include>
		<div class="container">
			<h3>
				<c:choose>
					<c:when test="${aula.id < 1}">
						<legend>Cadastrar Aula</legend>
					</c:when>
					<c:otherwise>
						<legend>Atualizar Aula</legend>
					</c:otherwise>
				</c:choose>
			</h3>
		</div>
		<div class="container">
			<div class="col-mod-4"></div>
			<div class="col-mod-4">
			
				<c:choose>
					<c:when test="${aula.id < 1}">
						<c:set var="my_action" value="/madodis/adicionarAula.html"/>
					</c:when>
					<c:otherwise>
						<c:set var="my_action" value="/madodis/atualizarAula.html"/>
					</c:otherwise>
				</c:choose>
			
				<form:form method="post" action="${my_action}"
					commandName="aula">
					<form:hidden path="id"/>
					<label>Assunto:</label>
					<form:input path="assunto" cssClass="form-control"></form:input>
					<form:errors cssClass="error" path="assunto"></form:errors>
					<br />
					<label>Data da Aula:</label>
					<form:input type="date" path="dataAula" cssClass="form-control"></form:input>
					<form:errors cssClass="error" path="dataAula"></form:errors>
					<br />
					<label>Tipo de Aula:</label>
					<form:select cssClass="form-control" path="tipoDeAula">
						<form:options items="${tipos}" />
					</form:select>
					<br />
					<label>Turma:</label>
					<form:select cssClass="form-control" path="turma">
						<form:options items="${turmas}" itemLabel="turmaValues"
							itemValue="id" />
					</form:select>
					<br />
					<input type="submit" value="Salvar" class="btn btn-success" />
					<br />
					<br />
				</form:form>
			</div>
			<div class="col-mod-4"></div>
		</div>
		
		<jsp:include page="../rodape.jsp" />
		
	</body>
</html>