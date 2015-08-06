<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<c:url value="/j_spring_security_check" var="loginUrl" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>

<script src="<c:url value="/resources/lib/js/angularjs/angular.min.js" />"></script>

</head>
<body>
 
<h1>
 
Login</h1><div id="login-error">
 
 
${error}</div><form name="myForm" ng-app="myApp" ng-controller="validateCtrl" action="${loginUrl}" method="post" novalidate>
 
 
 
<p>
 
 
<label for="j_username">Username</label>
<input id="j_username" name="j_username" type="text" ng-model="j_username" required />
<span style="color:red" ng-show="myForm.j_username.$dirty && myForm.j_username.$invalid">
<span ng-show="myForm.j_username.$error.required">Username is required.</span>
</span>
</p><p>
 
 
<label for="j_password">Password</label>
<input id="j_password" name="j_password" type="password" ng-model="j_password" required />
<span style="color:red" ng-show="myForm.j_password.$dirty && myForm.j_password.$invalid">
<span ng-show="myForm.j_password.$error.required">Password is required.</span>
</span>
</p><input  type="submit" value="Login"
ng-disabled="myForm.j_username.$dirty && myForm.j_username.$invalid ||  
myForm.j_password.$dirty && myForm.j_password.$invalid"/>        
 
</form></body>

<script>
var app = angular.module('myApp', []);
app.controller('validateCtrl', function($scope) {

});
</script>
</html>