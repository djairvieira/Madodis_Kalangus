<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Madodis - Cadastrar/Alterar Coordenadores</title>
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
				<c:when test="${coordenador.id < 1}">
					<legend>Cadastrar Coordenador</legend>
				</c:when>
				<c:otherwise>
					<legend>Atualizar Coordenador</legend>
				</c:otherwise>
			</c:choose>
		</h3>
	</div>
	<div class="container">
		<div class="col-mod-4"></div>
		<div class="col-mod-4">

			<c:choose>
				<c:when test="${coordenador.id < 1}">
					<c:set var="my_action" value="/madodis/adicionarCoordenador" />
					<c:set var="my_method" value="post" />
				</c:when>
				<c:otherwise>
					<c:set var="my_action" value="/madodis/atualizarCoordenador" />
					<c:set var="my_method" value="put" />
				</c:otherwise>
			</c:choose>

			<form:form method="${my_method}" action="${my_action}"
				commandName="coordenador">
				<form:hidden path="id" />
				<div class="form-group">
					<fieldset>
					<legend>Dados Pessoais</legend>
					<div class="col-sm-6">
						<label>Nome:</label>
						<form:input path="nome" cssClass="form-control"></form:input>
						<form:errors path="nome" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Cpf:</label>
						<form:input id="cpf" path="cpf" cssClass="form-control"></form:input>
						<form:errors path="cpf" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Sexo:</label>
						<form:select cssClass="form-control" path="sexo">
							<form:options items="${sexos}" />
						</form:select>
					</div>
					<div class="col-sm-6">
						<label>Titulo de eleitor:</label>
						<form:input path="tituloEleitoral" cssClass="form-control"></form:input>
						<form:errors path="tituloEleitoral" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>RG:</label>
						<form:input id="rg" path="rg" cssClass="form-control"></form:input>
						<form:errors path="rg" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Orgão Expedidor:</label>
						<form:input path="rgOrgaoExpedidor" cssClass="form-control"></form:input>
						<form:errors path="rgOrgaoExpedidor" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>CTPS Numero:</label>
						<form:input path="ctpsNumero" cssClass="form-control"></form:input>
						<form:errors path="ctpsNumero" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>CTPS Data Expedição:</label>
						<form:input type="date" path="ctpsDataExpedicao" cssClass="form-control"></form:input>
						<form:errors path="ctpsDataExpedicao" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Nome do pai:</label>
						<form:input path="nomePai" cssClass="form-control"></form:input>
						<form:errors path="nomePai" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Nome da Mãe:</label>
						<form:input path="nomeMae" cssClass="form-control"></form:input>
						<form:errors path="nomeMae" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Data Nascimento:</label>
						<form:input type="date" path="dataNascimento"
							cssClass="form-control"></form:input>
							<form:errors path="dataNascimento" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Nacionalidade:</label>
						<form:input path="nacionalidade" cssClass="form-control"></form:input>
						<form:errors path="nacionalidade" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Naturalidade:</label>
						<form:input path="naturalidade" cssClass="form-control"></form:input>
						<form:errors path="naturalidade" cssClass="error"></form:errors>
					</div>
					</fieldset>
					<fieldset>
					<legend>Dados de Acesso</legend>
					<div class="col-sm-6">
						<label>Curso:</label>
						<form:select cssClass="form-control" path="curso">
							<form:options items="${coordenadorCursos}" itemLabel="nome"
								itemValue="id" />
						</form:select>
					</div>
					<div class="col-sm-6">
						<label>Em Exercicio?</label>
						<form:checkbox path="emExercicio" cssClass="form-control" />
						<form:errors path="emExercicio" cssClass="error"></form:errors>
					</div>
					
					<div class="col-sm-6">
						<label>Matrícula:</label>
						<form:input path="matricula" cssClass="form-control"></form:input>
						<form:errors path="matricula" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Email:</label>
						<form:input path="email" cssClass="form-control"></form:input>
						<form:errors path="email" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Senha:</label>
						<form:password path="senha" cssClass="form-control"></form:password>
						<form:errors path="senha" cssClass="error"></form:errors>
					</div>
					</fieldset>
					<fieldset>
					<legend>Endereco</legend>
					<div class="col-sm-6">
						<label>Logradouro:</label>
						<form:input path="endereco.logradouro" cssClass="form-control" />
						<form:errors path="endereco.logradouro" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Número:</label>
						<form:input id="numero" path="endereco.numero" cssClass="form-control" />
						<form:errors path="endereco.numero" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Cep:</label>
						<form:input id="cep" path="endereco.cep" cssClass="form-control" />
						<form:errors path="endereco.cep" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Bairro:</label>
						<form:input path="endereco.bairro" cssClass="form-control" />
						<form:errors path="endereco.bairro" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Cidade:</label>
						<form:input path="endereco.cidade" cssClass="form-control" />
						<form:errors path="endereco.cidade" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6"> 
						<label>Estado:</label>
						<form:select cssClass="form-control" path="endereco.estado">
							<form:options items="${estados}" />
						</form:select>
					</div>
					</fieldset>
					<fieldset>
					<legend>Telefone</legend>
					<div class="col-sm-6">
						<label>DDD:</label>
						<form:input id="ddd" path="telefone.DDD" cssClass="form-control" />
						<form:errors path="telefone.DDD" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Telefone:</label>
						<form:input id="telefone" path="telefone.numero" cssClass="form-control" />
						<form:errors path="telefone.numero" cssClass="error"></form:errors>
					</div>
					</fieldset>
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
			jQuery('#cpf').mask('000.000.000-00', {reverse: true});
			jQuery('#numero').mask('0000', {reverse: true});
			jQuery('#cep').mask('00000-000', {reverse: true});
			jQuery('#rg').mask('0.000.000', {reverse: true});
			jQuery('#ddd').mask('00', {reverse: true});
			jQuery('#telefone').mask('00000-0000', {reverse: true});
		});
	</script>
	
</body>
</html>