package `fun`.fuionix.launcher.data

import android.content.Context
import androidx.core.content.edit

// Launcher Shared Preferences class
class LauncherPreferences(context: Context) {

    private val _prefsName = "LauncherPreferences"
    private val sharedPreferences = context.getSharedPreferences(_prefsName, Context.MODE_PRIVATE)

    // Current launcher state. Used for launching configuration screen, etc.
    // 0 - Default, normal mode.
    // 1 - Launcher updated, changelog screen
    // 2 - First launch, welcome screen
    // -1 - Launcher crashed, error screen
    var currentState
        get() = sharedPreferences.getInt("state", 2)
        set(value) = sharedPreferences.edit { putInt("state", value) }


}