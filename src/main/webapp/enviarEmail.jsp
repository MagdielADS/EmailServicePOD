<%@page import="br.edu.ifpb.emailsharedpod.Pessoa"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href= "bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="bootstrap/js/jquery.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="carregaPessoas.js"></script>
        <link href="css/styles.css" rel="stylesheet">
        <title>Nova Mensagem</title>        
    </head>
    <body>
        <%
            List<Pessoa> pessoas = (List<Pessoa>) session.getAttribute("pessoas");
            pageContext.setAttribute("pessoas", pessoas);
            String remetente = String.valueOf(session.getAttribute("remetente"));
            pageContext.setAttribute("remetente", remetente);
        %>
        <div class="container">
            <form method="post" action="enviaEmail" class="col-md-6 form-horizontal">
                <h2>PROJETO 3 POD - EMAIL</h2>
                <div class="form-group">
                    <input type="text" name="para" id="para" placeholder="Para" class="form-control" required readonly/>    
                </div>
                <div class="form-group">
                    <input type="text" name="de" placeholder="Nome do Remetente" class="form-control" required readonly value="${remetente}"/>
                </div>
                <div class="form-group">
                    <input type="text" name="assunto" placeholder="Assunto" class="form-control" required/>
                </div>
                <div class="form-group">
                    <textarea name="texto" class="input-lg col-xs-12" rows="8" placeholder="Mensagem" required></textarea>
                </div>
                <input class="btn btn-primary btn-lg pull-right" type="submit" value="Enviar"/>
            </form>
            <div class="row pull-left">
                <h2 class="pull-left">Escolha seu(s) destinatário(s)</h2>
                <form id="logoutForm" method="post" class="pull-right" action="logout"><input type="submit" class="btn btn-large btn-danger pull-right" value="Sair"/></form>
            </div>
            <div class="col-md-6" id="divEmails"> 
                <c:forEach items="${pessoas}" var="pessoa">
                    <input id="${pessoa.nome} ${pessoa.email}" value="${pessoa.email}" type="button" class="emails btn btn-primary btn-large col-xs-12" onclick="carregarPesssoas(this)"/></br>
                </c:forEach>
            </div>
               
                <c:if test="${sucesso!=null}">
                    <c:choose>
                        <c:when test="${sucesso == true}">
                            <div class="pull-left alert alert-success alert-dismissable">
                                Your email has been received and eventually will be sent
                            </div>
                        </c:when>
                        <c:when test="${sucesso == false}">
                            <div class="pull-left alert alert-danger alert-dismissable">
                                Your email has not been received
                            </div>
                        </c:when>
                    </c:choose>
                </c:if>
            
        </div>
    </body>
</html>