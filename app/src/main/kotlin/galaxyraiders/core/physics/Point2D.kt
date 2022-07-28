@file:Suppress("UNUSED_PARAMETER") // <- REMOVE
package galaxyraiders.core.physics

import javax.security.auth.Subject
import kotlin.math.sqrt

data class Point2D(val x: Double, val y: Double) {
  operator fun plus(p: Point2D): Point2D {
    val sumX:Double= this.x+p.x
    val sumY:Double= this.y+p.y
    return Point2D(sumX,sumY)
  }

  operator fun plus(v: Vector2D): Point2D {
    val sumX:Double= v.dx+this.x
    val sumY:Double= v.dy+this.y
    return Point2D(sumX,sumY)
  }

  override fun toString(): String {
    return "Point2D(x=$x, y=$y)"
  }

  fun toVector(): Vector2D {
    return Vector2D(this.x, this.y)
  }

  fun impactVector(p: Point2D): Vector2D {
    val SubX=this.x-p.x
    val SubY=this.y-p.y
    return Vector2D(-SubX,-SubY)
  }

  fun impactDirection(p: Point2D): Vector2D {
    return impactVector(p).unit
  }

  fun contactVector(p: Point2D): Vector2D {
    return impactVector(p).normal
  }

  fun contactDirection(p: Point2D): Vector2D {
    return contactVector(p).unit
  }

  fun distance(p: Point2D): Double {
    val difX = this.x - p.x
    val difY = this.y - p.y
    return sqrt(difX * difX + difY * difY)
  }
}
