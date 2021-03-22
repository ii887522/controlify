package ii887522.controlify.struct

import ii887522.oxy.any.Calculatable

data class IntSize(val w: Int = 0, val h: Int = 0) : Calculatable<IntSize> {
  override fun plus(that: IntSize) = IntSize(w + that.w, h + that.h)
  override fun minus(that: IntSize) = IntSize(w - that.w, h - that.h)
  override fun times(that: IntSize) = IntSize(w * that.w, h * that.h)
  override fun div(that: IntSize) = IntSize(w / that.w, h / that.h)
  override fun plus(that: Number) = IntSize(w + that.toInt(), h + that.toInt())
  override fun minus(that: Number) = IntSize(w - that.toInt(), h - that.toInt())
  override fun times(that: Number) = IntSize((w * that.toFloat()).toInt(), (h * that.toFloat()).toInt())
  override fun div(that: Number) = IntSize((w / that.toFloat()).toInt(), (h / that.toFloat()).toInt())
}
