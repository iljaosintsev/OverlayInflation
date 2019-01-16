package example.turlir.com.overlayinflation

import android.content.Context
import io.github.inflationx.viewpump.InflateResult
import io.github.inflationx.viewpump.Interceptor

/**
 * Перехватчик для динамического применения overlay на указанный виджет
 */
class SpecialButtonColorized(cnt: Context) : Interceptor {

    private val pref = Pref(cnt.applicationContext)

    override fun intercept(chain: Interceptor.Chain): InflateResult {
        val request = chain.request()
        if (request.name() == "example.turlir.com.overlayinflation.SpecialButton") {
            val overlay = if (pref.isDark) {
                R.style.DarkAccentOverlay
            } else {
                R.style.LightAccentOverlay
            }
            request.context()
                .theme.applyStyle(overlay, true)
        }
        return chain.proceed(request)
    }
}