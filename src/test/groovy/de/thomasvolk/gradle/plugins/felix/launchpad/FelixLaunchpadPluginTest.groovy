package de.thomasvolk.gradle.plugins.felix.launchpad

import org.junit.Test
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import de.thomasvolk.gradle.plugins.felix.launchpad.tasks.LaunchpadTask
import de.thomasvolk.gradle.plugins.felix.launchpad.tasks.RunFelixTask
import static org.testng.Assert.*

class FelixLaunchpadPluginTest {
    @Test
    public void greeterPluginAddsGreetingTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: 'felix-launchpad'

        assertTrue(project.extensions.felixLaunchpad instanceof FelixLaunchpadPluginExtension)

        assertTrue(project.tasks.launchpad instanceof LaunchpadTask)
        assertTrue(project.tasks.runFelix instanceof RunFelixTask)
    }
}
