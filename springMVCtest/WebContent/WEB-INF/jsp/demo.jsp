<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Normal Parameter: <blockquote>${helloAgain}</blockquote>
	<h3>Person</h3>
	<p>Name:&nbsp;${personObject.name }</p>
	<p>Age:&nbsp;${personObject.age }</p>
	<p>
		<a href="<%=request.getContextPath()%>/person/Mary">Show Mary</a>
	</p>
	<p>
		<a href="<%=request.getContextPath()%>/person/Jane/28">Show Jane age 28</a>
	</p>
	<p>
		<a href="<%=request.getContextPath()%>/viewdemo">Show Default</a>
	</p>
</body>
</html>