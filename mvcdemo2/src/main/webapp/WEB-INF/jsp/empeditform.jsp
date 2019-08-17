<html>
<head><link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" rel="stylesheet" integrity="sha384-sZG5VVk41YqhJjYXgJFoRVd3d2AdDgy4oyIytQJMGx/Mizz1N+5bgKQBSCGfKQnP" crossorigin="anonymous"></head>
<body>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
        <h1>Edit Employee</h1>  
       <form:form method="POST" command="emp" action="/mvcdemo2/editsave">    
        <table >  
        <tr>    
          <td hidden>Id : </td>   
          <td><form:hidden path="id"  /></td>  
         </tr>   
         <tr>    
          <td className="col-form-label col-form-label-lg">Name : </td>   
          <td><form:input className="form-control form-control-lg" path="name"  /></td>  
         </tr>    
         <tr>    
          <td className="col-form-label col-form-label-lg">Salary :</td>    
          <td><form:input className="form-control form-control-lg" path="salary" /></td>  
         </tr>   
         <tr>    
          <td className="col-form-label col-form-label-lg">Designation :</td>    
          <td><form:input className="form-control form-control-lg" path="desigination" /></td>  
         </tr>   
          <td> </td>    
          <td><input className="btn btn-primary btn-lg" type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>
</body>
</html>           