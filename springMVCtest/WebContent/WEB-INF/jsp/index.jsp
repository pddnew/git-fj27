<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Spring</h1>
	<p>
		This was passed in from the controller thus showing that the controller was accessed before the page was rendered.
		This is MVC (Model View Controller) in action.
	</p>
	<p>
		Simple values can be rendered as so i.e. here's the value from the controller:<blockquote>${hello}</blockquote>	
	<p>
		<a href="person/Mary">Mary</a>
	</p>
	
	<p>
		Notice: This application were done using the tutorial in the URL:
		<br/> http://outbottle.com/spring-3-web-mvc-friendly-url-using-requestmapping-variable-uri/
		<br/> Last visited: July 07 2013.
	</p>
</body>
</html>