<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


	<xsl:template match="/calendar">
		<calendar>
			<xsl:for-each select="event">
				<event>
					<dtStart>
						<xsl:value-of select="dtStart" />
					</dtStart>

				</event>
			</xsl:for-each>
		</calendar>
	</xsl:template>
</xsl:stylesheet>