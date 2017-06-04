FROM tomcat:latest
COPY config.yml /tmp/config.yml
COPY target/test2gis-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/test2gis.war
