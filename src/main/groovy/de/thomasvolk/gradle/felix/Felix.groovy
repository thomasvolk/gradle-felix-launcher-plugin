package de.thomasvolk.gradle.felix

class Felix {
   static CONFIG_TEMPLATE = """felix.log.level=1
felix.auto.deploy.action=install,start,update
org.osgi.service.http.port=8080
obr.repository.url=http://felix.apache.org/obr/releases.xml
"""
   
}
