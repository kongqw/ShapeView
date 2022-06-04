package com.kongqw.view.util

import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.view.View
import com.kongqw.view.bean.AttributeParams

internal class GrayModeUtils(val view: View, attributeParams: AttributeParams) {

    private val mPaint = Paint()

    // 标记时候是黑白模式
    private var isGrayMode: Boolean = false

    init {
        val colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(0f)
        mPaint.colorFilter = ColorMatrixColorFilter(colorMatrix)

        // 全局黑白设置
        isGrayMode = GrayMode.isGrayMode(view.context.applicationContext)
        // 单个控件的黑白化设置
        attributeParams.isGrayMode?.apply {
            isGrayMode = isGrayMode.or(this)
        }
    }

    /**
     * 是否是黑白模式
     */
    fun isGrayMode(isGrayMode: Boolean) {
        this.isGrayMode = isGrayMode
        view.invalidate()
    }

    fun saveLayer(canvas: Canvas?) {
        if (isGrayMode) canvas?.saveLayer(null, mPaint)
    }

    fun restore(canvas: Canvas?) {
        if (isGrayMode) canvas?.restore()
    }
}