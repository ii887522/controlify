package ii887522.controlify.struct

import ii887522.oxy.any.Calculatable
import ii887522.oxy.struct.FloatVector

data class FloatPoint(val x: Float = .0f, val y: Float = .0f) : Calculatable<FloatPoint> {
  override fun plus(that: FloatPoint) = FloatPoint(x + that.x, y + that.y)
  override fun minus(that: FloatPoint) = FloatPoint(x - that.x, y - that.y)
  override fun times(that: FloatPoint) = FloatPoint(x * that.x, y * that.y)
  override fun div(that: FloatPoint) = FloatPoint(x / that.x, y / that.y)
  override fun plus(that: Number) = FloatPoint(x + that.toFloat(), y + that.toFloat())
  override fun minus(that: Number) = FloatPoint(x - that.toFloat(), y - that.toFloat())
  override fun times(that: Number) = FloatPoint(x * that.toFloat(), y * that.toFloat())
  override fun div(that: Number) = FloatPoint(x / that.toFloat(), y / that.toFloat())
  operator fun plus(that: FloatVector) = FloatPoint(x + that.x, y + that.y)
  operator fun minus(that: FloatVector) = FloatPoint(x - that.x, y - that.y)
  fun toIntPoint() = IntPoint(x.toInt(), y.toInt())
}
