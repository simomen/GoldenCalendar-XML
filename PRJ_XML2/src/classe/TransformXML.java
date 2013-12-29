package classe;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class TransformXML {

	public static String HtmlType = "html";
	public static String XmlType = "xml";

	public static void transform(String xml, String xsl, String out,
			String typeTrans) throws Exception {

		System.out.println("strat HTML");
		System.out.println(xml);
		System.out.println(xsl);
		System.out.println(out);

		// Création de la source DOM
		DocumentBuilderFactory fabriqueD = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructeur = fabriqueD.newDocumentBuilder();
		File fileXml = new File(xml);
		Document document = constructeur.parse(fileXml);
		Source source = new DOMSource(document);

		// Création du fichier de sortie

		File fileHtml = new File(out);
		Result resultat = new StreamResult(fileHtml);

		// Configuration du transformer
		TransformerFactory fabriqueT = TransformerFactory.newInstance();
		StreamSource stylesource = new StreamSource(xsl);
		Transformer transformer = fabriqueT.newTransformer(stylesource);
		transformer.setOutputProperty(OutputKeys.METHOD, typeTrans);

		// Transformation
		transformer.transform(source, resultat);
	}
}