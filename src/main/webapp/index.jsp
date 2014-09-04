<%-- 
    Document   : index
    Created on : 4-Sep-2014, 12:43:40 AM
    Author     : Fernando
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email POD</title>
        <link href= "bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="bootstrap/js/jquery.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <link href="css/styles.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <h1 class="text-center login-title">Email POD</h1>
                    <div class="account-wall">
                        <img class="profile-img img-rounded" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                             alt="">
                        <form class="form-signin" action="login" method="post">
                            <input type="text" class="form-control" placeholder="IP SERVIDOR" name="ip" required autofocus>
                            <input type="text" class="form-control" placeholder="Seu Nome" name="remetente" required>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
                        </form>
                    </div>
                        <c:if test="${erro != null}">
                            <div class="alert alert-danger col-xs-12 erro">${erro}</div>
                        </c:if>
                </div>

            </div>
        </div>
    </body>
</html>
