package de.thomasvolk.gradle.felix.launchpad.tasks

import org.gradle.api.tasks.TaskAction

class RunFelixTask extends BaseTask {

    @TaskAction
    def run() {
        ant.java(jar: felixMainJar, fork: true, dir: targetDir)
    }
}
