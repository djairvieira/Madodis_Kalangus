<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Madodis - Cadastrar/Alterar Instituição</title>
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
		<jsp:param value="${user}" name="user"/>
	</jsp:include>
	
	<div class="container">
		<h3>
			<c:choose>
				<c:when test="${instituicao.id < 1}">
					<legend>Cadastrar Instituição</legend>
				</c:when>
				<c:otherwise>
					<legend>Atualizar Instituição</legend>
				</c:otherwise>
			</c:choose>
		</h3>
	</div>
	<div class="container">
		<div class="col-mod-4"></div>
		<div class="col-mod-4">

			<c:choose>
				<c:when test="${instituicao.id < 1}">
					<c:set var="my_action" value="/madodis/adicionarInstituicao" />
				</c:when>
				<c:otherwise>
					<c:set var="my_action" value="/madodis/atualizarInstituicao" />
				</c:otherwise>
			</c:choose>
			<form:form method="${my_method}" action="${my_action}"
				commandName="instituicao">
				<form:hidden path="id" />
				<div class="form-group">
						<div class="col-sm-6">
							<label>Nome Fantasia:</label>
							<form:input path="nomeFantasia" cssClass="form-control" size="100"
								maxlength="100" />
							<form:errors cssClass="error" path="nomeFantasia" />
						</div>
						<div class="col-sm-6">
							<label>Nome Empresarial:</label>
							<form:input path="nomeEmpresarial" cssClass="form-control"
								size="100" maxlength="100" />
							<form:errors cssClass="error" path="nomeEmpresarial" />
						</div>
						<div class="col-sm-6">
							<label>CNPJ:</label>
							<form:input id="cnpj" path="cnpj" cssClass="form-control" />
							<form:errors cssClass="error" path="cnpj" />
						</div>
						<div class="col-sm-6">
							<label>Inscrição Estadual:</label>
							<form:input path="inscricaoEstadual" cssClass="form-control" />
							<form:errors cssClass="error" path="inscricaoEstadual" />
						</div>
						<div class="col-sm-6">
							<label>Logradouro:</label>
							<form:input path="endereco.logradouro" cssClass="form-control" />
							<form:errors cssClass="error" path="endereco.logradouro" />
						</div>
						<div class="col-sm-6">	
							<label>Número:</label>
							<form:input id="numero" path="endereco.numero" cssClass="form-control" />
							<form:errors cssClass="error" path="endereco.numero" />
						</div>
						<div class="col-sm-6">			
							<label>Cep:</label>
							<form:input id="cep" path="endereco.cep" cssClass="form-control" />
							<form:errors cssClass="error" path="endereco.cep" />
						</div>
						<div class="col-sm-6">
							<label>Bairro:</label>
							<form:input path="endereco.bairro" cssClass="form-control" />
							<form:errors cssClass="error" path="endereco.bairro" />
						</div>
						<div class="col-sm-6">
							<label>Cidade:</label>
							<form:input path="endereco.cidade" cssClass="form-control" />
							<form:errors cssClass="error" path="endereco.cidade" />
						</div>
						<div class="col-sm-6"> 
						<label>Estado:</label>
						<form:select cssClass="form-control" path="endereco.estado">
							<form:options items="${estados}" />
						</form:select>
					</div>
						<div class="col-sm-6">
							<label>DDD:</label>
							<form:input id="ddd" path="telefone.DDD" cssClass="form-control" />
							<form:errors cssClass="error" path="telefone.DDD" />
						</div>
						<div class="col-sm-6">
							<label>Telefone:</label>
							<form:input id="telefone" path="telefone.numero" cssClass="form-control" />
							<form:errors cssClass="error" path="telefone.numero" />
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
	
	<script>
		jQuery(document).ready(function() {
			jQuery('#cnpj').mask('00.000.000/0000-00', {reverse: true});
			jQuery('#numero').mask('0000', {reverse: true});
			jQuery('#cep').mask('00000-000', {reverse: true});
			jQuery('#ddd').mask('00', {reverse: true});
			jQuery('#telefone').mask('00000-0000', {reverse: true});
		});
	</script>
</body>
</html>