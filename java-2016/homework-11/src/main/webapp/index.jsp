<%@page import="ro.sci.java5.AgeCalculator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Age Calculator</title>
</head>
<body bgcolor="silver">
	<form method="post" action="AgeCalculatorServlet">
		<center>
			<table border="0" width="40%" cellpadding="4">
				<thead>
					<tr>
						<th colspan="4">Age Calculator<br> <br></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Birthday</td>
						<td>Year<input type="text" name="yearOfBirthday" value="" /></td>
						<td>Month<input type="text" name="monthOfBirthday" value="" /></td>
						<td>Day<input type="text" name="birthday" value="" /></td>
					</tr>
					<tr>
						<td>Current day</td>
						<td>Year<input type="text" name="currentYear" value="" /></td>
						<td>Month<input type="text" name="currentMonth" value="" /></td>
						<td>Day<input type="text" name="currentDay" value="" /></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td><input type="submit" value="Calculate" /></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>
							<%
								String result = (String) request.getAttribute("result");
								if (result == null) {

								} else {
									out.println(result);
								}
							%>
						</td>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
</body>
</html>
