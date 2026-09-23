package `fun`.fuionix.launcher.base.welcome

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import `fun`.fuionix.launcher.databinding.ActivityWelcomeBinding

// the welcome screen you see on first launch
class MainWelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

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

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        applyInsets(binding.root)
    }
}