package de.thomasvolk.gradle.felix.launchpad.tasks

import org.gradle.api.tasks.TaskAction
import org.gradle.api.artifacts.Dependency


class LaunchpadTask extends BaseTask {
    final String CONFIG_TEMPLATE = """felix.log.level=1
felix.auto.deploy.action=install,start,update
org.osgi.service.http.port=8080
obr.repository.url=http://felix.apache.org/obr/releases.xml
"""

    def String jar(Dependency dep) {
        return "${dep.name}-${dep.version}.jar"
    }
    
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
        bundles = project.configurations.felix.dependencies.collect { jar(it) }
        felixMain = project.configurations.felixMain.dependencies.collect { jar(it) }
        bundleDir = "$targetDir/bundle"
        project.configurations.felixMain.each {
            if(felixMain.contains(it.name)) {
                ant.copy(file: it.path, tofile: felixMainJar)
            }
        }
        project.configurations.felix.each {
            if(bundles.contains(it.name)) {
                ant.copy(file: it.path, todir: bundleDir)
            }
        }
        confDir = "$targetDir/conf"
        new File(confDir).mkdirs()
        new File("$confDir/config.properties").withWriter { w ->
          w.write(CONFIG_TEMPLATE)
        }
        copySubprojects(project, bundleDir)
    }
}