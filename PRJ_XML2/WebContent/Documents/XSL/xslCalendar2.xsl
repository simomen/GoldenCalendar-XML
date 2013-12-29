<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="no" encoding="ISO-8859-1"/>
	<xsl:template match="/">
		<xsl:apply-templates select="calendar"/>	
	</xsl:template>
	
		
	<xsl:template match="calendar">
		<html>
			<head>
			<style type="text/css">

			body {
			    width: 600px;
			    margin: 40px auto;
			    font-family: 'trebuchet MS', 'Lucida sans', Arial;
			    font-size: 14px;
			    color: #FFFFFF;
			}
			
			table {
			    *border-collapse: collapse; /* IE7 and lower */
			    border-spacing: 0;
			    width: 100%;    
			}
			
			.bordered {
			    border: solid #ccc 1px;
			    -moz-border-radius: 6px;
			    -webkit-border-radius: 6px;
			    border-radius: 6px;
			    -webkit-box-shadow: 0 1px 1px #ccc; 
			    -moz-box-shadow: 0 1px 1px #ccc; 
			    box-shadow: 0 1px 1px #ccc;         
			}
			
			.bordered thead {
				color: #444;
			}
			.bordered tr:hover {
			    background: #fbf8e9;
			    -o-transition: all 0.1s ease-in-out;
			    -webkit-transition: all 0.1s ease-in-out;
			    -moz-transition: all 0.1s ease-in-out;
			    -ms-transition: all 0.1s ease-in-out;
			    transition: all 0.1s ease-in-out;     
			}    
			    
			.bordered td, .bordered th {
			    border-left: 1px solid #ccc;
			    border-top: 1px solid #ccc;
			    padding: 10px;
			    text-align: left;    
			}
			
			.bordered th {
			    background-color: #dce9f9;
			    background-image: -webkit-gradient(linear, left top, left bottom, from(#ebf3fc), to(#dce9f9));
			    background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9);
			    background-image:    -moz-linear-gradient(top, #ebf3fc, #dce9f9);
			    background-image:     -ms-linear-gradient(top, #ebf3fc, #dce9f9);
			    background-image:      -o-linear-gradient(top, #ebf3fc, #dce9f9);
			    background-image:         linear-gradient(top, #ebf3fc, #dce9f9);
			    -webkit-box-shadow: 0 1px 0 rgba(255,255,255,.8) inset; 
			    -moz-box-shadow:0 1px 0 rgba(255,255,255,.8) inset;  
			    box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;        
			    border-top: none;
			    text-shadow: 0 1px 0 rgba(255,255,255,.5); 
			}
			
			.bordered td:first-child, .bordered th:first-child {
			    border-left: none;
			}
			
			.bordered th:first-child {
			    -moz-border-radius: 6px 0 0 0;
			    -webkit-border-radius: 6px 0 0 0;
			    border-radius: 6px 0 0 0;
			}
			
			.bordered th:last-child {
			    -moz-border-radius: 0 6px 0 0;
			    -webkit-border-radius: 0 6px 0 0;
			    border-radius: 0 6px 0 0;
			}
			
			.bordered th:only-child{
			    -moz-border-radius: 6px 6px 0 0;
			    -webkit-border-radius: 6px 6px 0 0;
			    border-radius: 6px 6px 0 0;
			}
			
			.bordered tr:last-child td:first-child {
			    -moz-border-radius: 0 0 0 6px;
			    -webkit-border-radius: 0 0 0 6px;
			    border-radius: 0 0 0 6px;
			}
			
			.bordered tr:last-child td:last-child {
			    -moz-border-radius: 0 0 6px 0;
			    -webkit-border-radius: 0 0 6px 0;
			    border-radius: 0 0 6px 0;
			}
			
			
			
			/*----------------------*/
			
			.zebra td, .zebra th {
			    padding: 10px;
			    border-bottom: 1px solid #f2f2f2;    
			}
			
			.zebra tbody tr:nth-child(even) {
			    background: #f5f5f5;
			    -webkit-box-shadow: 0 1px 0 rgba(255,255,255,.8) inset; 
			    -moz-box-shadow:0 1px 0 rgba(255,255,255,.8) inset;  
			    box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;        
			}
			
			.zebra th {
			    text-align: left;
			    text-shadow: 0 1px 0 rgba(255,255,255,.5); 
			    border-bottom: 1px solid #ccc;
			    background-color: #eee;
			    background-image: -webkit-gradient(linear, left top, left bottom, from(#f5f5f5), to(#eee));
			    background-image: -webkit-linear-gradient(top, #f5f5f5, #eee);
			    background-image:    -moz-linear-gradient(top, #f5f5f5, #eee);
			    background-image:     -ms-linear-gradient(top, #f5f5f5, #eee);
			    background-image:      -o-linear-gradient(top, #f5f5f5, #eee); 
			    background-image:         linear-gradient(top, #f5f5f5, #eee);
			}
			
			.zebra th:first-child {
			    -moz-border-radius: 6px 0 0 0;
			    -webkit-border-radius: 6px 0 0 0;
			    border-radius: 6px 0 0 0;  
			}
			
			.zebra th:last-child {
			    -moz-border-radius: 0 6px 0 0;
			    -webkit-border-radius: 0 6px 0 0;
			    border-radius: 0 6px 0 0;
			}
			
			.zebra th:only-child{
			    -moz-border-radius: 6px 6px 0 0;
			    -webkit-border-radius: 6px 6px 0 0;
			    border-radius: 6px 6px 0 0;
			}
			
			.zebra tfoot td {
			    border-bottom: 0;
			    border-top: 1px solid #fff;
			    background-color: #f1f1f1;  
			}
			
			.zebra tfoot td:first-child {
			    -moz-border-radius: 0 0 0 6px;
			    -webkit-border-radius: 0 0 0 6px;
			    border-radius: 0 0 0 6px;
			}
			
			.zebra tfoot td:last-child {
			    -moz-border-radius: 0 0 6px 0;
			    -webkit-border-radius: 0 0 6px 0;
			    border-radius: 0 0 6px 0;
			}
			
			.zebra tfoot td:only-child{
			    -moz-border-radius: 0 0 6px 6px;
			    -webkit-border-radius: 0 0 6px 6px
			    border-radius: 0 0 6px 6px
			}
  
</style>
				<title>Calendar</title>
			</head>
			<body>
				<h1>Calendar</h1>
				
				Date de Telechargement du fichier brute "ICS". <br/><br/><br/>
				
				<xsl:value-of select="count(event)"/> Events in this file.<br/><br/><br/>
								
				<xsl:value-of select="event/dtStamp/jour"/>/<xsl:value-of select="event/dtStamp/mois"/>/<xsl:value-of select="event/dtStamp/annee"/> à
	  			<xsl:value-of select="event/dtStamp/heure"/>:<xsl:value-of select="event/dtStamp/minute"/>:<xsl:value-of select="event/dtStamp/seconde"/>
	  				
				<table class="bordered">
					<thead>
						<tr>
							
							<th>Date Start</th>
							<th>Date End</th>
							<th>Summary</th>
							<th>Location</th>
							<th>Description</th>
						</tr>
					</thead>
					<xsl:apply-templates select="event"/>
				</table>
			</body>
		</html>
	</xsl:template>
	
  	<xsl:template match="event">
  		<tbody>
  		<tr>
	  		<td>
	  			<xsl:value-of select="dtStart/jour"/>/<xsl:value-of select="dtStart/mois"/>/<xsl:value-of select="dtStart/annee"/> à
	  			<xsl:value-of select="dtStart/heure"/>:<xsl:value-of select="dtStart/minute"/>:<xsl:value-of select="dtStart/seconde" /> 
	  		</td>
	  		<td>
	  			<xsl:value-of select="dtEnd/jour"/>/<xsl:value-of select="dtEnd/mois"/>/<xsl:value-of select="dtEnd/annee"/> à
	  			<xsl:value-of select="dtEnd/heure"/>:<xsl:value-of select="dtEnd/minute"/>:<xsl:value-of select="dtEnd/seconde" />
	  		</td>
	  		<td>
	  			<xsl:value-of select="summary"/>
	  		</td>
	  		<td>
	  			<xsl:value-of select="location"/>
	  		</td>
	  		<td>
	  			<xsl:value-of select="description"/>
	  		</td>
		</tr>
		</tbody>
  	</xsl:template>
  	
  
  	
</xsl:stylesheet>