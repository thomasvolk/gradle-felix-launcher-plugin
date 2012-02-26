package de.thomasvolk.felix.hello;

import org.osgi.framework.*;

public class Activator implements BundleActivator {

  public void start(BundleContext ctx) {
    System.out.println(this.getClass().getName() + ": start");
  }

  public void stop(BundleContext ctx) {
    System.out.println(this.getClass().getName() + ": stop");
  }
}
