package servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classe.ConvertICS;

/**
 * Servlet implementation class GetCalendar
 */
@WebServlet("/GetCalendar")
public class GetCalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String cheminProject;
	public static String cheminDocuments;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCalendar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

		cheminProject = config.getServletContext().getRealPath("")
				+ File.separator;
		cheminDocuments = cheminProject + File.separator + "Documents"
				+ File.separator;

		System.out.println("chemin projet : " + cheminProject);
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

		PrintWriter out = response.getWriter();

		String dateStart = request.getParameter("dateStart");
		String dateEnd = request.getParameter("dateEnd");
		String resources = "";
		String urlICS = "";
		String valueClasses = "";
		String[] listClasses = request.getParameterValues("listClasses");
		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream(cheminProject + "classes.properties"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		for (int i = 0; i < listClasses.length; i++) {
			out.println(listClasses[i]);
			valueClasses = prop.getProperty(listClasses[i]);
			out.println(valueClasses);
			if (valueClasses != null) {
				resources += valueClasses;
				if (i != listClasses.length)
					resources += ",";
			}
		}

		urlICS = "http://planning.univ-st-etienne.fr/ade/custom/modules/plannings/anonymous_cal.jsp?resources="
				+ resources
				+ "&projectId=7&calType=ical&firstDate="
				+ dateStart + "&lastDate=" + dateEnd;

		File file = new File(cheminDocuments, "ICS_Calendrier.ics");
		URL url = new URL(urlICS);
		URLConnection connection = url.openConnection();
		InputStream stream = connection.getInputStream();
		BufferedInputStream in = new BufferedInputStream(stream);
		FileOutputStream fileICS = new FileOutputStream(file);
		BufferedOutputStream outICS = new BufferedOutputStream(fileICS);

		int i;
		while ((i = in.read()) != -1) {

			outICS.write(i);
		}
		outICS.flush();

		ConvertICS ICS = new ConvertICS(cheminDocuments);
		String XMLresult = ICS.convertFile();

		if (XMLresult != null) {
			response.sendRedirect("Documents/XML_Calendrier_brute.xml");
		} else
			response.sendRedirect("error.jsp");
	}
}
