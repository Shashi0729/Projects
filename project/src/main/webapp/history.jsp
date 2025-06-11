<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<table class="table-primary border border-3">
			<tr>
				<th>Id</th>
				<th>LoginDetails</th>
				<th>UserId</th>
				
			</tr>
			<tbody>
				<c:forEach var="l" items="${list}">
					<tr>
						<td>${l.id}</td>
						<td>${l.logInTime}</td>
						<td>${l.userId}</td>
					
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>