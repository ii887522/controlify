package ii887522.controlify.struct

import ii887522.oxy.any.Calculatable
import ii887522.oxy.struct.IntVector

data class IntPoint(var x: Int = 0, var y: Int = 0) : Calculatable<IntPoint> {
  override fun plus(that: IntPoint) = IntPoint(x + that.x, y + that.y)
  override fun minus(that: IntPoint) = IntPoint(x - that.x, y - that.y)
  override fun times(that: IntPoint) = IntPoint(x * that.x, y * that.y)
  override fun div(that: IntPoint) = IntPoint(x / that.x, y / that.y)
  override fun plus(that: Number) = IntPoint(x + that.toInt(), y + that.toInt())
  override fun minus(that: Number) = IntPoint(x - that.toInt(), y - that.toInt())
  override fun times(that: Number) = IntPoint((x * that.toFloat()).toInt(), (y * that.toFloat()).toInt())
  override fun div(that: Number) = IntPoint((x / that.toFloat()).toInt(), (y / that.toFloat()).toInt())
  operator fun plus(that: IntVector) = IntPoint(x + that.x, y + that.y)
  operator fun minus(that: IntVector) = IntPoint(x - that.x, y - that.y)
  fun toFloatPoint() = FloatPoint(x.toFloat(), y.toFloat())
}
