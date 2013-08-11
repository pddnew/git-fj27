<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Deseja remover?</h4>
	<input type="text" value="${produto.descricao }" disabled="disabled"/>
	<input type="text" value="${produto.quantidade }" disabled="disabled"/>
	<a href="/estoque/produto/remover/${produto.id }">Remover</a>
</body>
</html>