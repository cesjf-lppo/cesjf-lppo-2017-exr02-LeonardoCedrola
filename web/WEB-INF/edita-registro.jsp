<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edita Reclamação</title>
    </head>
    <body>
        <h1>Edita Reclamação</h1>
        <form method="post">
            <div><input type="hidden" name="id" value="${reclamacao.id}" /> id: ${reclamacao.id}</div>
            <div><label>Nome: <input type="text" name="nome" value="${reclamacao.nome}" /></label></div>
            <div><label>Email: <input type="text" name="email" value="${reclamacao.email}" /></label></div>
            <div><label>Descrição: <input type="text" name="descricao" value="${reclamacao.descricao}" /></label></div>
            Status: ${reclamacao.stringStatus()} <select name="status">
                <option value="${reclamacao.status}"></option>
                <option value="0">Aberto</option>
                <option value="1">Confirmado</option>
                <option value="2">Recusado</option>
                <option value="3">Em execução</option>
                <option value="4">Resolvido</option>
            </select>
            <div><input type="submit"/></div>
        </form>
    </body>
</html>
