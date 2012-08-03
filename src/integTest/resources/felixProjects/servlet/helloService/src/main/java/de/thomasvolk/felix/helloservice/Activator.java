package de.thomasvolk.felix.helloservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

  public void start(BundleContext ctx) {
    System.out.println(getClass().getName() + ": start");
  }

  public void stop(BundleContext ctx) {
    System.out.println(getClass().getName() + ": stop");
  }
}
