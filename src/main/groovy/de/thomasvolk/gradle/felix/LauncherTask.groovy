package de.thomasvolk.gradle.felix

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.FileWriter
import java.io.File

class LauncherTask extends DefaultTask {	

    @TaskAction
    def build() {
        println "build launcher"
        deps = project.configurations.felix.dependencies.collect { new Artifact(it).jar() }
        
        target = "${project.buildDir}/launchpad"
        bundleDir = "$target/bundle"
        project.configurations.felixMain.each {
           ant.copy(file: it.path, todir: "$target/bin")
        }
        project.configurations.felix.each {
            if(deps.contains(it.name)) {
                ant.copy(file: it.path, todir: bundleDir)
            }
        }
        confDir = "$target/conf"
        new File(confDir).mkdirs()
        new File("$confDir/config.properties").withWriter { w ->
          w.write(Felix.CONFIG_TEMPLATE)
        }
        
        
        
    }
}
