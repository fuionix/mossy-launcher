package `fun`.fuionix.launcher

import android.app.Activity
import android.app.Application
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log

class LauncherApplication : Application() {
    private val logTag: String = "Mossy Launcher"
    private var activityCallback: ActivityLifecycleCallbacks? = null

    // The launcher is started by user
    override fun onCreate() {
        super.onCreate()

        Log.d(logTag, "Launcher is started. Build: ${BuildConfig.VERSION_NAME}")

        // just a debug thing. logs any changes in an activity lifecycle
        activityCallback = object : ActivityLifecycleCallbacks {

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                Log.d(logTag, "${activity.javaClass.simpleName} -> onCreate")
            }

            override fun onActivityStarted(activity: Activity) {
                Log.d(logTag, "${activity.javaClass.simpleName} -> onStart")
            }

            override fun onActivityResumed(activity: Activity) {
                Log.d(logTag, "${activity.javaClass.simpleName} -> onResume")
            }

            override fun onActivityPaused(activity: Activity) {
                Log.d(logTag, "${activity.javaClass.simpleName} -> onPause")
            }

            override fun onActivityStopped(activity: Activity) {
                Log.d(logTag, "${activity.javaClass.simpleName} -> onStop")
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                Log.d(logTag, "${activity.javaClass.simpleName} -> onSaveInstanceState")
            }

            override fun onActivityDestroyed(activity: Activity) {
                Log.d(logTag, "${activity.javaClass.simpleName} -> onDestroy")
            }
        }
        registerActivityLifecycleCallbacks(activityCallback)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d(logTag, "Configuration changed")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.d(logTag, "Low memory, clean up")
        unregisterActivityLifecycleCallbacks(activityCallback)
        activityCallback = null
    }
}