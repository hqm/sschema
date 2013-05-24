package com.beartronics.sschema

import scala.collection.mutable.ArrayBuffer

//# ItemType
object ItemType extends Enumeration {
  type ItemType = Value
  val Primitive, Synthetic = Value
}

import ItemType._

case class Action(val id: Int, val name: String, val actionType: ItemType)

case class Item(val id: Int, val name: String, val value: Float, val itemType: ItemType)

case class Stage(val id: Int, val name: String, 
                 val schemas: ArrayBuffer[Schema] = new ArrayBuffer[Schema](),
                 val items: ArrayBuffer[Item] = new ArrayBuffer[Item](),
                 val actions: ArrayBuffer[Action] = new ArrayBuffer[Action]()) {

   def initialize(nschemas:Int = 10, nitems:Int = 10) = {
     for (i <- 0 until nschemas) {
       val action = Action(i, "Action "+i, ItemType.Primitive)
       actions += action
       schemas += new Schema(i, action, nitems)
     }

     for (i <- 0 until nitems) {
       val item = Item(i, "Item "+i, 0.0F, ItemType.Primitive)
       items += item
     }
     println("items = "+items)
   }

}

class Schema(val id: Int, val action: Action, nitems: Int) {
  // Numerical id of this schema

  // The items in this schema's context list
  val posContext: ArrayBuffer[Item] = new ArrayBuffer[Item]()
  val negContext: ArrayBuffer[Item] = new ArrayBuffer[Item]();
  // The items in this schema's result list
  val posResult: ArrayBuffer[Item]  = new ArrayBuffer[Item]();
  val negResult: ArrayBuffer[Item]  = new ArrayBuffer[Item]();
  
  // reliability statistics
  val succeededWithActivation: Int   = 0;
  val failedWithActivation: Int      = 0; // number of times activation failed
  val succededWithoutActivation: Int = 0;
  
  // Parent schema from which we were spun off
  val parent: Option[Schema] = None;
  // List of child schemas which we have spun off
  val children: ArrayBuffer[Schema] = new ArrayBuffer[Schema]();

  val applicable: Boolean = false;
  val value: Float = 0;
    // See pp. 55
    // correlation, reliability, duration, cost

    // Extended Context counters
  val xc_posTransitionWithAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  val xc_posTransitionWithoutAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  
  val xc_negTransitionWithAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  val xc_negTranstitionWithoutAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  
  val xc_remainPosWithAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  val xc_remainPosWithoutAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  
  val xc_remainNegWithAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  val xc_remainNegWithoutAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  
    // Extended Result counters
  val xr_posTransitionWithAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  val xr_posTransitionWithoutAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  
  val xr_negTransitionWithAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  val xr_negTranstitionWithoutAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  
  val xr_remainPosWithAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  val xr_remainPosWithoutAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  
  val xr_remainNegWithAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  val xr_remainNegWithoutAction: ArrayBuffer[Int] = ArrayBuffer.fill[Int](nitems)(0);
  
    // List of schemas who override this schema;
  val overridedBySchemas: ArrayBuffer[Schema] = new ArrayBuffer[Schema]()
  

  // Initialize this schema, for this stage
  def initialize(stage: Stage) = {
  }

  override def toString(): String = {
    "<Schema [%s::~%s]/ action %s/ [%s::~%s]>".format(posContext.mkString(","), negContext.mkString(","), 
                                                  action, 
                                                  posResult.mkString(","), negResult.mkString(","))
  }

}

/*
 import com.beartronics.sschema._
 val stage = Stage(1,"Initial Stage")  
 stage.initialize(nschemas = 10, nactions = 10, nitems = 10)
 stage.schemas.foreach(x => println(x))

*/
