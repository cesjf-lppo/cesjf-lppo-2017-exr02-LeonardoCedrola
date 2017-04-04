<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cria Registro</title>
    </head>
    <body>
        <h1>Cria Registro</h1>
        <form method="post">
            <div><label>Nome: <input type="text" name="nome"  /></label></div>
            <div><label>Email: <input type="text" name="email"  /></label></div>
            <div><label>Descrição: <input type="text" name="descricao"  /></label></div>
            Status: <select name="status">
                <option value="-1"></option>
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
