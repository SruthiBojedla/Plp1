<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="site-name" style="color: Red; font-size: 50px">
		<b>CapStore</b>&nbsp; &nbsp; <img
			src="C:\Users\bsruthi\Desktop\capstore.png" width="125" height="125" />
	</div>

	<div class="header-bar" align="Right">
		<j:if test="${pageContext.request.userPrincipal.name != null}">
        Hello Japan  &nbsp;|&nbsp;
           <a href="${pageContext.request.contextPath}/logout">Logout</a>
			<br>
			<br>
			<a href="Home.jsp""${pageContext.request.contextPath}/home">Home
			</a> &nbsp;|&nbsp;
             <a href="ProductManagement.jsp""${pageContext.request.contextPath}/productManagement">Product
				Management </a>&nbsp;|&nbsp;
             <a href="${pageContext.request.contextPath}/order">Order
			</a>&nbsp;|&nbsp;
            <a href="${pageContext.request.contextPath}/contact">Contact
			</a>&nbsp;|&nbsp;
			<a href="DandP.jsp""${pageContext.request.contextPath}/discounts&promos">Discounts
				& Promos </a>
		</j:if>
	</div>
	<br>
	<br>
	<div class="page-heading" style="color: blue; font-size: 25px">
		<b>Remove Product</b>
	</div>
	<br>
	<br>
	<form action="action_page.php">
		<table>

			<tr>
				<label for="id"><td><b>Product Id:</b></td></label>
				<td><input type="text" name="pId" required /></td>

			</tr>
		</table>
		<br>
		<button type="submit">Remove</button>
		&nbsp; &nbsp; &nbsp;



	</form>
</body>
</html>