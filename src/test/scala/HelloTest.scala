package com.beartronics.sschema

import org.scalatest.FunSuite
 
class HelloSuite extends FunSuite {
 
  test("the name is set correctly in constructor") {
    val stage = Stage(1,"Stage A") 
    assert(stage.name == "Stage A")
  }
 
  test("create schemas ") {
    val stage = Stage(2,"Stage B") 
    stage.initialize(nschemas = 10, nitems = 10)
  }

  test("add new schema ") {
    val stage = Stage(2,"Stage B") 
    stage.initialize(nschemas = 10, nitems = 10)
    val n = stage.addNewSchema()
    assert(n == 10)
    val n2 = stage.addNewSchema()
    assert(n2 == 11)
    assert(stage.schemas(0).xc_posTransitionWithAction.size == 12)

  }

}

