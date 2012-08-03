package de.thomasvolk.felix.helloservlet;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import de.thomasvolk.felix.helloservice.HelloService;

public class HelloServlet extends HttpServlet {
  private HelloService helloService;

  protected void bindHelloService(HelloService service) {
    helloService = service;
  }

  protected void unbindHelloService(HelloService service) {
    helloService = null;
  }

  public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    if(helloService == null) {
      resp.getWriter().write("ERROR: no service found");
    }
    else {
      resp.getWriter().write("OK: " + helloService.hello());
    }
  }
}
