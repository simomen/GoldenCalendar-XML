package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classe.TransformXML;

/**
 * Servlet implementation class SubXML
 */
@WebServlet("/SubXML")
public class SubXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String cheminProject;
	public static String cheminDocuments;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

		cheminProject = config.getServletContext().getRealPath("")
				+ File.separator;
		cheminDocuments = cheminProject + File.separator + "Documents"
				+ File.separator;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubXML() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			TransformXML.transform(
					cheminDocuments + "XML_Calendrier_brute.xml",
					cheminDocuments + "XSL_DetXML.xsl", cheminDocuments
							+ "XML_Det.xml", TransformXML.XmlType);
			
			TransformXML.transform(
					cheminDocuments + "XML_Calendrier_brute.xml",
					cheminDocuments + "XSL_GenXML.xsl", cheminDocuments
							+ "XML_Gen.xml", TransformXML.XmlType);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}

		response.sendRedirect("Documents/XML_Gen.xml");

	}

}
