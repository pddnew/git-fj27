<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar</title>
</head>
<body>
	<form action="/estoque/produto/alterar" method="post">
		<input type="hidden" name="id" value="${produto.id }"/><br/>
		Descricao: <input type="text" name="descricao" value="${produto.descricao }"/>
		<form:errors path="produto.descricao"/><br/>
		Quantidade: <input type="text" name="quantidade" value="${produto.quantidade }"/>
		<form:errors path="produto.quantidade"/><br/>
		<input type="submit" value="Alterar">
	</form>
</body>
</html>