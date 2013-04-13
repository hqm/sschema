package com.beartronics.sschema

object Hello extends App {
  val p = Person("Henry Minsky")
  println("Hello from " + p.name)

  args.zipWithIndex.foreach{ case(arg, index) => println("Boo arg %s = %s".format(index, arg)) }
  Boo(259).hello
}

case class Person(var name: String)

case class Boo(n:Int) {
  def hello() = {
    println("Hello from Boo n = %s".format(n))
  }

}
