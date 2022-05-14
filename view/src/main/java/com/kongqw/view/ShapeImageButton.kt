package com.kongqw.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton
import com.kongqw.view.bean.AttributeParams
import com.kongqw.view.helper.AttributeHelper
import com.kongqw.view.helper.ViewHelper
import com.kongqw.view.interfaces.IAttributeParams

class ShapeImageButton(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : AppCompatImageButton(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, android.R.attr.imageButtonStyle)

    constructor(context: Context) : this(context, null)

    private var mAttributeParams: AttributeParams = AttributeHelper.obtainStyledAttributes(context, attrs, object : IAttributeParams {
        override fun onAttrsId(): IntArray = R.styleable.ShapeImageButton

        override fun onTextColorIndex(): Int = R.styleable.ShapeImageButton_textColor
        override fun onTextPressedColorIndex(): Int = R.styleable.ShapeImageButton_textPressedColor
        override fun onTextDisableColorIndex(): Int = R.styleable.ShapeImageButton_textDisabledColor

        override fun onCornerTypeIndex(): Int = R.styleable.ShapeImageButton_cornerType
        override fun onCornerRadiusIndex(): Int = R.styleable.ShapeImageButton_cornerRadius

        override fun onBackgroundColorOrientationIndex(): Int = R.styleable.ShapeImageButton_backgroundColorOrientation
        override fun onBackgroundColorsIndex(): Int = R.styleable.ShapeImageButton_backgroundColors
        override fun onBackgroundPressedColorsIndex(): Int = R.styleable.ShapeImageButton_backgroundPressedColors
        override fun onBackgroundDisabledIndex(): Int = R.styleable.ShapeImageButton_backgroundDisabledColors

        override fun onStrokeWidthIndex(): Int = R.styleable.ShapeImageButton_strokeWidth
        override fun onStrokePressedWidthIndex(): Int = R.styleable.ShapeImageButton_strokePressedWidth
        override fun onStrokeDisabledWidthIndex(): Int = R.styleable.ShapeImageButton_strokeDisabledWidth
        override fun onStrokeColorIndex(): Int = R.styleable.ShapeImageButton_strokeColor
        override fun onStrokePressedColorIndex(): Int = R.styleable.ShapeImageButton_strokePressedColor
        override fun onStrokeDisabledColorIndex(): Int = R.styleable.ShapeImageButton_strokeDisabledColor
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