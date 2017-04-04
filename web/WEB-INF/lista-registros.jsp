<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Reclamações</title>
    </head>
    <body>
        <h1>Listagem de Reclamações</h1>
        <a href="novo.html">Nova reclamação</a>
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>status</th>
                <th>Editar</th>
            </tr>
            <c:forEach var="reclamacao" items="${reclamacoes}">
                <tr>
                    <td>${reclamacao.id}</td>
                    <td>${reclamacao.nome}</td>
                    <td>${reclamacao.email}</td>
                    <td>${reclamacao.stringStatus()}</td>
                    <td><a href="edita.html?id=${reclamacao.id}">Editar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
