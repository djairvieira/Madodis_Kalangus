<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Madodis - Cadastrar/Alterar Cursos</title>
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
					<c:when test="${curso.id < 1}">
						<legend>Cadastrar Curso</legend>
					</c:when>
					<c:otherwise>
						<legend>Atualizar Curso</legend>
					</c:otherwise>
				</c:choose>
			</h3>
		</div>
		<div class="container">
			<div class="col-mod-3"></div>
			<div class="col-mod-3">
	
				<c:choose>
					<c:when test="${curso.id < 1}">
						<c:set var="my_action" value="/madodis/adicionarCurso" />
					</c:when>
					<c:otherwise>
						<c:set var="my_action" value="/madodis/atualizarCurso" />
					</c:otherwise>
				</c:choose>
	
				<form:form method="post" action="${my_action}" commandName="curso">
					<form:hidden path="id"/>
					<div class="form-group">
						<div class="col-sm-6"> 
							<label>Nome:</label>
							<form:input path="nome" cssClass="form-control"></form:input>
							<form:errors path="nome" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Sigla:</label>
							<form:input path="sigla" cssClass="form-control"></form:input>
							<form:errors path="sigla" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Descricao:</label>
							<form:textarea path="descricao" cssClass="form-control" style="resize:none"></form:textarea>
							<form:errors path="descricao" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Codigo do Curso no MEC:</label>
							<form:input path="codigoCursoMec" cssClass="form-control"></form:input>
							<form:errors path="codigoCursoMec" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Numero de periodos:</label>
							<form:input path="periodos" cssClass="form-control"></form:input>
							<form:errors path="periodos" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Area:</label>
							<form:input path="area" cssClass="form-control"></form:input>
							<form:errors path="area" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Tipo de Ensino:</label>
							<form:select cssClass="form-control" path="tipoEnsino">
								<form:options items="${tipoEnsinos}" />
							</form:select>
						</div>
						<div class="col-sm-6">
							<label>Data de Criacao:</label>
							<form:input type="date" path="dataCriacao" cssClass="form-control"></form:input>
							<form:errors path="dataCriacao" cssClass="error"></form:errors>
						</div>
					</div>
					<div class="form-group">
							<div class="col-sm-10">
		    					<br/>
		    					<br/>
							<input type="submit" value="Salvar" class="btn btn-success" />
							</div>
						</div>
				<br />
				<br />
					</form:form>
					</div>
					<div class="col-mod-4"></div>
				</div>
		
		<jsp:include page="../rodape.jsp" />
	</body>
</html>