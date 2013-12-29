<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" indent="yes" />

	<xsl:template match="/calendar">

		<calendar>

			<xsl:for-each select="event">
				<event>
					<dtStart>
						<jour>
							<xsl:value-of select="dtStart/jour" />
						</jour>
						<mois>
							<xsl:value-of select="dtStart/mois" />
						</mois>
						<annee>
							<xsl:value-of select="dtStart/annee" />
						</annee>
						<heure>
							<xsl:value-of select="dtStart/heure" />
						</heure>
						<minute>
							<xsl:value-of select="dtStart/minute" />
						</minute>

					</dtStart>

					<dtEnd>
						<jour>
							<xsl:value-of select="dtEnd/jour" />
						</jour>
						<mois>
							<xsl:value-of select="dtEnd/mois" />
						</mois>
						<annee>
							<xsl:value-of select="dtEnd/annee" />
						</annee>
						<heure>
							<xsl:value-of select="dtEnd/heure" />
						</heure>
						<minute>
							<xsl:value-of select="dtEnd/minute" />
						</minute>
					</dtEnd>

					<summary>
						<xsl:value-of select="summary" />
					</summary>

					<location>
						<xsl:value-of select="location" />
					</location>

					<description>
						<xsl:for-each select="description/sousDescription">
							<sousDescription>
								<xsl:value-of select="/description/sousDescription" />
							</sousDescription>
						</xsl:for-each>
					</description>
				</event>
			</xsl:for-each>
		</calendar>
	</xsl:template>

</xsl:stylesheet>