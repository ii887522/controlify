package ii887522.controlify.any

import android.graphics.Canvas
import androidx.lifecycle.MutableLiveData
import ii887522.controlify.struct.IntPoint
import ii887522.controlify.enums.Input

/**
 * It represents the basic building block for user interface components. A control occupies a rectangular area on the screen and is responsible for drawing and event handling.
 *
 * **Not Thread Safe**: it must only be used in main thread
 */
abstract class Control(position: IntPoint = IntPoint()) {
  val position = MutableLiveData(position)
  var canTriggerPositionObservers = true

  open fun reactInput(input: Input) { }
  open fun step(dt: Int) { }
  open fun checkAndReactHits(dt: Int) { }
  abstract fun render(canvas: Canvas)
}
