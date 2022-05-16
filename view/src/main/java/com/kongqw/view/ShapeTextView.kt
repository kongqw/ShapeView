package com.kongqw.view

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatTextView
import com.kongqw.view.bean.AttributeParams
import com.kongqw.view.enums.BackgroundColorOrientation
import com.kongqw.view.enums.CornerType
import com.kongqw.view.helper.AttributeHelper
import com.kongqw.view.helper.ViewHelper
import com.kongqw.view.interfaces.IAttributeParams
import com.kongqw.view.interfaces.IBackground
import com.kongqw.view.interfaces.ICorner
import com.kongqw.view.interfaces.ITextColor
import com.kongqw.view.util.ColorUtils

class ShapeTextView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : AppCompatTextView(context, attrs, defStyleAttr), ICorner, IBackground, ITextColor {

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
        mAttributeParams.isEnabled = isEnabled
        mAttributeParams.mSystemBackgroundDrawable = background
        mAttributeParams.mSystemCurrentTextColor = currentTextColor
        clipToOutline = true
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        ViewHelper.initView(this, mAttributeParams)
        outlineProvider = ViewHelper.makeViewOutlineProvider(mAttributeParams)
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        ViewHelper.setEnabled(this, mAttributeParams, enabled)
    }


    override fun setTextDefaultColor(color: Int) {
        mAttributeParams.textColor = color
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setTextPressedColor(color: Int) {
        mAttributeParams.textPressColor = color
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setTextDisableColor(color: Int) {
        mAttributeParams.textDisableColor = color
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setCornerType(cornerType: CornerType) {
        mAttributeParams.cornerType = cornerType
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setCornerRadius(radius: Float) {
        mAttributeParams.cornerRadius = radius
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundColorOrientation(orientation: BackgroundColorOrientation) {
        mAttributeParams.backgroundColorOrientation = orientation
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundColors(colors: String) {
        mAttributeParams.backgroundColors = ColorUtils.parseColor(colors)
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundColors(vararg colors: String) {
        mAttributeParams.backgroundColors = ColorUtils.parseStringColors(colors.toList())
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundColors(@ColorInt vararg colors: Int) {
        mAttributeParams.backgroundColors = ColorUtils.parseIntColors(colors.toList())
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundColors(colors: ArrayList<String>) {
        mAttributeParams.backgroundColors = ColorUtils.parseStringColors(colors)
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundColors(colors: List<Int>) {
        mAttributeParams.backgroundColors = ColorUtils.parseIntColors(colors)
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundPressedColors(colors: String) {
        mAttributeParams.backgroundPressedColors = ColorUtils.parseColor(colors)
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundPressedColors(vararg colors: String) {
        mAttributeParams.backgroundPressedColors = ColorUtils.parseStringColors(colors.toList())
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundPressedColors(vararg colors: Int) {
        mAttributeParams.backgroundPressedColors = ColorUtils.parseIntColors(colors.toList())
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundPressedColors(colors: ArrayList<String>) {
        mAttributeParams.backgroundPressedColors = ColorUtils.parseStringColors(colors)
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundPressedColors(colors: List<Int>) {
        mAttributeParams.backgroundPressedColors = ColorUtils.parseIntColors(colors)
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundDisabledColors(colors: String) {
        mAttributeParams.backgroundDisabledColors = ColorUtils.parseColor(colors)
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundDisabledColors(vararg colors: String) {
        mAttributeParams.backgroundDisabledColors = ColorUtils.parseStringColors(colors.toList())
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundDisabledColors(vararg colors: Int) {
        mAttributeParams.backgroundDisabledColors = ColorUtils.parseIntColors(colors.toList())
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundDisabledColors(colors: ArrayList<String>) {
        mAttributeParams.backgroundDisabledColors = ColorUtils.parseStringColors(colors)
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setBackgroundDisabledColors(colors: List<Int>) {
        mAttributeParams.backgroundDisabledColors = ColorUtils.parseIntColors(colors)
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setStrokeWidth(strokeWidth: Float) {
        mAttributeParams.strokeWidth = strokeWidth
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setStrokePressedWidth(strokeWidth: Float) {
        mAttributeParams.strokePressedWidth = strokeWidth
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setStrokeDisabledWidth(strokeWidth: Float) {
        mAttributeParams.strokeDisabledWidth = strokeWidth
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setStrokeColor(color: Int) {
        mAttributeParams.strokeColor = color
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setStrokePressedColor(color: Int) {
        mAttributeParams.strokePressedColor = color
        ViewHelper.initView(this, mAttributeParams)
    }

    override fun setStrokeDisabledColor(color: Int) {
        mAttributeParams.strokeDisabledColor = color
        ViewHelper.initView(this, mAttributeParams)
    }
}