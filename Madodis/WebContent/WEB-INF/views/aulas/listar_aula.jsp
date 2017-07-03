<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Madodis - Listar Aulas</title>
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
					<a href="/madodis/inicio">Aula Cadastrada</a>
				</legend>
			</h3>
		</div>
		<c:if test="${empty aulaList}">
			<div class="container">
				<div class="col-mod-4">
					<h4>Não existe registro de aulas para mostrar!</h4>
				</div>
			</div>
		</c:if>
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
			<br>
			<br>
			<br>
			<div class="col-mod-4">
				<table class="table table-striped">
					<tr>
						<th>Assunto</th>
						<th>Data</th>
						<th>Periodo</th>
						<th>Turma</th>
						<th>Turno</th>
						<th>Tipo</th>
						<th>Remover</th>
						<th>Editar</th>
						<th>Diario</th>
						<th>Upload</th>
						<th>Frequencia</th>
						<th>Notas</th>
					</tr>
					<c:forEach items="${aulaList}" var="aula">
						<tr>
							<td>${aula.assunto}</td>
							<td>${aula.dataAula}</td>
							<td>${aula.turma.nome}</td>
							<td>${aula.turma.turmaLetra}</td>
							<td>${aula.turma.turno}</td>
							<td>${aula.tipoDeAula}</td>
							<td><a href="javascript:void(0)" onclick="removerAula(${aula.id})"><span
									class="glyphicon glyphicon-remove-circle" title="Remover"></span></a></td>
							<td><a href="/madodis/update/aula/${aula.id}"><span 
									class="glyphicon glyphicon-pencil" title="Editar"></span></a></td>
							<td><a href="/madodis/getDiarioDeClasse/${aula.id}"><span 
									class="glyphicon glyphicon-list-alt" title="Diario de Classe"></span></a></td>
							<td><a href="/madodis/aula/upload/${aula.id}"><span 
									class="glyphicon glyphicon-upload" title="Upload"></span></a></td>
							<td><a href="/madodis/getFrequencia/${aula.id}"><span 
										class="glyphicon glyphicon-check" title="Frequencia"></span></a></td>
							<c:if test="${aula.tipoDeAula != 'Normal'}">
								<td><a href="/madodis/getNotas/${aula.id}"><span 
										class="glyphicon glyphicon-file" title="Notas"></span></a></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div>
				<a href="/madodis/form_aulas"><button class="btn btn-success">
						<i class="glyphicon glyphicon-plus-sign"></i>&nbsp;Novo
					</button></a>
			</div>
			<div class="col-mod-4"></div>
		</div>
		
		<jsp:include page="../rodape.jsp" />
		
		<script>
			function removerAula(id) {
				$.jAlert({
			        'title': 'Remover',
			        'content': 'Voce deseja remover a aula?',
			        'theme': 'blue',
			        'btns': [
			        			{ 
			        				'text': 'Sim', 
			        				'onClick' : function(e, btn) {
			        					$.get("/madodis/remover/aula/" + id, function(data) {
			        						document.open();
			        						document.write(data);
			        						document.close();
			        					});
			        				}
			        			}, 
			        			{
			        				'text' : 'Não',
			        				'onClick' : function (e, btn) {
			        					btn.parents('.jAlert').closeAlert();
			        				}
			        			}
							]
			      });
			}
		</script>
		
	</body>
</html>