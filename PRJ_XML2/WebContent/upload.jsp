<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="top.jsp"></jsp:include>

<form action="UploadServlet" method="post">
	<input type=file name="file" size="50"><br> <br> <input
		type="submit" class="button circled scrolly" value="Convert">
</form>

<jsp:include page="bas.jsp"></jsp:include>
