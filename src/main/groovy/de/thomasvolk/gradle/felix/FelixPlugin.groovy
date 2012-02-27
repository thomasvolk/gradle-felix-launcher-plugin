package de.thomasvolk.gradle.felix

import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.api.plugins.JavaPlugin

class FelixPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.plugins.apply(JavaPlugin.class)
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
        project.task('launchpad', type: LaunchpadTask)
        project.launchpad.dependsOn { 
          project.build
          project.subprojects.build
        }
        project.task('runFelix', type: RunFelixTask, dependsOn: ':launchpad')
    }
}

