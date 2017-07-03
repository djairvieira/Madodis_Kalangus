<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Madodis - Diario de Classe</title>
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
				<legend>
					<a href="/madodis/inicio">Diário de Classe</a>
				</legend>
			</h3>
		</div>
		<div class="container">
			<div class="col-mod-4"></div>
			<br>
			<br>
			<br>
			<div class="col-mod-4">
				<form:form method="post" action="/madodis/salvarDiarioDeClasse"
					commandName="diarioDeClasse">
				<div class="form-group">
					<div class="col-sm-6"> 
					
					<form:hidden path="id"/>
					<form:hidden path="aula.id"/>
					<form:hidden path="aula.dataAula"/>
					<form:hidden path="aula.tipoDeAula"/>
					<form:hidden path="aula.turma.id"/>
					<form:hidden path="aula.turma.turno"/>
					<form:hidden path="aula.turma.nome"/>
					<form:hidden path="aula.turma.quantidadeMinimaAluno"/>
					<form:hidden path="aula.turma.quantidadeMaximaAluno"/>
					<form:hidden path="aula.turma.disciplina.id"/>
					<form:hidden path="aula.turma.disciplina.nome"/>
					<form:hidden path="aula.turma.disciplina.sigla"/>
					<form:hidden path="aula.professor.id"/>
					<form:hidden path="aula.professor.titulacao"/>
					<form:hidden path="aula.professor.ctpsNumero"/>
					<form:hidden path="aula.professor.ctpsDataExpedicao"/>
					<form:hidden path="aula.professor.nome"/>
					<form:hidden path="aula.professor.sexo"/>
					<form:hidden path="aula.professor.dataNascimento"/>
					<form:hidden path="aula.professor.nomePai"/>
					<form:hidden path="aula.professor.nomeMae"/>
					<form:hidden path="aula.professor.cpf"/>
					<form:hidden path="aula.professor.rg"/>
					<form:hidden path="aula.professor.rgOrgaoExpedidor"/>
					<form:hidden path="aula.professor.tituloEleitoral"/>
					<form:hidden path="aula.professor.nacionalidade"/>
					<form:hidden path="aula.professor.naturalidade"/>
					<form:hidden path="aula.professor.email"/>
					<form:hidden path="aula.professor.senha"/>
					<form:hidden path="aula.professor.matricula"/>
					<form:hidden path="aula.professor.senha"/>
					<form:hidden path="aula.professor.instituicao.id"/>
					<form:hidden path="aula.professor.instituicao.nomeFantasia"/>
					<form:hidden path="aula.professor.instituicao.nomeEmpresarial"/>
					<form:hidden path="aula.professor.instituicao.cnpj"/>
					<form:hidden path="aula.professor.instituicao.inscricaoEstadual"/>
					<form:hidden path="aula.professor.instituicao.endereco.id"/>
					<form:hidden path="aula.professor.instituicao.endereco.logradouro"/>
					<form:hidden path="aula.professor.instituicao.endereco.numero"/>
					<form:hidden path="aula.professor.instituicao.endereco.complemento"/>
					<form:hidden path="aula.professor.instituicao.endereco.cep"/>
					<form:hidden path="aula.professor.instituicao.endereco.bairro"/>
					<form:hidden path="aula.professor.instituicao.endereco.cidade"/>
					<form:hidden path="aula.professor.instituicao.endereco.estado"/>
					<form:hidden path="aula.professor.instituicao.telefone.DDD"/>
					<form:hidden path="aula.professor.instituicao.telefone.numero"/>
					<form:hidden path="aula.professor.endereco.id"/>
					<form:hidden path="aula.professor.endereco.logradouro"/>
					<form:hidden path="aula.professor.endereco.numero"/>
					<form:hidden path="aula.professor.endereco.complemento"/>
					<form:hidden path="aula.professor.endereco.cep"/>
					<form:hidden path="aula.professor.endereco.bairro"/>
					<form:hidden path="aula.professor.endereco.cidade"/>
					<form:hidden path="aula.professor.endereco.estado"/>
					<form:hidden path="aula.professor.telefone.DDD"/>
					<form:hidden path="aula.professor.telefone.numero"/>
					
					<label>Conteúdo Programado:</label>
					<form:input path="conteudoProgramado" cssClass="form-control"></form:input>
					<form:errors path="conteudoProgramado" cssClass="error"></form:errors>
					</div>
					
					<div class="col-sm-6"> 
					<label>Conteúdo Realizado:</label>
					<form:input path="conteudoRealizado" cssClass="form-control"></form:input>
					<form:errors path="conteudoRealizado" cssClass="error"></form:errors>
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
		</div>
		
		<jsp:include page="../rodape.jsp" />
		
	</body>
</html>