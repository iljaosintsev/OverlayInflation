package example.turlir.com.overlayinflation

import android.content.Context
import android.support.design.button.MaterialButton
import android.util.AttributeSet

class SpecialButton : MaterialButton {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) :
            super(context, attributeSet, defStyleAttr)

}