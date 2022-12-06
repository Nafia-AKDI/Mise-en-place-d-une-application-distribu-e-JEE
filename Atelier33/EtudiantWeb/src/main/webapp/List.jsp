<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<title>Etudiants</title>
	<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Gestion des Etudiants</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8081/">Etudiant </a>
      </li>
      
    </ul>
  </div>
</nav>
	<center>
		<h1>List des Etudiants</h1>
        
	</center>
    <div align="center">
                <h2>
        	<a href="new">Ajouter un Etudiant</a>
        	&nbsp;&nbsp;&nbsp;
        	
        	
        </h2>
        <table border="1" cellpadding="5">

            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Cne</th>
                <th>Adress</th>
                <th>Niv</th>
                <th>Actions</th>
            </tr>
               <c:forEach var="etudiant" items="${ list }">
                <tr>
                    <td><c:out value="${etudiant.idEtudiant}" /></td>
                    <td><c:out value="${etudiant.nomEtudiant}" /></td>
                    <td><c:out value="${etudiant.preEtudiant}" /></td>
                    <td><c:out value="${etudiant.adresseEtudiant}" /></td>
                     <td><c:out value="${etudiant.niveauEtudiant}" /></td>
                      <td><c:out value="${etudiant.cneEtudiant}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${etudiant.idEtudiant}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${etudiant.idEtudiant}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
 



</body>
</html>