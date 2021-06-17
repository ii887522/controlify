package ii887522.controlify.any

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import ii887522.controlify.R
import ii887522.controlify.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
  private val canIncrementScore0 = MutableLiveData(false)
  private val canResetScore0 = MutableLiveData(false)
  private val canIncrementScore1 = MutableLiveData(false)
  private val canResetScore1 = MutableLiveData(false)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    ScoreModel(this, max = 0, canIncrement = canIncrementScore0, canReset = canResetScore0).value.observe(this) {
      binding.score0.text = resources.getString(R.string.score_text, it)
    }
    ScoreModel(this, max = 1, canIncrement = canIncrementScore0, canReset = canResetScore0).value.observe(this) {
      binding.score1.text = resources.getString(R.string.score_text, it)
    }
    ScoreModel(this, max = 1, canIncrement = canIncrementScore0, canReset = canResetScore0) {
      Timber.i("You win!")
    }.value.observe(this) {
      binding.score2.text = resources.getString(R.string.score_text, it)
    }
    ScoreModel(this, max = 1, canIncrement = canIncrementScore1, canReset = canResetScore0) {
      Timber.i("You win!")
    }.value.observe(this) {
      binding.score3.text = resources.getString(R.string.score_text, it)
    }
    ScoreModel(this, max = 1, canIncrement = canIncrementScore1, canReset = canResetScore1) {
      Timber.i("You win!")
    }.value.observe(this) {
      binding.score4.text = resources.getString(R.string.score_text, it)
    }
  }
}
