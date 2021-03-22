package ii887522.controlify.any

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ScoreModel(lifecycleOwner: LifecycleOwner, max: Int, onValueMax: () -> Unit, canIncrement: MutableLiveData<Boolean>, canReset: LiveData<Boolean>) {
  private val _value = MutableLiveData(0)
  val value: LiveData<Int> get() = _value

  init {
    canIncrement.observe(lifecycleOwner) {
      if (!it) return@observe
      _value.value = _value.value?.plus(1)
      _value.value?.inc()
      if (value.value == max) onValueMax()
      canIncrement.value = false
    }
    canReset.observe(lifecycleOwner) {
      if (!it) return@observe
      _value.value = 0
    }
  }
}
