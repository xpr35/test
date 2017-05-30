FROM tomcat:latest
COPY target/test2gis-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/test2gis.war
