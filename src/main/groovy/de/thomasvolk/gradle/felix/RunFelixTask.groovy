package de.thomasvolk.gradle.felix

import org.gradle.api.tasks.TaskAction

class RunFelixTask extends BaseFelixTask {

    @TaskAction
    def run() {
        ant.java(jar: felixMainJar, fork: true, dir: targetDir)
    }
}
