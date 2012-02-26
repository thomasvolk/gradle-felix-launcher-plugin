package de.thomasvolk.gradle.felix

import org.gradle.api.Project
import org.gradle.api.Plugin

class FelixLauncherPlugin implements Plugin<Project> {
    void apply(Project project) {
    	project.extensions.felix = new FelixPluginExtension()
    	project.repositories {
           mavenLocal()
           mavenCentral()
        }
        project.configurations {
          felix
          felixMain
        }
    	project.dependencies {      
          felixMain 'org.apache.felix:org.apache.felix.main:4.0.2'
        }
        project.task('launchpad', type: LauncherTask)
        project.launchpad.dependsOn { project.build }
    }
}

