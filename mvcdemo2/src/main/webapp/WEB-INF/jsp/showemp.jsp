<html>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" rel="stylesheet" integrity="sha384-sZG5VVk41YqhJjYXgJFoRVd3d2AdDgy4oyIytQJMGx/Mizz1N+5bgKQBSCGfKQnP" crossorigin="anonymous">
<body class="jumbotron">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ page isELIgnored="false"%>    
   
   
   <h1>Employees List </h1>  
   <table class="table table-hover">
  <thead>
    <tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>  
  </thead>
  <tbody>
  <c:forEach var="mp" items="${ist}" >  
    <tr class="table-default">
      <td><c:out value="${mp.id}"/></td>  
   <td><c:out value="${mp.name}"/></td>  
   <td><c:out value="${mp.salary}"/></td>  
   <td><c:out value="${mp.desigination}"/></td>  
   <td><a href="editemp/${mp.id}">Edit</a></td>  
   <td><a href="deleteemp/${mp.id}">Delete</a></td> 
      </tr>
      </c:forEach> 
   </tbody>
</table> 
   <br/> 
    
   <a href="empform">Add New Employee</a>
   </body>
   </html>  