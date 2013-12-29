package servlet;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classe.ConvertToPDF;

/**
 * Servlet implementation class ConvertPDF
 */
@WebServlet("/ConvertPDF")
public class ConvertPDF extends HttpServlet {
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
	public ConvertPDF() {
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
		String cheminXSL = cheminDocuments + "XSL_PDF.xsl";
		String cheminXML = cheminDocuments + "XML_Calendrier_brute.xml";
		String cheminPDF = cheminDocuments + "PDF_Calendrier.pdf";
		ConvertToPDF convPdf = new ConvertToPDF();
		convPdf.convertPDF(cheminXML, cheminXSL, cheminPDF);
		response.sendRedirect("pdf.jsp");
		//Desktop desk = Desktop.getDesktop();
		//desk.open(new File(cheminDocuments + "PDF_Calendrier.pdf"));

	}
}
