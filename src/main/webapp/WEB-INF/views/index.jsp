<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
    <title>index</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
</head>

<body ng-app="app">

<style>
    label {
        font-size: 2em;
    }

    body{
        background-color: #e1e1e1;
    }
</style>

<div class="container-fluid">
    <nav class="navbar navbar-inverse navbar-fixed">
        <div class="container-fluid">
            <ul class="nav navbar-nav">
                <li></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Znaczniki Administracyjne
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a ui-sref="addAdminTag">Dodaj Znacznik</a></li>
                        <li><a ui-sref="adminTags">Wszystkie Znaczniki</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</div>

<div ui-view/>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script src="http://angular-ui.github.io/ui-router/release/angular-ui-router.js"></script>
<script src="<c:url value="/static/js/app.js"/>"></script>
<script src="<c:url value="/static/js/service/NfcTagService.js"/>"></script>
<script src="<c:url value="/static/js/service/TagOwnerService.js"/>"></script>
<script src="<c:url value="/static/js/controllers/adminTagsController.js"/>"></script>
<script src="<c:url value="/static/js/controllers/addAdminTagController.js"/>"></script>

</body>
</html>
