<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Madodis - Cadastrar/Alterar Matricula</title>
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
					<c:when test="${matricula.id < 1}">
						<legend>Realizar Matricula</legend>
					</c:when>
					<c:otherwise>
						<legend>Atualizar Matricula</legend>
					</c:otherwise>
				</c:choose>
			</h3>
		</div>
		<div class="container">
		
			<c:if test="${not empty error}">
			   <%-- do want you want with ${error} --%>
			   <div class="alert alert-danger">
				  <strong>Erro!</strong> <c:out value="${error}" />
				</div>
			</c:if>
			
			<c:if test="${not empty success}">
			   <%-- do want you want with ${error} --%>
			   <div class="alert alert-success">
				  <strong>Sucesso!</strong> <c:out value="${success}" />
				</div>
			</c:if>
		
			<div class="col-mod-4"></div>
			<div class="col-mod-4">
			
				<c:choose>
					<c:when test="${matricula.id < 1}">
						<c:set var="my_action" value="/madodis/adicionarMatricula"/>
						<c:set var="my_method" value="post"/>
					</c:when>
					<c:otherwise>
						<c:set var="my_action" value="/madodis/atualizarMatricula"/>
						<c:set var="my_method" value="put"/>
					</c:otherwise>
				</c:choose>
			
				<form:form method="${my_method}" action="${my_action}"
					commandName="matricula">
					<form:hidden path="id"/>
					<div class="form-group">
						<div class="col-sm-4">
							<label>Discente:</label>
							<form:select cssClass="form-control" path="aluno">
								<form:options items="${alunos}" itemLabel="nome" itemValue="id"/>
							</form:select>
						</div>
						<div class="col-sm-4">
							<label>Turma:</label>
							<form:select cssClass="form-control" path="turma">
								<form:options items="${turmas}" itemLabel="turmaValues" itemValue="id"/>
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