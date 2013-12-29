<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format"
			xmlns:fox="http://xml.apache.org/fop/extensions">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="all"
					page-height="29.7cm" page-width="21cm" margin-top="1cm"
					margin-bottom="1cm" margin-left="1.5cm" margin-right="1.5cm"
					font-family="Palatino Linotype">
					<fo:region-body margin-top="2cm" margin-bottom="2cm" />
					<fo:region-before extent="0cm" />
					<fo:region-after extent="0cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>

			<fo:page-sequence master-reference="all"
				font-family="Palatino Linotype">
				<fo:static-content flow-name="xsl-region-before">
					<xsl:call-template name="entete" />
				</fo:static-content>
				<fo:static-content flow-name="xsl-region-after">
					<xsl:call-template name="basDePage" />
				</fo:static-content>
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<xsl:call-template name="miseEnPage" />
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template name="entete">
		<fo:block text-align="center" font-size="8pt" line-height="10pt"
			border-bottom="#D1D7DC" border-bottom-style="solid"
			border-bottom-width="1pt" padding-top="2pt" padding-right="2pt"
			padding-left="2pt" padding-bottom="2pt">
			Projet XML-GoldenCalendar
		</fo:block>
	</xsl:template>

	<xsl:template name="miseEnPage">
		<xsl:apply-templates select="calendar" />
	</xsl:template>

	<xsl:template match="calendar">
		<fo:block>
			Golden Calendar
		</fo:block>
		<fo:block>
			Le fichier ICS a été téléchargé le
			<xsl:value-of select="event/dtStamp/annee" />
			/
			<xsl:value-of select="event/dtStamp/mois" />
			/
			<xsl:value-of select="event/dtStamp/jour" />
			à
			<xsl:value-of select="event/dtStamp/heure" />
			:
			<xsl:value-of select="event/dtStamp/minute" />
			:
			<xsl:value-of select="event/dtStamp/seconde" />
			, et il contient
			<xsl:value-of select="count(event)" />
			evenements dans le calendrier.
		</fo:block>
		<fo:block>
			<fo:table table-layout="fixed" width="100%" height="100%"
				font-size="8pt" font-family="Palatino Linotype">
				<fo:table-column column-width="10%" margin-left="5%"
					margin-right="5%" />
				<fo:table-column column-width="10%" margin-left="5%"
					margin-right="5%" />
				<fo:table-column column-width="30%" margin-left="5%"
					margin-right="5%" />
				<fo:table-column column-width="15%" margin-left="5%"
					margin-right="5%" />
				<fo:table-column column-width="25%" margin-left="5%"
					margin-right="5%" />

				<fo:table-header>
					<fo:table-row font-weight="bold" text-align="center"
						vertical-align="middle" background-color="#a7d3ff" margin-right="20%"
						margin-left="20%">
						<fo:table-cell border="black" border-style="solid"
							border-width="1pt">
							<fo:block>Date debut</fo:block>
						</fo:table-cell>
						<fo:table-cell border="black" border-style="solid"
							border-width="1pt">
							<fo:block>Date fin</fo:block>
						</fo:table-cell>
						<fo:table-cell border="black" border-style="solid"
							border-width="1pt">
							<fo:block>Summary</fo:block>
						</fo:table-cell>
						<fo:table-cell border="black" border-style="solid"
							border-width="1pt">
							<fo:block>Location</fo:block>
						</fo:table-cell>
						<fo:table-cell border="black" border-style="solid"
							border-width="1pt">
							<fo:block>Description</fo:block>
						</fo:table-cell>

					</fo:table-row>
				</fo:table-header>
				<fo:table-body>
					<xsl:apply-templates select="event" />
				</fo:table-body>
			</fo:table>
		</fo:block>
	</xsl:template>

	<xsl:template match="event">
		<fo:table-row>

			<fo:table-cell border="black" border-style="solid"
				border-width="1pt" margin-left="2mm" margin-right="2mm">
				<fo:block>
					<xsl:value-of select="dtStart/annee" />
					/
					<xsl:value-of select="dtStart/mois" />
					/
					<xsl:value-of select="dtStart/jour" />
					à
					<xsl:value-of select="dtStart/heure" />
					:
					<xsl:value-of select="dtStart/minute" />
					:
					<xsl:value-of select="dtStart/seconde" />

				</fo:block>
			</fo:table-cell>
			<fo:table-cell border="black" border-style="solid"
				border-width="1pt" margin-left="2mm" margin-right="2mm">
				<fo:block>
					<xsl:value-of select="dtEnd/annee" />
					/
					<xsl:value-of select="dtEnd/mois" />
					/
					<xsl:value-of select="dtEnd/jour" />
					à
					<xsl:value-of select="dtEnd/heure" />
					:
					<xsl:value-of select="dtEnd/minute" />
					:
					<xsl:value-of select="dtEnd/seconde" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell border="black" border-style="solid"
				border-width="1pt" margin-left="2mm" margin-right="2mm">
				<fo:block>
					<xsl:value-of select="summary" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell border="black" border-style="solid"
				border-width="1pt" margin-left="2mm" margin-right="2mm">
				<fo:block>
					<xsl:value-of select="location" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell border="black" border-style="solid"
				border-width="1pt" margin-left="2mm" margin-right="2mm">
				<fo:block>
					<xsl:value-of select="description" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>

	<xsl:template name="basDePage">
		<fo:block text-align="center" font-size="8pt" line-height="10pt"
			border-top="#D1D7DC" border-top-style="solid" border-top-width="1pt"
			padding-top="2pt" padding-right="2pt" padding-left="2pt"
			padding-bottom="2pt">
			<fo:block>
				Page N°
				<fo:page-number />
			</fo:block>
		</fo:block>
	</xsl:template>
</xsl:stylesheet>