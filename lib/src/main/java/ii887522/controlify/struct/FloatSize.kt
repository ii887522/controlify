package ii887522.controlify.struct

import ii887522.oxy.any.Calculatable

data class FloatSize(val w: Float = 1f, val h: Float = 1f) : Calculatable<FloatSize> {
  override fun plus(that: FloatSize) = FloatSize(w + that.w, h + that.h)
  override fun minus(that: FloatSize) = FloatSize(w - that.w, h - that.h)
  override fun times(that: FloatSize) = FloatSize(w * that.w, h * that.h)
  override fun div(that: FloatSize) = FloatSize(w / that.w, h / that.h)
  override fun plus(that: Number) = FloatSize(w + that.toFloat(), h + that.toFloat())
  override fun minus(that: Number) = FloatSize(w - that.toFloat(), h - that.toFloat())
  override fun times(that: Number) = FloatSize(w * that.toFloat(), h * that.toFloat())
  override fun div(that: Number) = FloatSize(w / that.toFloat(), h / that.toFloat())
}
