<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home - page</title>
    <!-- CSS only -->
   	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
   	<link rel="stylesheet" href="main.scss">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="container">
	
	
	    <!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item"><spring:message code="home.menu"></spring:message></h3>
			<a href="/home" class="w3-bar-item w3-button"><spring:message code="home.home"></spring:message></a>
			<a href="/entrant-registration" class="w3-bar-item w3-button"><spring:message code="home.entrantRegistration"></spring:message></a>
			<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
				<a href="/entrant-enrolling" class="w3-bar-item w3-button"><spring:message code="home.enrollEntrant"></spring:message></a>
			</security:authorize>
			<a href="/entrants" class="w3-bar-item w3-button"><spring:message code="home.entrants"></spring:message></a>
			<a href="/received-entrants" class="w3-bar-item w3-button"><spring:message code="home.receivedEntrants"></spring:message></a>
		</div>
	
	
	    <!-- Page Content -->
	    <div style="margin-left: 10%">
	
	        <div class="w3-container w3-teal">
	            <h1>Periodicals</h1>
	        </div>
	
	        <div class="w3-container">
	
	            <c:if test="${pageContext.request.userPrincipal.name != null}">
	                <form id="logoutForm" method="POST" action="${contextPath}/logout">
	                    <input type="hidden" name="${_csrf.parameterName}"
	                           value="${_csrf.token}" />
	                </form>
	                <h2>
	                    Welcome ${pageContext.request.userPrincipal.name} |
						<button onclick="document.forms['logoutForm'].submit()">Logout</button>
	                </h2>
	            </c:if>
	
	
	            <section class="ftco-section">
	                <div class="container">
	                    <div class="row justify-content-center">
	                        <div class="col-md-6 text-center mb-5">
	                            <h2 class="heading-section">All Specialities</h2>
	                        </div>
	                    </div>
	                    <div class="row">
	                        <div class="col-md-12">
	                            <div class="table-wrap">
	                                <table class="table table-bordered table-dark table-hover">
	                                    <thead>
	                                    <tr>
	                                        <th>Number</th>
	                                        <th>Name</th>
	                                        <th>Educational Degree</th>
	                                        <th>Contract</th>
	                                        <th>Min ZNO Score</th>
	                                    </tr>
	                                    </thead>
	                                    <tbody>
	                                    <c:if test="${not empty specialities}">
	                                        <c:forEach items="${specialities}" var="currentSpeciality">
												<tr>
													<td>${currentSpeciality.specialityNumber}</td>
													<td>${currentSpeciality.specialityName}</td>
													<td>${currentSpeciality.educationalDegree}</td>
													<td>${currentSpeciality.contractAmount}</td>
													<td>${currentSpeciality.minAvZno}</td>
												</tr>
											</c:forEach>
	                                    </c:if>
	
	                                    </tbody>
	                                </table>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </section>
	        </div>
	
	    </div>
	
	
	</div>
	<!-- /container -->
	<script
	        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>