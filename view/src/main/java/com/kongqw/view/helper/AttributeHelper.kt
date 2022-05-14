package com.kongqw.view.helper

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import androidx.core.content.res.getColorOrThrow
import androidx.core.content.res.getDimensionPixelSizeOrThrow
import androidx.core.content.res.getStringOrThrow
import com.kongqw.view.bean.AttributeParams
import com.kongqw.view.enums.BackgroundColorOrientation
import com.kongqw.view.enums.CornerType
import com.kongqw.view.interfaces.IAttributeParams

object AttributeHelper {


    fun obtainStyledAttributes(context: Context?, attrs: AttributeSet?, iAttributeParams: IAttributeParams): AttributeParams {
        val attributeParams = AttributeParams()
        // 字体颜色
        context?.obtainStyledAttributes(attrs, iAttributeParams.onAttrsId())?.apply {
            /*
             * 获取圆角
             ********************************************************************************************************************************************/
            // 圆角类型
            getInt(iAttributeParams.onCornerTypeIndex(), -1).also { type ->
                attributeParams.cornerType = when (type) {
                    0 -> CornerType.TOP
                    1 -> CornerType.LEFT
                    2 -> CornerType.RIGHT
                    3 -> CornerType.BOTTOM
                    4 -> CornerType.RECTANGLE
                    5 -> CornerType.CIRCLE
                    else -> CornerType.RECTANGLE
                }
            }
            // 圆角
            attributeParams.cornerRadius = getDimensionPixelSize(iAttributeParams.onCornerRadiusIndex(), 0)
            /*
             * 获取字体颜色
             ********************************************************************************************************************************************/
            // 默认颜色
            getColorOrNull(this, iAttributeParams.onTextColorIndex())?.apply { attributeParams.textColor = this }
            // 按下颜色
            getColorOrNull(this, iAttributeParams.onTextPressedColorIndex())?.apply { attributeParams.textPressColor = this }
            // 不可用颜色
            getColorOrNull(this, iAttributeParams.onTextDisableColorIndex())?.apply { attributeParams.textDisableColor = this }

            /*
             * 获取背景相关
             ********************************************************************************************************************************************/
            // 背景渐变色方向
            getInt(iAttributeParams.onBackgroundColorOrientationIndex(), 0).also { type ->
                attributeParams.backgroundColorOrientation = when (type) {
                    0 -> BackgroundColorOrientation.HORIZONTAL
                    1 -> BackgroundColorOrientation.VERTICAL
                    else -> BackgroundColorOrientation.HORIZONTAL
                }
            }
            // 默认背景颜色
            getColorsOrNull(this, iAttributeParams.onBackgroundColorsIndex())?.apply { attributeParams.backgroundColors = this }
            // 按下背景颜色
            getColorsOrNull(this, iAttributeParams.onBackgroundPressedColorsIndex())?.apply { attributeParams.backgroundPressedColors = this }
            // 不可用背景颜色
            getColorsOrNull(this, iAttributeParams.onBackgroundDisabledIndex())?.apply { attributeParams.backgroundDisabledColors = this }


            /*
             * Stroke 相关
             ********************************************************************************************************************************************/
            getDimensionPixelSizeOrThrow(this, iAttributeParams.onStrokeWidthIndex())?.apply { attributeParams.strokeWidth = this }
            getDimensionPixelSizeOrThrow(this, iAttributeParams.onStrokePressedWidthIndex())?.apply { attributeParams.strokePressedWidth = this }
            getDimensionPixelSizeOrThrow(this, iAttributeParams.onStrokeDisabledWidthIndex())?.apply { attributeParams.strokeDisabledWidth = this }

            getColorOrNull(this, iAttributeParams.onStrokeColorIndex())?.apply { attributeParams.strokeColor = this }
            getColorOrNull(this, iAttributeParams.onStrokePressedColorIndex())?.apply { attributeParams.strokePressedColor = this }
            getColorOrNull(this, iAttributeParams.onStrokeDisabledColorIndex())?.apply { attributeParams.strokeDisabledColor = this }
            recycle()
        }


        return attributeParams
    }


    private fun getColorOrNull(typedArray: TypedArray, index: Int?): Int? {
        index ?: return null
        return try {
            typedArray.getColorOrThrow(index)
        } catch (e: Exception) {
            Log.i("StyleHelper", "getColorOrNull   error   ${e.message}")
            null
        }
    }

    private fun getColorsOrNull(typedArray: TypedArray, index: Int): ArrayList<Int>? {
        return try {
            val colors = ArrayList<Int>()
            typedArray.getStringOrThrow(index).split(",").forEach { color ->
                try {
                    colors.add(Color.parseColor(color))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            when (colors.size) {
                0 -> {
                    colors.add(Color.TRANSPARENT)
                    colors.add(Color.TRANSPARENT)
//                    colors.add(Color.parseColor("#00000000"))
//                    colors.add(Color.parseColor("#00000000"))
                }
                1 -> {
                    // 如果只设置了一个颜色，则在添加一个同样的颜色到数组中（着色统一使用 GradientDrawable ，如果颜色只有1个，会报错）
                    colors.firstOrNull()?.apply { colors.add(this) }
                }
            }
            colors
        } catch (e: Exception) {
            Log.i("StyleHelper", "getColorsOrNull   error   ${e.message}")
            null
        }
    }

    private fun getDimensionPixelSizeOrThrow(typedArray: TypedArray, index: Int): Int? {
        return try {
            typedArray.getDimensionPixelSizeOrThrow(index)
        } catch (e: Exception) {
            Log.i("StyleHelper", "getDimensionPixelSizeOrThrow   error   ${e.message}")
            null
        }
    }
}