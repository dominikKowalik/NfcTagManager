<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta>
    <title>index</title>
</head>
<body ng-app="app" ng-controller="main">
<h1>index</h1>

{{name}}

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script src="<c:url value="/static/js/app.js"/>"></script>
</body>
</html>