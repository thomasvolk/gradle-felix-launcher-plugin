package de.thomasvolk.felix.helloservlet

import org.osgi.framework.{BundleActivator, BundleContext}

class Activator extends BundleActivator {

  def start(ctx: BundleContext) {
    println(this.getClass.getName + ": start")
    println(this.getClass.getName + ": call http://localhost:8080 to start the servlet")
    println(this.getClass.getName + ": call http://localhost:8080/system/console to start the felix web console")
  }

  def stop(ctx: BundleContext) {
    println(this.getClass.getName + ": stop")
  }
}