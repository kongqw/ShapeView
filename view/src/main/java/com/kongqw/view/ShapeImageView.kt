package com.kongqw.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.kongqw.view.bean.AttributeParams
import com.kongqw.view.helper.AttributeHelper
import com.kongqw.view.helper.ViewHelper
import com.kongqw.view.interfaces.IAttributeParams

class ShapeImageView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : AppCompatImageView(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null)

    private var mAttributeParams: AttributeParams = AttributeHelper.obtainStyledAttributes(context, attrs, object : IAttributeParams {
        override fun onAttrsId(): IntArray = R.styleable.ShapeImageView

        override fun onTextColorIndex(): Int = R.styleable.ShapeImageView_textColor
        override fun onTextPressedColorIndex(): Int = R.styleable.ShapeImageView_textPressedColor
        override fun onTextDisableColorIndex(): Int = R.styleable.ShapeImageView_textDisabledColor

        override fun onCornerTypeIndex(): Int = R.styleable.ShapeImageView_cornerType
        override fun onCornerRadiusIndex(): Int = R.styleable.ShapeImageView_cornerRadius

        override fun onBackgroundColorOrientationIndex(): Int = R.styleable.ShapeImageView_backgroundColorOrientation
        override fun onBackgroundColorsIndex(): Int = R.styleable.ShapeImageView_backgroundColors
        override fun onBackgroundPressedColorsIndex(): Int = R.styleable.ShapeImageView_backgroundPressedColors
        override fun onBackgroundDisabledIndex(): Int = R.styleable.ShapeImageView_backgroundDisabledColors

        override fun onStrokeWidthIndex(): Int = R.styleable.ShapeImageView_strokeWidth
        override fun onStrokePressedWidthIndex(): Int = R.styleable.ShapeImageView_strokePressedWidth
        override fun onStrokeDisabledWidthIndex(): Int = R.styleable.ShapeImageView_strokeDisabledWidth
        override fun onStrokeColorIndex(): Int = R.styleable.ShapeImageView_strokeColor
        override fun onStrokePressedColorIndex(): Int = R.styleable.ShapeImageView_strokePressedColor
        override fun onStrokeDisabledColorIndex(): Int = R.styleable.ShapeImageView_strokeDisabledColor
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