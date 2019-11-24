<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/style.css" rel="stylesheet" type="text/css">

<title>Index</title>
</head>
<body>
Bonjour <%=session.getAttribute("User_session")%> 		


	<form action="IndexServlet" method="post">
		<button type="submit" name="add">Ajout d'un nouvel
			utilisateur</button>

		<table border="1" cellpadding="5" cellspacing="5">
			<tr>
				<th>Choice</th>
				<td>Photo</td>
				<th>UserName</th>
				<th>Name</th>
				<th>Laste name</th>
				<th>Email</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach var="user" items="${users}">
				<tr>
					<td><input type="checkbox" /></td>
					<td><img src="${user.getPhotoUrl()}" alt="" height=20 width=20></img></td>
					<td>${user.getUserName()}</td>
					<td>${user.getFirstName()}</td>
					<td>${user.getLastName()}</td>
					<td>${user.getEmail()}</td>
					<td><input type="submit" value="${user.getId().toString()}"
						name="view"></td>
					<td><input type="submit" value="${user.getId().toString()}"
						name="delete"
						onclick="return confirm('Vous êtes sûr de vouloir supprimer cet utilisateur ?')"></td>
				</tr>
			</c:forEach>
		</table>
		<%--For displaying Previous link except for the 1st page --%>
		<c:if test="${currentPage != 1}">
			<td><button type="submit" name="page" value="${currentPage - 1}">Previous</button></td>
		</c:if>
		<%--For displaying Page numbers. 
		The when condition does not display a link for the current page--%>
		<table border="1" cellpadding="5" cellspacing="5">
			<c:if test="${noOfPages<4}">
				<tr>
					<c:forEach begin="1" end="${noOfPages}" var="i">
						<c:choose>
							<c:when test="${currentPage eq i}">
								<td>${i}</td>
							</c:when>
							<c:otherwise>
								<td><button type="submit" name="page" value="${i}">${i}</button></td>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</tr>
			</c:if>
			<c:if test="${noOfPages>3}">
				<tr>
					<td><button type="submit" name="page" value="1">First</button></td>
					<c:if test="${currentPage>2&&currentPage<noOfPages-2}">

						<c:forEach begin="${currentPage-1}" end="${currentPage+1}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<td>${i}</td>
								</c:when>
								<c:otherwise>
									<td><button type="submit" name="page" value="${i}">${i}</button></td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					<c:if test="${currentPage==2||currentPage==1}">
						<c:forEach begin="${currentPage}" end="${currentPage+2}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<td>${i}</td>
								</c:when>
								<c:otherwise>
									<td><button type="submit" name="page" value="${i}">${i}</button></td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					<c:if
						test="${currentPage==noOfPages-2||currentPage==noOfPages-1||currentPage==noOfPages}">
						<c:forEach begin="${noOfPages-3}" end="${noOfPages-1}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<td>${i}</td>
								</c:when>
								<c:otherwise>
									<td><button type="submit" name="page" value="${i}">${i}</button></td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					<td><button type="submit" name="page" value="${noOfPages}">Last</button></td>
				</tr>
			</c:if>
		</table>

		<%--For displaying Next link --%>
		<c:if test="${currentPage lt noOfPages}">
			<td><button type="submit" name="page" value="${currentPage + 1}">Next</button></td>
		</c:if>

	</form>


</body>
</html>