package ii887522.controlify.any

import ii887522.controlify.struct.IntPoint
import ii887522.controlify.struct.IntSize

/**
 * **Not Thread Safe**
 */
class Map<T : Enum<T>>(size: IntSize) {
  private val cells = IntArray(size.w * size.h)
  private val width = size.w

  operator fun get(position: IntPoint) = cells[position.y * width + position.x]

  operator fun set(position: IntPoint, value: T) {
    cells[position.y * width + position.x] = value.ordinal
  }
}
