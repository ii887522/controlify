package ii887522.controlify.any

import android.app.Application
import timber.log.Timber

class ControlifyApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    Timber.plant(Timber.DebugTree())
  }
}
