case class Boo(n:Int) {
  def hello() = {
    println("hello from Boo n = %s".format(n))
  }

}



object Boo {
  def main(args: Array[String]) = {
    args.zipWithIndex.foreach{ case(arg, index) => println("Boo arg %s = %s".format(index, arg)) }
    Boo(259).hello
  }


}


