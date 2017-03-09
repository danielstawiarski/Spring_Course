<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Szczegóły kota</title>
	</head>
	<body>
		<a href="lista">Powrót do listy kotów</a><br />
		<table border="1">
			<tbody>
				<tr>
					<th>Imię</th>
					<td>${kot.imie}</td>
				</tr>
				<tr>
					<th>Data urodzenia</th>
					<td><fmt:formatDate pattern="dd.MM.yyyy" value="${kot.dataUrodzenia}" /></td>
				</tr>
				<tr>
					<th>Waga</th>
					<td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${kot.waga}" /> kg</td>
				</tr>
				<tr>
					<th>Imię opiekuna</th>
					<td>${kot.imieOpiekuna}</td>
				</tr>
			</tbody>
		</table>
		<br />
		<hr />
		Uwaga! W kontekście użycia HTML oraz sposobu budowania stron, te rozwiązania są bardziej antyprzykładem niż materiałem do nauki!<br />
		Jeśli chciałabyś także tworzyć same widoki i pisac poprawny, dobrze skonstruowany kod HTML, zachęcamy do zapoznania się np. z frameworkiem <a href="http://getbootstrap.com" target="_blank">Bootstrap</a>.
	</body>
</html>