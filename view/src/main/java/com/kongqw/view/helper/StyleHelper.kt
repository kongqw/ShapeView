package com.kongqw.view.helper

import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.TextView
import androidx.core.content.res.getColorOrThrow
import com.kongqw.view.R
import com.kongqw.view.helper.enums.BackgroundColorOrientation
import com.kongqw.view.helper.enums.BackgroundColorType
import com.kongqw.view.helper.enums.CornerType

object StyleHelper {


    /**
     * 获取自定义属性
     */
    fun initAttribute(context: Context?, attrs: AttributeSet?, isEnabled: Boolean): StyleParams {
        val styleParams = StyleParams()
        styleParams.isEnabled = isEnabled
        // 圆角
        context?.obtainStyledAttributes(attrs, R.styleable.CustomCorner)?.apply {
            // 圆角类型
            getInt(R.styleable.CustomCorner_cornerType, 0).also { type ->
                styleParams.cornerType = when (type) {
                    0 -> CornerType.RECTANGLE
                    1 -> CornerType.TOP
                    2 -> CornerType.LEFT
                    3 -> CornerType.RIGHT
                    4 -> CornerType.BOTTOM
                    5 -> CornerType.CIRCLE
                    else -> CornerType.RECTANGLE
                }
            }
            // 圆角
            styleParams.mCornerRadius = getDimensionPixelSize(R.styleable.CustomCorner_cornerRadius, 0)
            recycle()
        }
        // 背景
        context?.obtainStyledAttributes(attrs, R.styleable.CustomBackground)?.apply {
            // 背景颜色类型
            getInt(R.styleable.CustomBackground_backgroundColorType, 0).also { type ->
                styleParams.backgroundColorType = when (type) {
                    0 -> BackgroundColorType.SOLID
                    1 -> BackgroundColorType.GRADIENT
                    else -> BackgroundColorType.SOLID
                }
            }
            // 背景渐变色方向
            getInt(R.styleable.CustomBackground_backgroundColorOrientation, 0).also { type ->
                styleParams.backgroundColorOrientation = when (type) {
                    0 -> BackgroundColorOrientation.HORIZONTAL
                    1 -> BackgroundColorOrientation.VERTICAL
                    else -> BackgroundColorOrientation.HORIZONTAL
                }
            }
            // 默认颜色
            getColorOrNull(this, R.styleable.CustomBackground_backgroundColor1)?.apply { styleParams.backgroundColors.add(this) }
            getColorOrNull(this, R.styleable.CustomBackground_backgroundColor2)?.apply { styleParams.backgroundColors.add(this) }
            getColorOrNull(this, R.styleable.CustomBackground_backgroundColor3)?.apply { styleParams.backgroundColors.add(this) }
            getColorOrNull(this, R.styleable.CustomBackground_backgroundColor4)?.apply { styleParams.backgroundColors.add(this) }
            getColorOrNull(this, R.styleable.CustomBackground_backgroundColor5)?.apply { styleParams.backgroundColors.add(this) }
            // 按下颜色
            getColorOrNull(this, R.styleable.CustomBackground_backgroundPressColor1)?.apply { styleParams.backgroundPressColors.add(this) }
            getColorOrNull(this, R.styleable.CustomBackground_backgroundPressColor2)?.apply { styleParams.backgroundPressColors.add(this) }
            getColorOrNull(this, R.styleable.CustomBackground_backgroundPressColor3)?.apply { styleParams.backgroundPressColors.add(this) }
            getColorOrNull(this, R.styleable.CustomBackground_backgroundPressColor4)?.apply { styleParams.backgroundPressColors.add(this) }
            getColorOrNull(this, R.styleable.CustomBackground_backgroundPressColor5)?.apply { styleParams.backgroundPressColors.add(this) }
            // 不可用颜色
            getColorOrNull(this, R.styleable.CustomBackground_backgroundDisableColor1)?.apply { styleParams.backgroundDisableColors.add(this) }
            getColorOrNull(this, R.styleable.CustomBackground_backgroundDisableColor2)?.apply { styleParams.backgroundDisableColors.add(this) }
            getColorOrNull(this, R.styleable.CustomBackground_backgroundDisableColor3)?.apply { styleParams.backgroundDisableColors.add(this) }
            getColorOrNull(this, R.styleable.CustomBackground_backgroundDisableColor4)?.apply { styleParams.backgroundDisableColors.add(this) }
            getColorOrNull(this, R.styleable.CustomBackground_backgroundDisableColor5)?.apply { styleParams.backgroundDisableColors.add(this) }

            recycle()
        }
        // 字体颜色
        context?.obtainStyledAttributes(attrs, R.styleable.CustomGradientTextColor)?.apply {
            // 按下颜色
            getColorOrNull(this, R.styleable.CustomGradientTextColor_pressColor)?.apply { styleParams.pressColor = this }
            // 不可用颜色
            getColorOrNull(this, R.styleable.CustomGradientTextColor_disableColor)?.apply { styleParams.disableColor = this }
            recycle()
        }

        return styleParams
    }


    private fun getColorOrNull(typedArray: TypedArray, index: Int): Int? {
        return try {
            typedArray.getColorOrThrow(index)
        } catch (e: Exception) {
            Log.i("StyleHelper", "getColorOrNull   error   ${e.message}")
            null
        }
    }


    fun makeViewOutlineProvider(styleParams: StyleParams): ViewOutlineProvider {
        return object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {

                val rect = Rect()

                val width = view?.width ?: 0
                val height = view?.height ?: 0

                when (styleParams.cornerType) {
                    // default 全角
                    CornerType.RECTANGLE -> rect.set(0, 0, width, height)
                    // top
                    CornerType.TOP -> rect.set(0, 0, width, height + styleParams.mCornerRadius)
                    // left
                    CornerType.LEFT -> rect.set(0, 0, width + styleParams.mCornerRadius, height)
                    // right
                    CornerType.RIGHT -> rect.set(0 - styleParams.mCornerRadius, 0, width, height)
                    // bottom
                    CornerType.BOTTOM -> rect.set(0, 0 - styleParams.mCornerRadius, width, height)
                    // 圆
                    CornerType.CIRCLE -> {
                        rect.set(0, 0, width, height)
                        styleParams.mCornerRadius = if (height < width) width / 2 else height / 2
                    }
                }
                outline?.setRoundRect(rect, styleParams.mCornerRadius.toFloat())
            }
        }
    }


    fun initView(view: View, styleParams: StyleParams) {
        view.setOnTouchListener { v, motionEvent ->
            if (view.isClickable) {
                when (motionEvent?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        Log.i("StyleHelper", "MotionEvent.ACTION_DOWN")
                        pressBackground(view, styleParams)
                        pressTextColor(view, styleParams)
                    }
                    MotionEvent.ACTION_MOVE -> {
                        Log.i("StyleHelper", "MotionEvent.ACTION_MOVE")
                    }
//                MotionEvent.ACTION_UP -> {
//                    Log.i("StyleHelper", "MotionEvent.ACTION_UP  v.isLongClickable = ${v.isLongClickable}")
//                    initBackground(view, styleParams)
//
//                    if (v.isEnabled && v.isClickable) v.performClick()
//                }
//                MotionEvent.ACTION_CANCEL -> {
//                    Log.i("StyleHelper", "MotionEvent.ACTION_CANCEL")
//                }
                    MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                        Log.i("StyleHelper", "MotionEvent.ACTION_CANCEL")
                        initBackground(view, styleParams)
                        initTextColor(view, styleParams)
                    }
                }
            }
            return@setOnTouchListener false
        }


        initBackground(view, styleParams)
        if (view is TextView) {
            styleParams.textColor = view.currentTextColor
        }
        initTextColor(view, styleParams)

    }

    private fun initBackground(view: View, styleParams: StyleParams) {
        Log.i("StyleHelper", "isClickable    ${view.isClickable}")
        if (styleParams.isEnabled) {
            // 设置背景色
            val backgroundColors = styleParams.backgroundColors
            Log.i("StyleHelper", "backgroundColors.size = ${backgroundColors.size}")
            when {
                1 == backgroundColors.size -> view.background = ColorDrawable(backgroundColors.first())
                1 < backgroundColors.size -> {
                    val orientation = when (styleParams.backgroundColorOrientation) {
                        BackgroundColorOrientation.HORIZONTAL -> GradientDrawable.Orientation.LEFT_RIGHT
                        BackgroundColorOrientation.VERTICAL -> GradientDrawable.Orientation.TOP_BOTTOM
                    }
                    view.background = GradientDrawable(orientation, backgroundColors.toIntArray())
                }
            }
        } else {
            // 被禁用

            // 设置背景色
            val backgroundDisableColors = styleParams.backgroundDisableColors
            Log.i("StyleHelper", "backgroundDisableColors.size = ${backgroundDisableColors.size}")
            when {
                1 == backgroundDisableColors.size -> view.background = ColorDrawable(backgroundDisableColors.first())
                1 < backgroundDisableColors.size -> {
                    val orientation = when (styleParams.backgroundColorOrientation) {
                        BackgroundColorOrientation.HORIZONTAL -> GradientDrawable.Orientation.LEFT_RIGHT
                        BackgroundColorOrientation.VERTICAL -> GradientDrawable.Orientation.TOP_BOTTOM
                    }
                    view.background = GradientDrawable(orientation, backgroundDisableColors.toIntArray())
                }
            }
        }
    }

    private fun initTextColor(view: View, styleParams: StyleParams) {
        if (view !is TextView) return

        Log.i("StyleHelper", "currentTextColor = ${view.currentTextColor}")

        if (styleParams.isEnabled) {
            styleParams.textColor?.apply {
                view.setTextColor(this)
            }
        } else {
            // 被禁用
            // 设置背景色
            styleParams.disableColor?.apply {
                view.setTextColor(this)
            }
        }
    }

    fun setEnabled(view: View, styleParams: StyleParams?, enabled: Boolean) {
        styleParams ?: return
        styleParams.isEnabled = enabled
        initBackground(view, styleParams)
        initTextColor(view, styleParams)
    }

    private fun pressBackground(view: View, styleParams: StyleParams?) {
        styleParams ?: return
        // 被按下
        val backgroundPressColors = styleParams.backgroundPressColors
        Log.i("StyleHelper", "backgroundPressColors.size = ${backgroundPressColors.size}")
        when {
            1 == backgroundPressColors.size -> view.background = ColorDrawable(backgroundPressColors.first())
            1 < backgroundPressColors.size -> {
                val orientation = when (styleParams.backgroundColorOrientation) {
                    BackgroundColorOrientation.HORIZONTAL -> GradientDrawable.Orientation.LEFT_RIGHT
                    BackgroundColorOrientation.VERTICAL -> GradientDrawable.Orientation.TOP_BOTTOM
                }
                view.background = GradientDrawable(orientation, backgroundPressColors.toIntArray())
            }
        }
    }


    private fun pressTextColor(view: View, styleParams: StyleParams?) {
        if (view !is TextView) return
        styleParams ?: return
        // 被按下
        styleParams.pressColor?.apply {
            view.setTextColor(this)
        }
    }
}