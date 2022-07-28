@file:Suppress("UNUSED_PARAMETER") // <- REMOVE
package galaxyraiders.core.physics

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.lang.Math.toDegrees
import kotlin.math.atan2
import kotlin.math.sqrt

@JsonIgnoreProperties("unit", "normal", "degree", "magnitude")
data class Vector2D(val dx: Double, val dy: Double) {
  override fun toString(): String {
    return "Vector2D(dx=$dx, dy=$dy)"
  }

  val magnitude: Double
    get() = sqrt(this* this)

  val radiant: Double
    get() = atan2(this.dy,this.dx)

  val degree: Double
    get() = toDegrees(this.radiant)

  val unit: Vector2D
    get() = Vector2D(this.dx/magnitude,this.dy/magnitude)

  val normal: Vector2D
    get() = Vector2D(this.dy/magnitude,-this.dx/magnitude)

  operator fun times(scalar: Double): Vector2D {
    val timesDx=this.dx*scalar
    val timesDy=this.dy*scalar
    return Vector2D(timesDx,timesDy)
  }

  operator fun div(scalar: Double): Vector2D {
    val timesDx=this.dx/scalar
    val timesDy=this.dy/scalar
    return Vector2D(timesDx,timesDy)
  }

  operator fun times(v: Vector2D): Double {
    val timesDX:Double= this.dx * v.dx
    val timesDY:Double= this.dy * v.dy
    return timesDX+timesDY
  }

  operator fun plus(v: Vector2D): Vector2D {
    val sumDX:Double= this.dx+v.dx
    val sumDY:Double= this.dy+v.dy
    return Vector2D(sumDX,sumDY)

  }

  operator fun plus(p: Point2D): Point2D {
    val sumX:Double= this.dx+p.x
    val sumY:Double= this.dy+p.y
    return Point2D(sumX,sumY)
  }

  operator fun unaryMinus(): Vector2D {
    val invDX:Double= -this.dx
    val invDY:Double= -this.dy
    return Vector2D(invDX,invDY)
  }

  operator fun minus(v: Vector2D): Vector2D {
    val subDX:Double= this.dx-v.dx
    val subDY:Double= this.dy-v.dy
    return Vector2D(subDX,subDY)
  }

  fun scalarProject(target: Vector2D): Double {
    return (this*target)/target.magnitude
  }

  fun vectorProject(target: Vector2D): Vector2D {
    return this.scalarProject(target)*target/target.magnitude
  }
}

operator fun Double.times(v: Vector2D): Vector2D {
  val timesDx=v.dx*this
  val timesDy=v.dy*this
  return Vector2D(timesDx,timesDy)
}
