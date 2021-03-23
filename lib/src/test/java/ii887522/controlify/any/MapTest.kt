package ii887522.controlify.any

import ii887522.controlify.struct.IntSize
import ii887522.controlify.enums.Input
import ii887522.controlify.struct.IntPoint
import org.junit.Assert.assertEquals
import org.junit.Test

class MapTest {
  @Test fun setIn3x3MapIsCorrect() {
    val map = Map<Input>(IntSize(3, 3))
    map[IntPoint(0, 0)] = Input.RIGHT
    assertEquals(Input.RIGHT.ordinal, map[IntPoint(0, 0)])
    map[IntPoint(1, 1)] = Input.RIGHT
    assertEquals(Input.RIGHT.ordinal, map[IntPoint(1, 1)])
    map[IntPoint(1, 1)] = Input.DOWN
    assertEquals(Input.DOWN.ordinal, map[IntPoint(1, 1)])
  }

  @Test fun setIn5x5MapIsCorrect() {
    val map = Map<Input>(IntSize(5, 5))
    map[IntPoint(0, 0)] = Input.RIGHT
    assertEquals(Input.RIGHT.ordinal, map[IntPoint(0, 0)])
    map[IntPoint(1, 1)] = Input.RIGHT
    assertEquals(Input.RIGHT.ordinal, map[IntPoint(1, 1)])
    map[IntPoint(1, 1)] = Input.DOWN
    assertEquals(Input.DOWN.ordinal, map[IntPoint(1, 1)])
  }
}
