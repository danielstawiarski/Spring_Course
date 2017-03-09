<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista kotów</title>
	</head>
	<body>
		<a href="<c:url value="dodaj" />">Dodaj kota</a><br />
		<table border="1">
			<thead>
				<tr>
					<th>#</th>
					<th>Imie kota</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${koty}" var="kot" varStatus="status">
				<tr>
					<td>${kot.id}</td>
					<td><a href="<c:url value="kot-${kot.id}" />">${kot.imie}</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<hr />
		Uwaga! W kontekście użycia HTML oraz sposobu budowania stron, te rozwiązania są bardziej antyprzykładem niż materiałem do nauki!<br />
		Jeśli chciałabyś także tworzyć same widoki i pisac poprawny, dobrze skonstruowany kod HTML, zachęcamy do zapoznania się np. z frameworkiem <a href="http://getbootstrap.com" target="_blank">Bootstrap</a>.
	</body>
</html>