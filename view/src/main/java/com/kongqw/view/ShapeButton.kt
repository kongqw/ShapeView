package com.kongqw.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.kongqw.view.bean.AttributeParams
import com.kongqw.view.helper.AttributeHelper
import com.kongqw.view.helper.ViewHelper
import com.kongqw.view.interfaces.IAttributeParams

class ShapeButton(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : AppCompatButton(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, android.R.attr.buttonStyle)

    constructor(context: Context) : this(context, null)

    private var mAttributeParams: AttributeParams = AttributeHelper.obtainStyledAttributes(context, attrs, object : IAttributeParams {
        override fun onAttrsId(): IntArray = R.styleable.ShapeButton

        override fun onTextColorIndex(): Int = R.styleable.ShapeButton_textColor
        override fun onTextPressedColorIndex(): Int = R.styleable.ShapeButton_textPressedColor
        override fun onTextDisableColorIndex(): Int = R.styleable.ShapeButton_textDisabledColor

        override fun onCornerTypeIndex(): Int = R.styleable.ShapeButton_cornerType
        override fun onCornerRadiusIndex(): Int = R.styleable.ShapeButton_cornerRadius

        override fun onBackgroundColorOrientationIndex(): Int = R.styleable.ShapeButton_backgroundColorOrientation
        override fun onBackgroundColorsIndex(): Int = R.styleable.ShapeButton_backgroundColors
        override fun onBackgroundPressedColorsIndex(): Int = R.styleable.ShapeButton_backgroundPressedColors
        override fun onBackgroundDisabledIndex(): Int = R.styleable.ShapeButton_backgroundDisabledColors

        override fun onStrokeWidthIndex(): Int = R.styleable.ShapeButton_strokeWidth
        override fun onStrokePressedWidthIndex(): Int = R.styleable.ShapeButton_strokePressedWidth
        override fun onStrokeDisabledWidthIndex(): Int = R.styleable.ShapeButton_strokeDisabledWidth
        override fun onStrokeColorIndex(): Int = R.styleable.ShapeButton_strokeColor
        override fun onStrokePressedColorIndex(): Int = R.styleable.ShapeButton_strokePressedColor
        override fun onStrokeDisabledColorIndex(): Int = R.styleable.ShapeButton_strokeDisabledColor
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