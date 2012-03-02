package de.thomasvolk.gradle.felix.launchpad

class FelixLaunchpadPluginExtension {
    int logLevel = 1
    String deployActions = 'install,start,update'
    int httpPort = 8080
    String repositoryUrl = 'http://felix.apache.org/obr/releases.xml'
    String mainArtifact = 'org.apache.felix:org.apache.felix.main:4.0.2'
}
