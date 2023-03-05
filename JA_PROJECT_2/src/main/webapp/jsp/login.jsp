<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

	<link rel="stylesheet"
		  href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
		  integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
		  crossorigin="anonymous">
	<link rel="stylesheet"
		  href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
		  integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
		  crossorigin="anonymous">
	<link rel="stylesheet" href="login.css" type="text/css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<section class="vh-100 d-flex align-items-center">
		<div class="container-fluid d-flex justify-content-center">

			<form method="POST" action="${contextPath}/login" class="form-signin" style="width: 23rem;">

				<h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Log in</h3>

				<div class="form-outline mb-4">
					<input name="email" type="text" class="form-control form-control-lg" autofocus="true" id="form2Example18"/>
					<label class="form-label" for="form2Example18">Email address</label>
				</div>

				<div class="form-outline mb-4">
					<input name="password" type="password" class="form-control form-control-lg" id="form2Example28"/>
					<label class="form-label" for="form2Example28">Password</label>
				</div>

				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

				<div class="pt-1 mb-4">
					<button class="btn btn-info btn-lg btn-block btn-primary" type="submit">Login</button>
				</div>

				<p class="small mb-5 pb-lg-2"><a class="text-muted" href="#!">Forgot password?</a></p>
				<p>Don't have an account? <a href="${contextPath}/registration" class="link-info">Register here</a></p>

			</form>

		</div>
	</section>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
