<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Fixed navbar -->
<div class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<!-- Button for smallest screens -->
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span><span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="javascript:void(0)"> <img
				src="/madodis/resources/images/icon.jpeg"></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav pull-right mainNav">
				<li><a href="/madodis/inicio">Inicio</a></li>
				<li class="dropdown">
					<a href="javascript:void(0)" class="dropdown-toggle"
						data-toggle="dropdown">Cursos <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="/madodis/cursos/graduacao">Graduação</a></li>
						<li><a href="/madodis/cursos/tecnico">Técnico</a></li>
						<li><a href="/madodis/cursos/posgraduacao">Pos-Graduação</a></li>
					</ul>
				</li>
				<c:choose>
					<c:when
						test="${(user['class'].simpleName eq 'Secretaria') or (user['class'].simpleName eq 'Coordenador')
						or (user['class'].simpleName eq 'Administrador') or (user['class'].simpleName eq 'Professor')}">

				<li class="dropdown">
					<a href="javascript:void(0)" class="dropdown-toggle"
						data-toggle="dropdown">Gerenciar <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<c:choose>
							<c:when
								test="${(user['class'].simpleName eq 'Secretaria') or (user['class'].simpleName eq 'Coordenador') or (user['class'].simpleName eq 'Administrador')}">
								<li><a href="/madodis/listarProfessores">Docentes</a></li>
								<li><a href="/madodis/listarAlunos">Discentes</a></li>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${(user['class'].simpleName eq 'Secretaria') or (user['class'].simpleName eq 'Administrador')}">
								<li><a href="/madodis/listarCursos">Cursos</a></li>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${user['class'].simpleName eq 'Administrador'}">
								<li><a href="/madodis/listarInstituicoes">Instituições</a></li>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${user['class'].simpleName eq 'Administrador'}">
								<li><a href="/madodis/listarSecretarias">Secretarias</a></li>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when
								test="${(user['class'].simpleName eq 'Secretaria') or (user['class'].simpleName eq 'Coordenador') or (user['class'].simpleName eq 'Administrador')}">
								<li><a href="/madodis/listarDisciplinas">Disciplinas</a></li>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${(user['class'].simpleName eq 'Secretaria') or (user['class'].simpleName eq 'Administrador')}">
								<li><a href="/madodis/listarCoordenadores">Coordenadores</a></li>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${user['class'].simpleName eq 'Professor'}">
								<li><a href="/madodis/listarAulas">Aulas</a></li>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when
								test="${(user['class'].simpleName eq 'Secretaria') or (user['class'].simpleName eq 'Coordenador') or (user['class'].simpleName eq 'Administrador')}">
								<li><a href="/madodis/listarTurmas">Turmas</a></li>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${(user['class'].simpleName eq 'Secretaria') or (user['class'].simpleName eq 'Administrador')}">
								<li><a href="/madodis/listarMatriculas">Matriculas</a></li>
							</c:when>
						</c:choose>
					</ul></li>
				</c:when>
				</c:choose>
				<c:choose>
					<c:when
						test="${user['class'].simpleName eq 'Aluno'}">
						<li><a href="/madodis/minhasNotas/${user.id}">Minhas notas</a></li>
						<li><a href="/madodis/minhasFrequencias/${user.id}">Minhas Frequencias</a></li>
						<li><a href="/madodis/materiais/${user.id}">Materiais</a></li>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when
						test="${user['class'].simpleName ne 'Administrador'}">
						<c:if test="${user['class'].simpleName eq 'Aluno'}">
							<li><a href="/madodis/relatorioAluno/${user.id}">Relatorio</a></li>
						</c:if>
						<c:if test="${user['class'].simpleName eq 'Secretaria'}">
							<li><a href="/madodis/relatorioSecretaria/${user.id}">Relatorio</a></li>
						</c:if>
						<c:if test="${user['class'].simpleName eq 'Professor'}">
							<li><a href="/madodis/medias/${user.id}">Medias</a></li>
							<li><a href="/madodis/relatorioProfessor/${user.id}">Relatorio</a></li>
						</c:if>
						<c:if test="${user['class'].simpleName eq 'Coordenador'}">
							<li><a href="/madodis/relatorioCoordenador/${user.id}">Relatorio</a></li>
						</c:if>
					</c:when>
				</c:choose>
				<li><a href="/madodis/sobre">Sobre</a></li>
				<li><a href="/madodis/recursos">Recursos</a></li>
				<li><a href="/madodis/form_contatos">Contato</a></li>
				<li><a href="/madodis/sair">Sair</a></li>

			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</div>
<!-- /.navbar -->