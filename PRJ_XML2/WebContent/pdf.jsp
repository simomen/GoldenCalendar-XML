<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="top.jsp"></jsp:include>
<p>
	It appears you don't have a PDF plugin for this browser. No problem,
	you can still <a href="Documents/PDF_Calendrier.pdf">download
		the PDF file.</a>
</p>
<embed src="Documents/PDF_Calendrier.pdf" width="850" height="650"
	type='application/pdf'></embed>

<jsp:include page="bas.jsp"></jsp:include>