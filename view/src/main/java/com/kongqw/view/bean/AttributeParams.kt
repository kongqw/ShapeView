package com.kongqw.view.bean

import android.graphics.drawable.Drawable
import com.kongqw.view.enums.BackgroundColorOrientation
import com.kongqw.view.enums.CornerType

internal class AttributeParams {

    var isEnabled: Boolean = true

    /*
     * 黑白模式
     ********************************************************************************************************************************************/
    // 是否是黑白模式
    var isGrayMode: Boolean? = null

    /*
     * 圆角属性
     ********************************************************************************************************************************************/
    // 圆角方向
    var cornerType: CornerType = CornerType.RECTANGLE

    // 圆角大小
    var cornerRadius: Float = 0f

    /*
     * 字体颜色相关属性
     ********************************************************************************************************************************************/
    // 系统字体颜色设置
    var mSystemCurrentTextColor : Int? = null

    // 默认字体颜色
    var textColor: Int? = null

    // 按下字体颜色
    var textPressColor: Int? = null

    // 不可用字体颜色
    var textDisableColor: Int? = null

    /*
     * 背景颜色相关属性
     ********************************************************************************************************************************************/
    // 系统背景设置
    var mSystemBackgroundDrawable : Drawable? = null

    // 背景渐变色方向，默认水平
    var backgroundColorOrientation: BackgroundColorOrientation = BackgroundColorOrientation.HORIZONTAL

    // 默认背景色
    var backgroundColors: ArrayList<Int>? = null

    // 按下背景色
    var backgroundPressedColors: ArrayList<Int>? = null

    // 不可用背景色
    var backgroundDisabledColors: ArrayList<Int>? = null

    /*
     * 背景颜色相关属性
     ********************************************************************************************************************************************/
    var strokeWidth: Float? = null
    var strokePressedWidth: Float? = null
    var strokeDisabledWidth: Float? = null
    var strokeColor: Int? = null
    var strokePressedColor: Int? = null
    var strokeDisabledColor: Int? = null
}