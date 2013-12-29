package classe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ConvertICS {

	private String cheminDoc;
	private String cheminICS;
	private String cheminXML;

	public ConvertICS(String cheminDoc) {
		super();
		cheminICS = cheminDoc + "ICS_Calendrier.ics";
		cheminXML = cheminDoc + "XML_Calendrier_brute.xml";
	}

	public String convertFile() {

		System.out.println(cheminICS);

		FileReader file1 = null;

		try {
			Thread.currentThread();
			Thread.sleep(10);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			cheminXML = null;

		}

		try {

			file1 = new FileReader(cheminICS);
			FileWriter file2 = new FileWriter(cheminXML);

			System.out.println("ConvertICS" + cheminXML);

			BufferedReader reader = new BufferedReader(file1);
			while (reader.ready()) {

				String[] line = reader.readLine().split("\n");
				for (String s : line) {

					if (s.equals("BEGIN:VCALENDAR")) {
						file2.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
						file2.write("<!DOCTYPE calendar SYSTEM \"DTD_brute.dtd\">\n");

						// file2.write("<!DOCTYPE calendar  PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
						file2.write("<calendar>\n");
					}

					if (s.charAt(0) == 'M') {
						file2.write("\t<method>" + s.substring(7)
								+ "</method>\n");

					}

					if (s.charAt(0) == 'P') {
						file2.write("\t<prodid>" + s.substring(7)
								+ "</prodid>\n");
					}

					if (s.charAt(0) == 'V') {
						file2.write("\t<version>" + s.substring(8)
								+ "</version>\n");
					}

					if (s.charAt(0) == 'C' && s.charAt(1) == 'A') {

						file2.write("\t<calscale>" + s.substring(9)
								+ "</calscale>\n");
					}

					if (s.equals("BEGIN:VEVENT")) {
						file2.write("\t<event>\n");
					}

					if (s.charAt(0) == 'D' && s.charAt(5) == 'M') {
						file2.write("\t<dtStamp>\n");
						file2.write("\t\t<annee>" + s.substring(8, 12)
								+ "</annee>\n");
						file2.write("\t\t<mois>" + s.substring(12, 14)
								+ "</mois>\n");
						file2.write("\t\t<jour>" + s.substring(14, 16)
								+ "</jour>\n");
						file2.write("\t\t<heure>" + s.substring(17, 19)
								+ "</heure>\n");
						file2.write("\t\t<minute>" + s.substring(19, 21)
								+ "</minute>\n");
						file2.write("\t\t<seconde>" + s.substring(21, 23)
								+ "</seconde>\n");
						file2.write("\t</dtStamp>\n");
					}

					if (s.charAt(0) == 'D' && s.charAt(5) == 'R') {
						file2.write("\t<dtStart>\n");
						file2.write("\t\t<annee>" + s.substring(8, 12)
								+ "</annee>\n");
						file2.write("\t\t<mois>" + s.substring(12, 14)
								+ "</mois>\n");
						file2.write("\t\t<jour>" + s.substring(14, 16)
								+ "</jour>\n");
						file2.write("\t\t<heure>" + s.substring(17, 19)
								+ "</heure>\n");
						file2.write("\t\t<minute>" + s.substring(19, 21)
								+ "</minute>\n");
						file2.write("\t\t<seconde>" + s.substring(21, 23)
								+ "</seconde>\n");
						file2.write("\t</dtStart>\n");

					}

					if (s.charAt(0) == 'D' && s.charAt(2) == 'E') {
						file2.write("\t<dtEnd>\n");
						file2.write("\t\t<annee>" + s.substring(6, 10)
								+ "</annee>\n");
						file2.write("\t\t<mois>" + s.substring(10, 12)
								+ "</mois>\n");
						file2.write("\t\t<jour>" + s.substring(12, 14)
								+ "</jour>\n");
						file2.write("\t\t<heure>" + s.substring(15, 17)
								+ "</heure>\n");
						file2.write("\t\t<minute>" + s.substring(17, 19)
								+ "</minute>\n");
						file2.write("\t\t<seconde>" + s.substring(19, 21)
								+ "</seconde>\n");
						file2.write("\t</dtEnd>\n");
					}

					if (s.charAt(0) == 'S' && s.charAt(1) == 'U') {
						file2.write("\t<summary>");
						for (int i = 8; i < s.length(); i++) {
							if (s.charAt(i) == '&')
								file2.write(" and ");
							else
								file2.write(s.charAt(i));
						}
						file2.write("</summary>\n");

					}

					if (s.charAt(0) == 'S' && s.charAt(1) == 'E') {
						file2.write("\t<sequence>" + s.substring(9)
								+ "</sequence>\n");
					}

					if (s.charAt(0) == 'L' && s.charAt(1) == 'O') {
						file2.write("\t<location>" + s.substring(9)
								+ "</location>\n");
					}

					if (s.charAt(0) == 'L' && s.charAt(1) == 'A') {

						file2.write("\t<lastModified>\n");
						file2.write("\t\t<annee>" + s.substring(14, 18)
								+ "</annee>\n");
						file2.write("\t\t<mois>" + s.substring(18, 20)
								+ "</mois>\n");
						file2.write("\t\t<jour>" + s.substring(20, 22)
								+ "</jour>\n");
						file2.write("\t\t<heure>" + s.substring(23, 25)
								+ "</heure>\n");
						file2.write("\t\t<minute>" + s.substring(25, 27)
								+ "</minute>\n");
						file2.write("\t\t<seconde>" + s.substring(27, 29)
								+ "</seconde>\n");
						file2.write("\t</lastModified>\n");

					}

					if (s.charAt(0) == 'D' && s.charAt(1) == 'E') {
						file2.write("\t<description>\n");

						for (int i = 12; i < s.length(); i++) {
							if (s.charAt(i) == '\\' && s.charAt(i + 2) == '(') {
								file2.write("</sousDescription>\n");
								break;
							}
							if (s.charAt(i) == '\\' && i == 12) {
								file2.write("\t\t<sousDescription>");
								i += 2;
							}
							if (s.charAt(i) != '\\') {
								file2.write("" + s.charAt(i));
							} else {
								file2.write("</sousDescription>\n");
								i++;
								file2.write("\t\t<sousDescription>");
							}
						}

						file2.write("\t</description>\n");

					}

					if (s.charAt(0) == 'U') {
						file2.write("\t<uid>" + s.substring(4) + "</uid>\n");
					}

					if (s.charAt(0) == 'C' && s.charAt(1) == 'R') {
						file2.write("\t<creation>" + s.substring(9)
								+ "</creation>\n");
					}

					if (s.equals("END:VEVENT")) {
						file2.write("\t</event>\n");
					}

					if (s.equals("END:VCALENDAR")) {
						file2.write("</calendar>\n");

					}
				}

			}
			reader.close();
			file1.close();
			file2.close();

		} catch (FileNotFoundException fnfe) {
			System.out.print("Erreur : le fichier n'exsite pas - "
					+ fnfe.getLocalizedMessage());
			cheminXML = null;

		} catch (IOException e) {
			System.out.print("Erreur : le fichier n'est pas lu");
			cheminXML = null;
		}
		return cheminXML;

	}
}
