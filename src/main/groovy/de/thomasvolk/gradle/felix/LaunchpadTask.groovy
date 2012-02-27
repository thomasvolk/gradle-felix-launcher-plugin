package de.thomasvolk.gradle.felix

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.FileWriter
import java.io.File

class LaunchpadTask extends DefaultTask {

    
    def bundleProjects(rootProject) {
        rootProject.subprojects.findAll { project -> project.name != name }
    }	
    
    def copySubprojects(rootProject, target) {
        bundleProjects(rootProject).each { project ->
            ant.copy(file: "${project.name}/build/libs/${project.name}-${project.version}.jar",
                todir: "$target")
        }
    }


    @TaskAction
    def build() {
        println "build launcher"
        bundles = project.configurations.felix.dependencies.collect { new Artifact(it).jar() }
        felixMain = project.configurations.felixMain.dependencies.collect { new Artifact(it).jar() }
        target = "${project.buildDir}/launchpad"
        bundleDir = "$target/bundle"
        project.configurations.felixMain.each {
            if(felixMain.contains(it.name)) {
                ant.copy(file: it.path, todir: "$target/bin")
            }
        }
        project.configurations.felix.each {
            if(bundles.contains(it.name)) {
                ant.copy(file: it.path, todir: bundleDir)
            }
        }
        confDir = "$target/conf"
        new File(confDir).mkdirs()
        new File("$confDir/config.properties").withWriter { w ->
          w.write(Felix.CONFIG_TEMPLATE)
        }
        copySubprojects(project, bundleDir)
    }
}
