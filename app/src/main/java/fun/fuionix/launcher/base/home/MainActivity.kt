package `fun`.fuionix.launcher.base.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import `fun`.fuionix.launcher.base.welcome.MainWelcomeActivity
import `fun`.fuionix.launcher.data.LauncherPreferences
import `fun`.fuionix.launcher.databinding.ActivityMainBinding

// the home screen (with tiles and an app list)
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var preferences: LauncherPreferences

    private fun applyInsets(view: View) {
        ViewCompat.setOnApplyWindowInsetsListener(view) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(insets.left, insets.top, insets.right, insets.bottom)
            windowInsets
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)

        preferences = LauncherPreferences(this)
        when (preferences.currentState) {
            //-1 -> error screen
            //1 -> changelog screen
            2 -> {
                // Launch welcome screen instead of home screen
                startActivity(Intent(this, MainWelcomeActivity::class.java))
                finish()
                return
            }
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        applyInsets(binding.root)
    }
}