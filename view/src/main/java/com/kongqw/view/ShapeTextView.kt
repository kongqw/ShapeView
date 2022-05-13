package com.kongqw.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.kongqw.view.helper.StyleHelper
import com.kongqw.view.helper.StyleParams

class ShapeTextView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : AppCompatTextView(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, android.R.attr.textViewStyle)

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