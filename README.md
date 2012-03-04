Gradle Felix Launcher Plugin
============================

This is the Felix Launcher Plugin for the Gradle build system. This Plugin enables
the creation of a apache felix framework installation to ready run a osgi bundle 
application.

Features
--------

Features of the Felix Launcher Plugin:

* Download of the requiered apache felix framework bundles

* Configuration, assembly and execution of the felix framework

* Compiling and including of custom bundles into the felix framework

Usage
-----

### Tasks ###

 * launchpad: builds the apache felix framework 
 * runFelix: runs the felix framework

The felix framework will be created in the following directory:

	build/launchpad

### Dependency configuration ###

This plugin defines a new dependency configuration named "felix". 
Artifacts defined with this dependency configuration will be downloaded and
added to the felix bundle directory.

This feature makes ist possible to configure the bundle composition of the
felix framework. This configuration assembles a felix framework with 
scr and log as additional bundles:

	dependencies {
	  felix 'org.apache.felix:org.apache.felix.scr:1.6.0'
	  felix 'org.apache.felix:org.apache.felix.log:1.0.1'
	}

### Apply the plugin ###

The plugin has the name "felix-launchpad":

	apply plugin: 'felix-launchpad'

### Install the Plugin ###

You can download the plugin and install ist to your local maven repository:

	$>gradle install

To apply the plugin you have to add the plugindependenciy in your project buildfile:

	buildscript {
	    repositories {
	        mavenLocal()
	    }
	    dependencies {
	        classpath group: 'de.thomasvolk.gradle', name: 'felixLaunchpad', version: '1.0-SNAPSHOT'
	    }
	}



Examples
--------

This is a buildscript for an minimal empty felix installation with the gogo shell
extension.

	buildscript {
	    repositories {
	        mavenLocal()
	    }
	    dependencies {
	        classpath group: 'de.thomasvolk.gradle', name: 'felixLaunchpad', version: '1.0-SNAPSHOT'
	    }
	}

	apply plugin: 'felix-launchpad'

	dependencies {
	  //gogo shell extensions
	  felix 'org.apache.felix:org.apache.felix.gogo.command:0.12.0'
	  felix 'org.apache.felix:org.apache.felix.gogo.runtime:0.10.0'
	  felix 'org.apache.felix:org.apache.felix.gogo.shell:0.10.0'
	}

For more examples see the gradle-felix-launchpad-plugin source code directory:

	/integTest/resources/felixProjects/
