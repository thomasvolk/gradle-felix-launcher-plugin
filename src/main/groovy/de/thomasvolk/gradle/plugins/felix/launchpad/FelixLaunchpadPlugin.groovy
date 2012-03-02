package de.thomasvolk.gradle.plugins.felix.launchpad

import de.thomasvolk.gradle.plugins.felix.launchpad.tasks.LaunchpadTask
import de.thomasvolk.gradle.plugins.felix.launchpad.tasks.RunFelixTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin

class FelixLaunchpadPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.plugins.apply(JavaPlugin.class)
    	project.extensions.felixLaunchpad = new FelixLaunchpadPluginExtension()
    	project.repositories {
           mavenLocal()
           mavenCentral()
        }
        project.configurations {
          felix
          felixMain
        }
    	project.dependencies {      
          felixMain project.extensions.felixLaunchpad.mainArtifact
        }
        project.task('launchpad', type: LaunchpadTask)
        project.launchpad.dependsOn { 
          project.build
          project.subprojects.build
        }
        project.task('runFelix', type: RunFelixTask, dependsOn: ':launchpad')
    }
}

