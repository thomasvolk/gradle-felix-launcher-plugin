package de.thomasvolk.gradle.felix

import org.gradle.api.artifacts.Dependency

class Artifact {
    String group
    String name
    String version

    Artifact(Dependency dep) {
        name = dep.name
        group = dep.group
        version = dep.version
    }
    String toString() {
       return "$group:$name:$version"
    }
    String jar() {
       return "${name}-${version}.jar"
    }
}
