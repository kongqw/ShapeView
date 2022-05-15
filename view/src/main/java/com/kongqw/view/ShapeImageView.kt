package com.kongqw.view

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatImageView
import com.kongqw.view.bean.AttributeParams
import com.kongqw.view.enums.BackgroundColorOrientation
import com.kongqw.view.enums.CornerType
import com.kongqw.view.helper.AttributeHelper
import com.kongqw.view.helper.ViewHelper
import com.kongqw.view.interfaces.IAttributeParams
import com.kongqw.view.interfaces.IBackground
import com.kongqw.view.interfaces.ICorner
import com.kongqw.view.util.ColorUtils

class ShapeImageView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : AppCompatImageView(context, attrs, defStyleAttr), ICorner, IBackground {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null)

    private var mAttributeParams: AttributeParams = AttributeHelper.obtainStyledAttributes(context, attrs, object : IAttributeParams {
        override fun onAttrsId(): IntArray = R.styleable.ShapeImageView

        override fun onTextColorIndex(): Int? = null
        override fun onTextPressedColorIndex(): Int? = null
        override fun onTextDisableColorIndex(): Int? = null

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
        mAttributeParams.isEnabled = isEnabled
        mAttributeParams.mSystemBackgroundDrawable = background
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