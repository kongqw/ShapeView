package com.kongqw.view.layout

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.kongqw.view.R
import com.kongqw.view.bean.AttributeParams
import com.kongqw.view.helper.AttributeHelper
import com.kongqw.view.helper.ViewHelper
import com.kongqw.view.interfaces.IAttributeParams

class ShapeFrameLayout(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : FrameLayout(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null)
    
    private var mAttributeParams: AttributeParams = AttributeHelper.obtainStyledAttributes(context, attrs, object : IAttributeParams {
        override fun onAttrsId(): IntArray = R.styleable.ShapeFrameLayout

        override fun onTextColorIndex(): Int? = null
        override fun onTextPressedColorIndex(): Int? = null
        override fun onTextDisableColorIndex(): Int? = null

        override fun onCornerTypeIndex(): Int = R.styleable.ShapeFrameLayout_cornerType
        override fun onCornerRadiusIndex(): Int = R.styleable.ShapeFrameLayout_cornerRadius

        override fun onBackgroundColorOrientationIndex(): Int = R.styleable.ShapeFrameLayout_backgroundColorOrientation
        override fun onBackgroundColorsIndex(): Int = R.styleable.ShapeFrameLayout_backgroundColors
        override fun onBackgroundPressedColorsIndex(): Int = R.styleable.ShapeFrameLayout_backgroundPressedColors
        override fun onBackgroundDisabledIndex(): Int = R.styleable.ShapeFrameLayout_backgroundDisabledColors

        override fun onStrokeWidthIndex(): Int = R.styleable.ShapeFrameLayout_strokeWidth
        override fun onStrokePressedWidthIndex(): Int = R.styleable.ShapeFrameLayout_strokePressedWidth
        override fun onStrokeDisabledWidthIndex(): Int = R.styleable.ShapeFrameLayout_strokeDisabledWidth
        override fun onStrokeColorIndex(): Int = R.styleable.ShapeFrameLayout_strokeColor
        override fun onStrokePressedColorIndex(): Int = R.styleable.ShapeFrameLayout_strokePressedColor
        override fun onStrokeDisabledColorIndex(): Int = R.styleable.ShapeFrameLayout_strokeDisabledColor
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