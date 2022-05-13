package com.kongqw.view.layout

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.kongqw.view.helper.StyleHelper
import com.kongqw.view.helper.StyleParams

class ShapeLinearLayout(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : LinearLayout(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null)

    private var mStyleParams: StyleParams = StyleHelper.initAttribute(context, attrs, isEnabled)

    init {
        StyleHelper.initView(this, mStyleParams)
        outlineProvider = StyleHelper.makeViewOutlineProvider(mStyleParams)
        clipToOutline = true
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        StyleHelper.setEnabled(this, mStyleParams, enabled)
    }
}