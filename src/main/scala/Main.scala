package com.beartronics.sschema

object SchemaApp extends App {
  args.zipWithIndex.foreach{ case(arg, index) => println("arg %s = %s".format(index, arg)) }
  SchemaApp().hello
}

case class Person(var name: String)

case class SchemaApp(n:Int = 10) {
  def hello() = {
    println("Starting SchemaApp n = %s".format(n))

    val stage = Stage(1,"Initial Stage") 
    stage.initialize(nschemas = 10, nitems = 10)
    
  }

}
