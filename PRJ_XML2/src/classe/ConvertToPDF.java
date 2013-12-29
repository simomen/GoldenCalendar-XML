package classe;

import java.io.File;
import java.io.OutputStream;

//JAXP  
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.sax.SAXResult;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

/**
 * This class demonstrates the conversion of an XML file to PDF using JAXP
 * (XSLT) and FOP (XSL-FO).
 */
public class ConvertToPDF {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            command-line arguments
	 */

	public String convertPDF(String cheminXML, String cheminXSL,
			String cheminPDF) {

		File pdffile = null;
		try {

			// Setup input and output files
			File xmlfile = new File(cheminXML);

			File xsltfile = new File(cheminXSL);
			pdffile = new File(cheminPDF);

			// configure fopFactory as desired
			FopFactory fopFactory = FopFactory.newInstance();

			// Setup output
			OutputStream out = new java.io.FileOutputStream(pdffile);
			out = new java.io.BufferedOutputStream(out);

			try {
				// Construct fop with desired output format
				Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);
				// Setup XSLT
				TransformerFactory factory = TransformerFactory.newInstance();
				Transformer transformer = factory
						.newTransformer(new StreamSource(xsltfile));

				// Set the value of a <param> in the stylesheet
				transformer.setParameter("versionParam", "2.0");

				// Setup input for XSLT transformation
				Source src = new StreamSource(xmlfile);

				// Resulting SAX events (the generated FO) must be piped through
				// to FOP
				Result res = new SAXResult(fop.getDefaultHandler());

				// Start XSLT transformation and FOP processing
				transformer.transform(src, res);
			} finally {
				out.close();
			}

			System.out.println("PDF Ok");
		} catch (Exception e) {
			e.printStackTrace(System.err);
			System.exit(-1);
		}
		return pdffile.getPath();
	}
}