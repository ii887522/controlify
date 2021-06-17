package ii887522.controlify.control

import android.graphics.Canvas
import androidx.lifecycle.LifecycleOwner
import ii887522.controlify.struct.IntPoint
import ii887522.controlify.any.Control
import ii887522.controlify.enums.Input

/**
 * It is a special view that can contain other views (called children).
 *
 * **Not Thread Safe**: it must not be assigned to integer
 * @see Control
 */
open class ControlGroup(lifecycleOwner: LifecycleOwner, position: IntPoint = IntPoint(), private val controls: Array<Control> = emptyArray()) : Control(position) {
  init {
    for (control in controls) {
      control.position.observe(lifecycleOwner) {
        if (!control.canTriggerPositionObservers) return@observe
        control.canTriggerPositionObservers = false
        control.position.value = it + position
      }
    }
  }

  override fun reactInput(input: Input) {
    for (control in controls) control.reactInput(input)
  }

  override fun step(dt: Int) {
    for (control in controls) control.step(dt)
  }

  final override fun checkAndReactHits(dt: Int) {
    for (control in controls) control.checkAndReactHits(dt)
  }

  override fun render(canvas: Canvas) {
    for (control in controls) control.render(canvas)
  }
}
