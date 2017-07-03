<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Madodis - Cadastrar/Alterar Contatos</title>
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
				<c:when test="${contato.id < 1}">
					<legend>Fale Conosco</legend>
				</c:when>
				<c:otherwise>
					<legend>Fale Conosco</legend>
				</c:otherwise>
			</c:choose>
		</h3>
	</div>
	<div class="container">
		<div class="col-mod-4"></div>
		<div class="col-mod-4">

			<c:choose>
				<c:when test="${contato.id < 1}">
					<c:set var="my_action" value="/madodis/adicionarContato" />
				</c:when>
				<c:otherwise>
					<c:set var="my_action" value="/madodis/atualizarContato" />
				</c:otherwise>
			</c:choose>

			<form:form method="post" action="${my_action}" commandName="contato">
				<form:hidden path="id" />
				<div class="form-group">
					<div class="col-sm-6"> 
						<label>Nome:</label>
						<form:input path="nome" cssClass="form-control"></form:input>
						<form:errors path="nome" cssClass="error"></form:errors>
					</div>
					<div class="col-sm-6">
						<label>Email:</label>
						<form:input path="email" cssClass="form-control"></form:input>
						<form:errors path="email" cssClass="error"></form:errors>
					</div>
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
					<div class="col-sm-6">
						<label>Mensagem:</label>
						<form:textarea path="mensagem" cssClass="form-control" style="resize:none"></form:textarea>
							<form:errors path="mensagem" cssClass="error"></form:errors>
					</div>
				</div>
				<div class="form-group">
    				<div class="col-sm-10">
    					<br/>
    					<br/>
						<input type="submit" value="Salvar" class="btn btn-success" />
						
							</br>
							</br>
							</br>
							
								Vitória de Santo Antão - PE - CEP 55600-000
								<br />
								Telefone: (81) 9784-7806
								<br />
								Central de Vendas: (81) 9150-3105
								<br />
								Email: suportekalangus@gmail.com
								<br />
								Escritório: Endereço: Livramento Bairro: Livramento <br> 
								Cidade: Vitória de Santo Antão - PE
								</br>
							
								 
									<div align= "center"> <img aling:="center" width="300px" height="200px" src="/madodis/resources/images/KalangusSolutionsIT.jpg"> </div>	
								
						</div>	
									
				</div>
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