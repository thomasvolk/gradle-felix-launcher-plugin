package de.thomasvolk.felix.helloservlet

import org.osgi.framework.{BundleActivator, BundleContext}

class Activator extends BundleActivator {

  def start(ctx: BundleContext) {
    println(this.getClass.getName + ": start")
  }

  def stop(ctx: BundleContext) {
    println(this.getClass.getName + ": stop")
  }
}