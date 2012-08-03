package de.thomasvolk.felix.helloservlet;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

  public void start(BundleContext ctx) {
    System.out.println(getClass().getName() + ": start");
    System.out.println(getClass().getName() + ": call http://localhost:8080 to start the servlet");
    System.out.println(getClass().getName() + ": call http://localhost:8080/system/console to start the felix web console");
  }

  public void stop(BundleContext ctx) {
    System.out.println(getClass().getName() + ": stop");
  }
}
