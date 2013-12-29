<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="top.jsp"></jsp:include>

<form action="GetCalendar" method="post">
	Date start : <input type="date" name="dateStart"> <br>
	Date   end : <input type="date" name="dateEnd"> <br>
	<fieldset>
		<legend>Choose classes</legend>
		<input type="checkbox" name="listClasses" value="M1_Info" />M1 Info<br />
		<input type="checkbox" name="listClasses" value="MLDM" />MLDM<br />
		<input type="checkbox" name="listClasses" value="M2_Info" />M2 Info<br />
		<input type="checkbox" name="listClasses" value="L2_Info" />L2 Info<br />
		<input type="checkbox" name="listClasses" value="L3_Biologie" />L3
		Biologie<br /> <input type="checkbox" name="listClasses"
			value="L3_Physique" />L3 Physique<br />
	</fieldset>
	<input type="submit" class="button circled scrolly" value="Get File">

</form>
<jsp:include page="bas.jsp"></jsp:include>
