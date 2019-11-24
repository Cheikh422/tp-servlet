<!DOCTYPE html>
<%@page import="fr.dta.poei.entities.User"%>
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

<h3>Ajout d'un nouvel utilisateur</h3>

<div>
  <form action="AddUserServlet" method="post">
    <label for="fname">User Name</label>
    <input type="text" id="usrname" name="username" >    
    
    <label for="fname">First Name</label>
    <input type="text" id="fname" name="firstname" >

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastname" >
    
    <label for="lname">Adresse</label>
    <input type="text" id="add" name="adresse" >    
    
    <label for="lname">Phone</label>
    <input type="text" id="phn" name="phone" >   
    
    <label for="lname">Email</label>
    <input type="text" id="mail" name="email" >   
    
    <label for="lname">Passeword</label>
    <input type="password" id="pswd" name="passeword" value="">

  
    <input type="submit" value="Ajouter" name="submit" >
  </form>
</div>

</body>