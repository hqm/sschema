package com.beartronics.sschema

import org.scalatest.FunSuite
 
class HelloSuite extends FunSuite {
 
  test("the name is set correctly in constructor") {
    val stage = Stage(1,"Stage A") 
    assert(stage.name == "Stage A")
  }
 
  test("add schemas ") {
    val stage = Stage(2,"Stage B") 
    stage.initialize(nschemas = 10, nactions = 10, nitems = 10)
  }
}

