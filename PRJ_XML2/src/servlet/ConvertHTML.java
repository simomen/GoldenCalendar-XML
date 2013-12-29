package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classe.TransformXML;

/**
 * Servlet implementation class ConvertHTML
 */
@WebServlet("/ConvertHTML")
public class ConvertHTML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConvertHTML() {
		super();
		// TODO Auto-generated constructor stub
	}

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

		new TransformXML();
		try {
			TransformXML.transform(
					cheminDocuments + "XML_Calendrier_brute.xml",
					cheminDocuments + "XSL_HTML.xsl", 
					cheminDocuments	+ "HTML_Calendrier.html",
					TransformXML.HtmlType);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("html.jsp");

	}

}
