package ii887522.controlify.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import ii887522.controlify.any.Map
import ii887522.controlify.control.BorderView
import ii887522.controlify.enums.Input
import ii887522.controlify.struct.Border
import ii887522.controlify.struct.IntPoint
import ii887522.controlify.struct.IntRect
import ii887522.controlify.struct.IntSize

class BorderViewGroup(context: Context, attr: AttributeSet) : View(context, attr) {
  private lateinit var borderViews: Array<BorderView<Input>>

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    borderViews = arrayOf(
      BorderView(Border(IntRect(IntPoint(0, 0), IntSize(4, 4)), 1)),
      BorderView(Border(IntRect(IntPoint(8, 0), IntSize(4, 4)), 1)),
      BorderView(Border(IntRect(IntPoint(16, 0), IntSize(8, 8)), 1)),
      BorderView(Border(IntRect(IntPoint(28, 0), IntSize(8, 8)), 2)),
      BorderView(Border(IntRect(IntPoint(40, 0), IntSize(8, 8)), 2), Color.RED),
      BorderView(Border(IntRect(IntPoint(52, 0), IntSize(8, 8)), 2), Color.RED, map = Map(IntSize(4, 4)), cellValue = Input.UP),
      BorderView(Border(IntRect(IntPoint(64, 0), IntSize(8, 8)), 2), Color.RED, map = Map(IntSize(6, 6)), cellValue = Input.RIGHT)
    )
  }

  override fun onDraw(canvas: Canvas?) {
    for (borderView in borderViews) borderView.render(canvas!!)
  }
}
