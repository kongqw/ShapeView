package com.kongqw.view.layout

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.kongqw.view.R
import com.kongqw.view.bean.AttributeParams
import com.kongqw.view.helper.AttributeHelper
import com.kongqw.view.helper.ViewHelper
import com.kongqw.view.interfaces.IAttributeParams

class ShapeConstraintLayout(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : ConstraintLayout(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null)

    private var mAttributeParams: AttributeParams = AttributeHelper.obtainStyledAttributes(context, attrs, object : IAttributeParams {
        override fun onAttrsId(): IntArray = R.styleable.ShapeConstraintLayout

        override fun onTextColorIndex(): Int? = null
        override fun onTextPressedColorIndex(): Int? = null
        override fun onTextDisableColorIndex(): Int? = null

        override fun onCornerTypeIndex(): Int = R.styleable.ShapeConstraintLayout_cornerType
        override fun onCornerRadiusIndex(): Int = R.styleable.ShapeConstraintLayout_cornerRadius

        override fun onBackgroundColorOrientationIndex(): Int = R.styleable.ShapeConstraintLayout_backgroundColorOrientation
        override fun onBackgroundColorsIndex(): Int = R.styleable.ShapeConstraintLayout_backgroundColors
        override fun onBackgroundPressedColorsIndex(): Int = R.styleable.ShapeConstraintLayout_backgroundPressedColors
        override fun onBackgroundDisabledIndex(): Int = R.styleable.ShapeConstraintLayout_backgroundDisabledColors

        override fun onStrokeWidthIndex(): Int = R.styleable.ShapeConstraintLayout_strokeWidth
        override fun onStrokePressedWidthIndex(): Int = R.styleable.ShapeConstraintLayout_strokePressedWidth
        override fun onStrokeDisabledWidthIndex(): Int = R.styleable.ShapeConstraintLayout_strokeDisabledWidth
        override fun onStrokeColorIndex(): Int = R.styleable.ShapeConstraintLayout_strokeColor
        override fun onStrokePressedColorIndex(): Int = R.styleable.ShapeConstraintLayout_strokePressedColor
        override fun onStrokeDisabledColorIndex(): Int = R.styleable.ShapeConstraintLayout_strokeDisabledColor
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