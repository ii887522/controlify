package ii887522.controlify.control

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import ii887522.controlify.any.Control
import ii887522.controlify.struct.IntPoint
import ii887522.controlify.struct.Border

/**
 * **Not Thread Safe**: it must only be used in main thread
 *
 * @see Control
 */
class BorderView<T : Enum<T>>(private val border: Border, private val p_color: Int = Color.BLACK, map: ii887522.controlify.any.Map<T>? = null, cellValue: T? = null) : ii887522.controlify.any.Control(border.rect.position) {
  private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    color = p_color
  }

  private val rects = arrayOf(
    Rect(border.rect.position.x, border.rect.position.y, border.rect.position.x + border.width, border.rect.position.y + border.width),
    Rect(
      border.rect.position.x + border.width, border.rect.position.y, border.rect.position.x + border.rect.size.w - border.width,
      border.rect.position.y + border.width
    ),
    Rect(
      border.rect.position.x + border.rect.size.w - border.width, border.rect.position.y, border.rect.position.x + border.rect.size.w,
      border.rect.position.y + border.width
    ),
    Rect(
      border.rect.position.x + border.rect.size.w - border.width, border.rect.position.y + border.width, border.rect.position.x + border.rect.size.w,
      border.rect.position.y + border.rect.size.h - border.width
    ),
    Rect(
      border.rect.position.x + border.rect.size.w - border.width, border.rect.position.y + border.rect.size.h - border.width,
      border.rect.position.x + border.rect.size.w, border.rect.position.y + border.rect.size.h
    ),
    Rect(
      border.rect.position.x + border.width, border.rect.position.y + border.rect.size.h - border.width,
      border.rect.position.x + border.rect.size.w - border.width, border.rect.position.y + border.rect.size.h
    ),
    Rect(
      border.rect.position.x, border.rect.position.y + border.rect.size.h - border.width, border.rect.position.x + border.width,
      border.rect.position.y + border.rect.size.h
    ),
    Rect(
      border.rect.position.x, border.rect.position.y + border.width, border.rect.position.x + border.width,
      border.rect.position.y + border.rect.size.h - border.width
    )
  )

  init {
    if (map != null) setCells(map, cellValue!!)
  }

  private fun setTopCells(map: ii887522.controlify.any.Map<T>, cellValue: T) {
    for (i in 0 until border.rect.size.w / border.width) map[IntPoint(i, 0)] = cellValue
  }

  private fun setRightCells(map: ii887522.controlify.any.Map<T>, cellValue: T) {
    for (i in 0 until border.rect.size.h / border.width) map[IntPoint(border.rect.size.w / border.width - 1, i)] = cellValue
  }

  private fun setBottomCells(map: ii887522.controlify.any.Map<T>, cellValue: T) {
    for (i in 0 until border.rect.size.w / border.width) map[IntPoint(i, border.rect.size.h / border.width - 1)] = cellValue
  }

  private fun setLeftCells(map: ii887522.controlify.any.Map<T>, cellValue: T) {
    for (i in 0 until border.rect.size.h / border.width) map[IntPoint(0, i)] = cellValue
  }

  private fun setCells(map: ii887522.controlify.any.Map<T>, cellValue: T) {
    setTopCells(map, cellValue)
    setRightCells(map, cellValue)
    setBottomCells(map, cellValue)
    setLeftCells(map, cellValue)
  }

  override fun render(canvas: Canvas) {
    for (rect in rects) canvas.drawRect(rect, paint)
  }
}
