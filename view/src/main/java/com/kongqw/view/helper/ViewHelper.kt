package com.kongqw.view.helper

import android.graphics.Outline
import android.graphics.Rect
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.TextView
import com.kongqw.view.bean.AttributeParams
import com.kongqw.view.enums.Action
import com.kongqw.view.enums.BackgroundColorOrientation
import com.kongqw.view.enums.CornerType

object ViewHelper {

    fun makeViewOutlineProvider(attributeParams: AttributeParams): ViewOutlineProvider {
        return object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {

                val rect = Rect()

                val width = view?.width ?: 0
                val height = view?.height ?: 0

                when (attributeParams.cornerType) {
                    // default 全角
                    CornerType.RECTANGLE -> rect.set(0, 0, width, height)
                    // top
                    CornerType.TOP -> rect.set(0, 0, width, height + attributeParams.cornerRadius)
                    // left
                    CornerType.LEFT -> rect.set(0, 0, width + attributeParams.cornerRadius, height)
                    // right
                    CornerType.RIGHT -> rect.set(0 - attributeParams.cornerRadius, 0, width, height)
                    // bottom
                    CornerType.BOTTOM -> rect.set(0, 0 - attributeParams.cornerRadius, width, height)
                    // 圆
                    CornerType.CIRCLE -> {
                        rect.set(0, 0, width, height)
                        attributeParams.cornerRadius = if (height < width) width / 2 else height / 2
                        Log.i("StyleHelper", "makeViewOutlineProvider AttributeParams.cornerRadius = ${attributeParams.cornerRadius}")
                    }
                }
                outline?.setRoundRect(rect, attributeParams.cornerRadius.toFloat())
            }
        }
    }

    fun setOnTouchListener(view: View, attributeParams: AttributeParams) {

        view.setOnTouchListener { v, motionEvent ->
            if (view.isClickable) {
                if (view.isInEditMode) {
                    view.performClick()
                }

                when (motionEvent?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        Log.i("StyleHelper", "MotionEvent.ACTION_DOWN")
                        pressBackground(view, attributeParams)
                        pressTextColor(view, attributeParams)
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
                        initBackground(view, attributeParams)
                        initTextColor(view, attributeParams)
                    }
                }
            }
            return@setOnTouchListener false
        }
    }

    fun initView(view: View, attributeParams: AttributeParams) {
        attributeParams.isEnabled = view.isEnabled
        if (attributeParams.cornerType == CornerType.CIRCLE) {
            if (view.width < view.height) {
                attributeParams.cornerRadius = view.height / 2
            } else {
                attributeParams.cornerRadius = view.width / 2
            }
        }

        attributeParams.mSystemBackgroundDrawable = view.background
        initBackground(view, attributeParams)
//        if (view is TextView) {
//            attributeParams.textColor = view.currentTextColor
//        }
        initTextColor(view, attributeParams)
    }

    fun setEnabled(view: View, attributeParams: AttributeParams?, enabled: Boolean) {
        attributeParams ?: return
        attributeParams.isEnabled = enabled
        initBackground(view, attributeParams)
        initTextColor(view, attributeParams)
    }

    private fun initBackground(view: View, attributeParams: AttributeParams) {
        Log.i("StyleHelper", "isClickable    ${view.isClickable}")
        if (attributeParams.isEnabled) {
            // 设置背景色
            setBackground(view, attributeParams, Action.NORMAL)
        } else {
            // 被禁用
            setBackground(view, attributeParams, Action.DISABLED)
        }
    }


    private fun initTextColor(view: View, attributeParams: AttributeParams) {
        if (view !is TextView) return

        Log.i("StyleHelper", "currentTextColor = ${view.currentTextColor}")

        if (attributeParams.isEnabled) {
            attributeParams.textColor?.apply {
                view.setTextColor(this)
            }
        } else {
            // 被禁用
            // 设置背景色
            attributeParams.textDisableColor?.apply {
                view.setTextColor(this)
            }
        }
    }

    private fun pressBackground(view: View, attributeParams: AttributeParams?) {
        setBackground(view, attributeParams, Action.PRESSED)
    }

    private fun setBackground(view: View, attributeParams: AttributeParams?, action: Action) {
        attributeParams ?: return

        val customBackgroundColors = when (action) {
            Action.NORMAL -> attributeParams.backgroundColors
            Action.PRESSED -> attributeParams.backgroundPressedColors
            Action.DISABLED -> attributeParams.backgroundDisabledColors
        }
        if(null == customBackgroundColors){
            view.background = attributeParams.mSystemBackgroundDrawable
        } else {
            val orientation = when (attributeParams.backgroundColorOrientation) {
                BackgroundColorOrientation.HORIZONTAL -> GradientDrawable.Orientation.LEFT_RIGHT
                BackgroundColorOrientation.VERTICAL -> GradientDrawable.Orientation.TOP_BOTTOM
            }
            view.background = GradientDrawable(orientation, customBackgroundColors.toIntArray()).apply {

                val strokeWidth: Int = when (action) {
                    Action.NORMAL -> attributeParams.strokeWidth
                    Action.PRESSED -> attributeParams.strokePressedWidth ?: attributeParams.strokeWidth
                    Action.DISABLED -> attributeParams.strokeDisabledWidth ?: attributeParams.strokeWidth
                } ?: return@apply

                val strokeColor = when (action) {
                    Action.NORMAL -> attributeParams.strokeColor
                    Action.PRESSED -> attributeParams.strokePressedColor ?: attributeParams.strokeColor
                    Action.DISABLED -> attributeParams.strokeDisabledColor ?: attributeParams.strokeColor
                } ?: return@apply


                this.setStroke(strokeWidth, strokeColor, 0f, 0f)
                Log.i("StyleHelper", "AttributeParams.mCornerRadius = ${attributeParams.cornerRadius}")

                this.shape = GradientDrawable.RECTANGLE
                val toFloat = attributeParams.cornerRadius.toFloat()
                // 左上
                // this.cornerRadii = floatArrayOf(toFloat, toFloat, 0f, 0f, 0f, 0f, 0f, 0f)
                // 右上
                // this.cornerRadii = floatArrayOf( 0f, 0f,toFloat, toFloat, 0f, 0f, 0f, 0f)
                // 右下
                // this.cornerRadii = floatArrayOf( 0f, 0f, 0f, 0f,toFloat, toFloat, 0f, 0f)
                // zuo下
                // this.cornerRadii = floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, toFloat, toFloat)

                this.cornerRadii = when (attributeParams.cornerType) {
                    CornerType.TOP -> floatArrayOf(toFloat, toFloat, toFloat, toFloat, 0f, 0f, 0f, 0f)
                    CornerType.LEFT -> floatArrayOf(toFloat, toFloat, 0f, 0f, 0f, 0f, toFloat, toFloat)
                    CornerType.RIGHT -> floatArrayOf(0f, 0f, toFloat, toFloat, toFloat, toFloat, 0f, 0f)
                    CornerType.BOTTOM -> floatArrayOf(0f, 0f, 0f, 0f, toFloat, toFloat, toFloat, toFloat)
                    CornerType.RECTANGLE -> floatArrayOf(toFloat, toFloat, toFloat, toFloat, toFloat, toFloat, toFloat, toFloat)
                    CornerType.CIRCLE -> floatArrayOf(toFloat, toFloat, toFloat, toFloat, toFloat, toFloat, toFloat, toFloat)
                }
            }
        }
    }


    private fun pressTextColor(view: View, attributeParams: AttributeParams?) {
        if (view !is TextView) return
        attributeParams ?: return
        // 被按下
        attributeParams.textPressColor?.apply {
            view.setTextColor(this)
        }
    }
}