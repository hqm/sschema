package com.beartronics.sschema

object SchemaApp extends App {
  args.zipWithIndex.foreach{ case(arg, index) => println("arg %s = %s".format(index, arg)) }
  SchemaApp().hello
}

case class Person(var name: String)

case class SchemaApp(n:Int = 10) {
  def hello() = {
    println("Hello from SchemaApp n = %s".format(n))
  }

}
