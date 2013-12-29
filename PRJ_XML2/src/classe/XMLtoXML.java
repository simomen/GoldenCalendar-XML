package classe;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class XMLtoXML {

	public static void creerXML(String xml, String xsl, String html)
			throws Exception {

		// Création de la source DOM
		DocumentBuilderFactory fabriqueD = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructeur = fabriqueD.newDocumentBuilder();
		File fileXml = new File(xml);
		Document document = constructeur.parse(fileXml);
		Source source = new DOMSource(document);

		// Création du fichier de sortie
		// File fileHtml = new File(html);
		File fileHtml = new File(
				"C:/Users/Simo/workspace/PRJ_XML/CalendarDet.xml");
		Result resultat = new StreamResult(fileHtml);

		// Configuration du transformer
		TransformerFactory fabriqueT = TransformerFactory.newInstance();
		StreamSource stylesource = new StreamSource(xsl);
		Transformer transformer = fabriqueT.newTransformer(stylesource);
		transformer.setOutputProperty(OutputKeys.METHOD, "XML");

		// Transformation
		transformer.transform(source, resultat);
	}
}