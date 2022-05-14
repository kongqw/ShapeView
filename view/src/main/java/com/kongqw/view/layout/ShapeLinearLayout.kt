package com.kongqw.view.layout

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.kongqw.view.R
import com.kongqw.view.bean.AttributeParams
import com.kongqw.view.helper.AttributeHelper
import com.kongqw.view.helper.ViewHelper
import com.kongqw.view.interfaces.IAttributeParams

class ShapeLinearLayout(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : LinearLayout(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null)

    private var mAttributeParams: AttributeParams = AttributeHelper.obtainStyledAttributes(context, attrs, object : IAttributeParams {
        override fun onAttrsId(): IntArray = R.styleable.ShapeLinearLayout

        override fun onTextColorIndex(): Int? = null
        override fun onTextPressedColorIndex(): Int? = null
        override fun onTextDisableColorIndex(): Int? = null

        override fun onCornerTypeIndex(): Int = R.styleable.ShapeLinearLayout_cornerType
        override fun onCornerRadiusIndex(): Int = R.styleable.ShapeLinearLayout_cornerRadius

        override fun onBackgroundColorOrientationIndex(): Int = R.styleable.ShapeLinearLayout_backgroundColorOrientation
        override fun onBackgroundColorsIndex(): Int = R.styleable.ShapeLinearLayout_backgroundColors
        override fun onBackgroundPressedColorsIndex(): Int = R.styleable.ShapeLinearLayout_backgroundPressedColors
        override fun onBackgroundDisabledIndex(): Int = R.styleable.ShapeLinearLayout_backgroundDisabledColors

        override fun onStrokeWidthIndex(): Int = R.styleable.ShapeLinearLayout_strokeWidth
        override fun onStrokePressedWidthIndex(): Int = R.styleable.ShapeLinearLayout_strokePressedWidth
        override fun onStrokeDisabledWidthIndex(): Int = R.styleable.ShapeLinearLayout_strokeDisabledWidth
        override fun onStrokeColorIndex(): Int = R.styleable.ShapeLinearLayout_strokeColor
        override fun onStrokePressedColorIndex(): Int = R.styleable.ShapeLinearLayout_strokePressedColor
        override fun onStrokeDisabledColorIndex(): Int = R.styleable.ShapeLinearLayout_strokeDisabledColor
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