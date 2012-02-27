package de.thomasvolk.gradle.felix

import org.gradle.api.tasks.TaskAction

class RunFelixTask extends BaseFelixTask {

    @TaskAction
    def run() {
        logfile = "$targetDir/felix.log"
        ant.echo("start felix ...")
        ant.echo("write output to: $logfile")
        ant.java(jar: felixMainJar, fork: true, dir: targetDir, output: logfile)
    }
}
