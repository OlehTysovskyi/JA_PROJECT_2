<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

    <title>Specialities - page</title>
    <!-- CSS only -->
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
   	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
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
	            <h1>Enroll Entrants</h1>
	        </div>

	        <div class="w3-container">

				<div class="w3-container">
					<table>
						<thead>
						<tr>
							<th>Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Av ZNO</th>
							<th>Speciality</th>
							<th>Enroll Entrant</th>
						</tr>
						</thead>

						<tbody>
						<c:forEach items="${entrants}" var="entrant">
							<form:form method="POST" action="${contextPath}/entrantEnrolling" modelAttribute="entrant" enctype="multipart/form-data">
								<input type="hidden" name="id" value="${entrant.id}"/>
								<c:if test="${entrant.received == false}">
								<tr>
									<td>${entrant.id}</td>
									<td>${entrant.user.firstName}</td>
									<td>${entrant.user.lastName}</td>
									<td>${entrant.avZnoScore}</td>
									<td>${entrant.speciality.specialityNumber} | ${entrant.speciality.specialityName}</td>
									<td><input type="submit" value="Enroll" /></td>
								</tr>
								</c:if>
							</form:form>

						</c:forEach>
						</tbody>
					</table>
				</div>
	        </div>
	    </div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<!-- JavaScript Bundle with Popper -->
	<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>--%>
</body>
</html>