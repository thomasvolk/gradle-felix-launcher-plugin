package de.thomasvolk.felix.helloservlet

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import de.thomasvolk.felix.helloservice.HelloService

class HelloServlet extends HttpServlet {
  var helloService: HelloService = null

  def bindHelloService(service: HelloService): Unit = {
      helloService = service
  }

  def unbindHelloService(service: HelloService): Unit = {
    helloService = null
  }

  override def service(req: HttpServletRequest, resp: HttpServletResponse) {
    if(helloService == null) {
      resp.getWriter.write("ERROR: no service found")
    }
    else {
      resp.getWriter.write("OK: " + helloService.hello())
    }
  }
}