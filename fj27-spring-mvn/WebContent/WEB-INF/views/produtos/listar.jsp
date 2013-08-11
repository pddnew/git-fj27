<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Produtos</title>
</head>
<body>
	<c:forEach items="${produtoList }" var="produto">
		${produto.descricao } - ${produto.quantidade }
		<a href="/estoque/produto/mostrar/${produto.id }">detalhes</a>
		<a href="/estoque/produto/editar?id=${produto.id }">editar</a>
		<a href="/estoque/produto/excluir/${produto.id }">remover</a>
		<br/>
	</c:forEach>
</body>
</html>