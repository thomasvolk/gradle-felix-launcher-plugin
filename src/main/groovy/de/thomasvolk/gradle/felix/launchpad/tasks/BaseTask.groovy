package de.thomasvolk.gradle.felix.launchpad.tasks

import org.gradle.api.DefaultTask

class BaseTask extends DefaultTask {

    def String getTargetDir() {
        return "${project.buildDir}/launchpad"
    }

    def String getFelixMainJar() {
        return "$targetDir/bin/felix.jar"
    }
}
