package galaxyraiders.core.game

import galaxyraiders.core.physics.Object2D
import galaxyraiders.core.physics.Point2D;
import galaxyraiders.core.physics.Vector2D;

class Explosion (
  initialPosition: Point2D,
  initialVelocity: Vector2D,
  radius: Double,
  mass: Double,
  var frameCounter: Int = 5

): SpaceObject("Explosion", 'O', initialPosition, initialVelocity, radius, mass){
  fun hasFrames():Boolean{
    if(frameCounter==0)
      return false
    else
      frameCounter=frameCounter-1
      return true
  }
}



