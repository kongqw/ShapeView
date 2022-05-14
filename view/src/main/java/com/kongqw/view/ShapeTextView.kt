package com.kongqw.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.kongqw.view.bean.AttributeParams
import com.kongqw.view.helper.AttributeHelper
import com.kongqw.view.helper.ViewHelper
import com.kongqw.view.interfaces.IAttributeParams

class ShapeTextView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : AppCompatTextView(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, android.R.attr.textViewStyle)

    constructor(context: Context) : this(context, null)

    private var mAttributeParams: AttributeParams = AttributeHelper.obtainStyledAttributes(context, attrs, object : IAttributeParams {
        override fun onAttrsId(): IntArray = R.styleable.ShapeTextView

        override fun onTextColorIndex(): Int = R.styleable.ShapeTextView_textColor
        override fun onTextPressedColorIndex(): Int = R.styleable.ShapeTextView_textPressedColor
        override fun onTextDisableColorIndex(): Int = R.styleable.ShapeTextView_textDisabledColor

        override fun onCornerTypeIndex(): Int = R.styleable.ShapeTextView_cornerType
        override fun onCornerRadiusIndex(): Int = R.styleable.ShapeTextView_cornerRadius

        override fun onBackgroundColorOrientationIndex(): Int = R.styleable.ShapeTextView_backgroundColorOrientation
        override fun onBackgroundColorsIndex(): Int = R.styleable.ShapeTextView_backgroundColors
        override fun onBackgroundPressedColorsIndex(): Int = R.styleable.ShapeTextView_backgroundPressedColors
        override fun onBackgroundDisabledIndex(): Int = R.styleable.ShapeTextView_backgroundDisabledColors

        override fun onStrokeWidthIndex(): Int = R.styleable.ShapeTextView_strokeWidth
        override fun onStrokePressedWidthIndex(): Int = R.styleable.ShapeTextView_strokePressedWidth
        override fun onStrokeDisabledWidthIndex(): Int = R.styleable.ShapeTextView_strokeDisabledWidth
        override fun onStrokeColorIndex(): Int = R.styleable.ShapeTextView_strokeColor
        override fun onStrokePressedColorIndex(): Int = R.styleable.ShapeTextView_strokePressedColor
        override fun onStrokeDisabledColorIndex(): Int = R.styleable.ShapeTextView_strokeDisabledColor
    })

    init {
        ViewHelper.setOnTouchListener(this, mAttributeParams)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        ViewHelper.initView(this, mAttributeParams)
        outlineProvider = ViewHelper.makeViewOutlineProvider(mAttributeParams)
        clipToOutline = true
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        ViewHelper.setEnabled(this, mAttributeParams, enabled)
    }
}