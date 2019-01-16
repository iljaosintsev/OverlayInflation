package example.turlir.com.overlayinflation

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.CheckBox
import android.widget.Switch
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class MainActivity : AppCompatActivity() {

    private lateinit var switch: Switch

    private val pref by lazy {
        Pref(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switch = findViewById(R.id.sw_mode)
        switch.isChecked = pref.isDark
        switch.setOnCheckedChangeListener { _, value ->
            pref.isDark = value
            recreate()
        }
        val checkbox = findViewById<CheckBox>(R.id.enabled)
        checkbox.isChecked = findViewById<View>(R.id.specialButton).isEnabled
        checkbox.setOnCheckedChangeListener { _, value ->
            findViewById<View>(R.id.specialButton).isEnabled = value
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(base))
    }
}

