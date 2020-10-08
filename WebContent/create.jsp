 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Create</title>
</head>
<body>
	<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>	
<form:form method="post" modelAttribute="student">
<pre>
   
	
	
	Name: <form:input path="name" />
	
	Email: <form:input path="email" />
	
	Course: <form:input path="course" />
	
	Address: <form:input path="address"/>
	

	City: 
		<form:select path="city">
			<form:option value="0" label="select"/>
			<form:options items="${cities}" itemValue="cityName" itemLabel="cityName"/>
		</form:select>

	Subjects: 
		<form:checkboxes items="${subjects}" path="subjects" itemLabel="value" itemValue="key" name="subjects"/>
	
	
	<input type="submit" value="Create" />
</pre>
</form:form>
${msg}
</body>
</html>