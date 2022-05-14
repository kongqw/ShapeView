package com.kongqw.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.kongqw.view.bean.AttributeParams
import com.kongqw.view.helper.AttributeHelper
import com.kongqw.view.helper.ViewHelper
import com.kongqw.view.interfaces.IAttributeParams

class ShapeView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : View(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null)

    private var mAttributeParams: AttributeParams = AttributeHelper.obtainStyledAttributes(context, attrs, object : IAttributeParams {
        override fun onAttrsId(): IntArray = R.styleable.ShapeView

        override fun onTextColorIndex(): Int = R.styleable.ShapeView_textColor
        override fun onTextPressedColorIndex(): Int = R.styleable.ShapeView_textPressedColor
        override fun onTextDisableColorIndex(): Int = R.styleable.ShapeView_textDisabledColor

        override fun onCornerTypeIndex(): Int = R.styleable.ShapeView_cornerType
        override fun onCornerRadiusIndex(): Int = R.styleable.ShapeView_cornerRadius

        override fun onBackgroundColorOrientationIndex(): Int = R.styleable.ShapeView_backgroundColorOrientation
        override fun onBackgroundColorsIndex(): Int = R.styleable.ShapeView_backgroundColors
        override fun onBackgroundPressedColorsIndex(): Int = R.styleable.ShapeView_backgroundPressedColors
        override fun onBackgroundDisabledIndex(): Int = R.styleable.ShapeView_backgroundDisabledColors

        override fun onStrokeWidthIndex(): Int = R.styleable.ShapeView_strokeWidth
        override fun onStrokePressedWidthIndex(): Int = R.styleable.ShapeView_strokePressedWidth
        override fun onStrokeDisabledWidthIndex(): Int = R.styleable.ShapeView_strokeDisabledWidth
        override fun onStrokeColorIndex(): Int = R.styleable.ShapeView_strokeColor
        override fun onStrokePressedColorIndex(): Int = R.styleable.ShapeView_strokePressedColor
        override fun onStrokeDisabledColorIndex(): Int = R.styleable.ShapeView_strokeDisabledColor
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