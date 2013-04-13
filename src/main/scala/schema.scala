package com.beartronics.sschema

import scala.collection.mutable.ArrayBuffer

class Schema {
  // Numerical id of this schema
  val id:Int = 0;
    
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
  val xc_posTransitionWithAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  val xc_posTransitionWithoutAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  
  val xc_negTransitionWithAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  val xc_negTranstitionWithoutAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  
  val xc_remainPosWithAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  val xc_remainPosWithoutAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  
  val xc_remainNegWithAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  val xc_remainNegWithoutAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  
    // Extended Result counters
  val xr_posTransitionWithAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  val xr_posTransitionWithoutAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  
  val xr_negTransitionWithAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  val xr_negTranstitionWithoutAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  
  val xr_remainPosWithAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  val xr_remainPosWithoutAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  
  val xr_remainNegWithAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  val xr_remainNegWithoutAction: ArrayBuffer[Int] = new ArrayBuffer[Int]();
  
    // List of schemas who override this schema;
  val XOverride: ArrayBuffer[Schema] = new ArrayBuffer[Schema]();
  
  val action: Action = null;

  public Schema(index: Int, action: Action) {
    this.id = index;
    this.action = action;
  }

  // Initialize this schema, for this stage
  public void initialize(stage: Stage) {
    // create extended context, result arrays
    
  }

  public String toString() {
    return "[Schema %s::%~s/ action %s/ %s::~%s]".format(posContext.toString(), negContext.toString(), action, posResult.toString(), negResult.toString());
  }

}
