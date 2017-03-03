<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="NewServlet">
		<h4>
			I want more information about this servlet. <input type="submit"
				value="Yes" />
		</h4>
		<h3>
			<%
				String input = (String) request.getAttribute("servletInformation");
				if (input == null) {

				} else {
					out.println(input);
				}
			%>
		</h3>
	</form>
</body>
</html>