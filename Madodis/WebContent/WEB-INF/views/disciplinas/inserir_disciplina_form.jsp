<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Madodis - Cadastrar/Alterar Disciplinas</title>
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
					<c:when test="${disciplina.id < 1}">
						<legend>Cadastrar Disciplina</legend>
					</c:when>
					<c:otherwise>
						<legend>Atualizar Disciplina</legend>
					</c:otherwise>
				</c:choose>
			</h3>
		</div>
		<div class="container">
			<div class="col-mod-4"></div>
			<div class="col-mod-4">
			
				<c:choose>
					<c:when test="${disciplina.id < 1}">
						<c:set var="my_action" value="/madodis/adicionarDisciplina"/>
					</c:when>
					<c:otherwise>
						<c:set var="my_action" value="/madodis/atualizarDisciplina.html"/>
					</c:otherwise>
				</c:choose>
			
				<form:form method="post" action="${my_action}"
					commandName="disciplina">
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
							<label>Créditos:</label>
							<form:input path="creditos" cssClass="form-control"></form:input>
							<form:errors path="creditos" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Descrição:</label>
							<form:textarea path="descricao" cssClass="form-control"></form:textarea>
							<form:errors path="descricao" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Carga horaria:</label>
							<form:input path="cargaHoraria" cssClass="form-control"></form:input>
							<form:errors path="cargaHoraria" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Modulo Pertencente:</label>
							<form:input path="moduloPertencente" cssClass="form-control"></form:input>
							<form:errors path="moduloPertencente" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Requisitos:</label>
							<form:input path="requisitos" cssClass="form-control"></form:input>
							<form:errors path="requisitos" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Metodo de Aprendizagem:</label>
							<form:input path="planoDeEnsino.metodoApredizagem" cssClass="form-control"></form:input>
							<form:errors path="planoDeEnsino.metodoApredizagem" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Carga horaria Teorica:</label>
							<form:input path="planoDeEnsino.cargaHorariaTeorica" cssClass="form-control"></form:input>
							<form:errors path="planoDeEnsino.cargaHorariaTeorica" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Carga horaria Pratica:</label>
							<form:input path="planoDeEnsino.cargaHorariaPratica" cssClass="form-control"></form:input>
							<form:errors path="planoDeEnsino.cargaHorariaPratica" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Objetivos:</label>
							<form:input path="planoDeEnsino.objetivos" cssClass="form-control"></form:input>
							<form:errors path="planoDeEnsino.objetivos" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Metodo de Avaliacao:</label>
							<form:input path="planoDeEnsino.medotoAvaliacao" cssClass="form-control"></form:input>
							<form:errors path="planoDeEnsino.medotoAvaliacao" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Bibliografia Usada:</label>
							<form:input path="planoDeEnsino.bibliografiaUsada" cssClass="form-control"></form:input>
							<form:errors path="planoDeEnsino.bibliografiaUsada" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
							<label>Ementa:</label>
							<form:input path="planoDeEnsino.ementa" cssClass="form-control"></form:input>
							<form:errors path="planoDeEnsino.ementa" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-6">
						<label>Docente:</label>
						<form:select cssClass="form-control" path="professor">
							<form:options items="${professores}" itemLabel="nome" itemValue="id"/>
						</form:select>
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