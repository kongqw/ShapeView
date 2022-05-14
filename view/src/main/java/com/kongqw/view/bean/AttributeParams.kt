package com.kongqw.view.bean

import com.kongqw.view.enums.BackgroundColorOrientation
import com.kongqw.view.enums.CornerType

class AttributeParams {

    var isEnabled: Boolean = true

    /*
     * 圆角属性
     ********************************************************************************************************************************************/
    // 圆角方向
    var cornerType: CornerType = CornerType.RECTANGLE

    // 圆角大小
    var cornerRadius: Int = 0

    /*
     * 字体颜色相关属性
     ********************************************************************************************************************************************/
    // 默认字体颜色
    var textColor: Int? = null

    // 按下字体颜色
    var textPressColor: Int? = null

    // 不可用字体颜色
    var textDisableColor: Int? = null

    /*
     * 背景颜色相关属性
     ********************************************************************************************************************************************/
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
    var strokeWidth: Int? = null
    var strokePressedWidth: Int? = null
    var strokeDisabledWidth: Int? = null
    var strokeColor: Int? = null
    var strokePressedColor: Int? = null
    var strokeDisabledColor: Int? = null

    /*
        <attr name="strokeWidth" format="dimension" />
    <attr name="strokePressedWidth" format="dimension" />
    <attr name="strokeDisabledWidth" format="dimension" />
    <!-- stroke 颜色 -->
    <attr name="strokeColor" format="color" />
    <attr name="strokePressedColor" format="color" />
    <attr name="strokeDisabledColor" format="color" />
     */
}