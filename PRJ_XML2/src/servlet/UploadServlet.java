package servlet;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
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

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import classe.ConvertICS;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
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
	public UploadServlet() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String chemin = request.getParameter("file");
		Path source = Paths.get(chemin);
		Path dest = Paths.get("ICS_Calendrier.ics");

		try {
			Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
			ConvertICS ICS = new ConvertICS(cheminDocuments
					+ "ICS_Calendrier.ics");
			String XMLresult = ICS.convertFile();

			if (XMLresult != null)
				response.sendRedirect("index.jsp");
			else
				response.sendRedirect("error.jsp");
		} catch (IOException e) {
			response.sendRedirect("error.jsp");
		}
	}
}
