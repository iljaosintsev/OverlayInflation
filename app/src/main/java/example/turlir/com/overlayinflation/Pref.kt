package example.turlir.com.overlayinflation

import android.content.Context

/**
 * Работа с настройками
 */
class Pref(cnt: Context) {

    private val pref = cnt.getSharedPreferences("pref", Context.MODE_PRIVATE)

    /**
     * Выбранный режим подсветки
     */
    var isDark: Boolean
        get() = pref.getBoolean("isDark", true)
        set(value) {
            pref.edit().putBoolean("isDark", value).apply()
        }
}