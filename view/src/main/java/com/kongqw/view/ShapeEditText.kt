package com.kongqw.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.kongqw.view.bean.AttributeParams
import com.kongqw.view.helper.AttributeHelper
import com.kongqw.view.helper.ViewHelper
import com.kongqw.view.interfaces.IAttributeParams

class ShapeEditText(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : AppCompatEditText(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, android.R.attr.editTextStyle)

    constructor(context: Context) : this(context, null)

    private var mAttributeParams: AttributeParams = AttributeHelper.obtainStyledAttributes(context, attrs, object : IAttributeParams {
        override fun onAttrsId(): IntArray = R.styleable.ShapeEditText

        override fun onTextColorIndex(): Int = R.styleable.ShapeEditText_textColor
        override fun onTextPressedColorIndex(): Int = R.styleable.ShapeEditText_textPressedColor
        override fun onTextDisableColorIndex(): Int = R.styleable.ShapeEditText_textDisabledColor

        override fun onCornerTypeIndex(): Int = R.styleable.ShapeEditText_cornerType
        override fun onCornerRadiusIndex(): Int = R.styleable.ShapeEditText_cornerRadius

        override fun onBackgroundColorOrientationIndex(): Int = R.styleable.ShapeEditText_backgroundColorOrientation
        override fun onBackgroundColorsIndex(): Int = R.styleable.ShapeEditText_backgroundColors
        override fun onBackgroundPressedColorsIndex(): Int = R.styleable.ShapeEditText_backgroundPressedColors
        override fun onBackgroundDisabledIndex(): Int = R.styleable.ShapeEditText_backgroundDisabledColors

        override fun onStrokeWidthIndex(): Int = R.styleable.ShapeEditText_strokeWidth
        override fun onStrokePressedWidthIndex(): Int = R.styleable.ShapeEditText_strokePressedWidth
        override fun onStrokeDisabledWidthIndex(): Int = R.styleable.ShapeEditText_strokeDisabledWidth
        override fun onStrokeColorIndex(): Int = R.styleable.ShapeEditText_strokeColor
        override fun onStrokePressedColorIndex(): Int = R.styleable.ShapeEditText_strokePressedColor
        override fun onStrokeDisabledColorIndex(): Int = R.styleable.ShapeEditText_strokeDisabledColor
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