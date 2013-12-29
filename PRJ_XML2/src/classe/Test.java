package classe;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ConvertICS ics = new ConvertICS("C:/Users/Simo/workspace/PRJ_XML/calendar.ics");
		//ics.convertFile();
		System.out.println("je suis la");
		XMLtoXML xml = new XMLtoXML();
		try {
			xml.creerXML("C:/Users/Simo/workspace/PRJ_XML/fichier.xml", "C:/Users/Simo/workspace/PRJ_XML/TransformXML.xsl", "C:/Users/Simo/workspace/PRJ_XML/CalendarDet.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
