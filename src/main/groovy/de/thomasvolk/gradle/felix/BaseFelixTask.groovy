package de.thomasvolk.gradle.felix

import org.gradle.api.DefaultTask

class BaseFelixTask extends DefaultTask {

    def String getTargetDir() {
        return "${project.buildDir}/launchpad"
    }

    def String getFelixMainJar() {
        return "$targetDir/bin/felix.jar"
    }
}
