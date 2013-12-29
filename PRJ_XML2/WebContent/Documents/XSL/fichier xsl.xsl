<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE calendar SYSTEM "fichier.dtd">
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="utf-8"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN" />
	<!--modifiez method="html" en method="xml" pour obtenir en sortie un document 
		xml -->
	<xsl:template match="calendar">
		<html xmlns:xsl="http://www.w3.org/TR/WD-xsl">
			<body>
				<h2>My Answer XPath</h2>

				<table border="1">
					<tr bgcolor="green">
						<th>Title</th>
						<th>Contenu</th>
					</tr>

					<xsl:for-each select="//event/description">
						<tr>
							<td>date début</td>
							<td>
								<xsl:value-of select="//dtStart/annee" />
								-
								<xsl:value-of select="//dtStart/ mois" />
								-
								<xsl:value-of select="//dtStart/jour" />
								/
								<xsl:value-of select="//dtStart/heure" />
								:
								<xsl:value-of select="//dtStart/minute" />
							</td>
						</tr>
						<tr>
							<td>date fin</td>
							<td>
								<xsl:value-of select="//dtEnd/annee" />
								-
								<xsl:value-of select="//dtEnd/ mois" />
								-
								<xsl:value-of select="//dtEnd/jour" />
								/
								<xsl:value-of select="//dtEnd/heure" />
								:
								<xsl:value-of select="//dtEnd/minute" />
							</td>
						</tr>
						<tr>
							<td>Summary</td>
							<td>
								<xsl:value-of select="//summary" />
							</td>
						</tr>
						<tr>
							<td>Location</td>
							<td>
								<xsl:value-of select="//location" />
							</td>
						</tr>

						<tr>
							<td>sousDescription</td>
							<td>
								<xsl:value-of select="self::*" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>