package de.thomasvolk.felix.helloservice

class HelloServiceImpl extends HelloService {
  def hello(): String = {
    "Hello world!!!"
  }
}