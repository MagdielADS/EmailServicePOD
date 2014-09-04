<%-- 
    Document   : newMessage
    Created on : 03/09/2014, 19:43:48
    Author     : kelsonsd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/EmailServicePOD/css/estilo.css" />
        <title>Nova Mensagem</title>        
    </head>
    <body>
        <div id="div-nova-mensagem">
            <label>PROJETO 3 POD - EMAIL</label><br /><br /><br />
            <label>Para:</label>
            <input type="text" name="para" size="45" /><br /><br />        

            <label>De:</label>
            <input type="text" name="de" size="47" /><br /><br />

            <label>Assunto:</label>
            <input type="text" name="assunto" size="65" /><br /><br />

            <textarea id="id-textarea" name="texto" rows="10" cols="59"></textarea> <br /><br />
            <input id="botao-enviar" class="botoes" type="submit" value="enviar" />
            <input id="botao-cancelar" class="botoes" type="button" value="cancelar" />        
        </div>
    </body>
</html>