<!DOCTYPE html>
<%@page import="fr.dta.poei.entities.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<body>

	<h3>Edition du profile</h3>

	<div>
		<form action="${pageContext.request.contextPath}/EditUserServlet"
			method="post">
			<c:if test="${user != null}">

				<img src="${user.getPhotoUrl()}" alt="Paris" width="150" height="150">
				<label for="fname">User Name</label>
				<input type="text" id="usrname" name="username"
					value="${user.getUserName()}" disabled>

				<label for="fname">First Name</label>
				<input type="text" id="fname" name="firstname"
					value="${user.getFirstName()}" disabled>

				<label for="lname">Last Name</label>
				<input type="text" id="lname" name="lastname"
					value="${user.getLastName()}" disabled>

				<label for="lname">Adresse</label>
				<input type="text" id="add" name="adresse"
					value="${user.getAdresse()}" disabled>

				<label for="lname">Phone</label>
				<input type="text" id="phn" name="phone" value="${user.getPhone()}" disabled>

				<label for="lname">Email</label>
				<input type="text" id="mail" name="email" value="${user.getEmail()}" disabled>

				<label for="lname">Passeword</label>
				<input type="password" id="pswd" name="passeword" value="" disabled>


				<input type="submit" value="Modifier" name="edit">
				<input type="submit" value="Index" name="index">
			</c:if>

		</form>
	</div>

</body>