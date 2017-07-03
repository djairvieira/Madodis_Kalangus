<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Madodis - Home</title>
	<link rel="favicon" href="/madodis/resources/images/favicon.png">
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="/madodis/resources/css/bootstrap.css">
	<link rel="stylesheet" href="/madodis/resources/css/font-awesome.min.css"> 
	<link rel="stylesheet" href="/madodis/resources/css/bootstrap-theme.css" media="screen"> 
	<link rel="stylesheet" href="/madodis/resources/css/style.css">
    <link rel='stylesheet' id='camera-css'  href='/madodis/resources/css/camera.css' type='text/css' media='all'> 
    <link rel='stylesheet' href="/madodis/resources/css/jAlert.css" />
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="/madodis/resources/js/html5shiv.js"></script>
	<script src="/madodis/resources/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<jsp:include page="menu.jsp">
		<jsp:param value="${user}" name="user"/>
	</jsp:include>

	<!-- Header -->
	<header id="head">
		<div class="container">
             <div class="heading-text">							
							<p>Olá <c:out value="${user.nome}" />, bem vindo(a) ao</p>
							<h1 class="animated flipInY delay1">Madodis</h1>
							<p>Módulo Acadêmico para o Gerenciamento de Corpo Docente e Discente.</p>
						</div>
            
					<div class="fluid_container">                       
                    	<div class="camera_wrap camera_emboss pattern_1" id="camera_wrap_4">
                        
                        </div> 
                    </div><!-- #camera_wrap_3 -->
                </div><!-- .fluid_container -->
		</div>
	</header>
	<!-- /Header -->

	<jsp:include page="rodape.jsp" />
    
    
</body>
</html>
