package com.kongqw.view.helper

import com.kongqw.view.helper.enums.*

class StyleParams {

    var isEnabled: Boolean = true

    // 圆角方向
    var cornerType: CornerType = CornerType.RECTANGLE

    // 圆角大小
    var mCornerRadius: Int = 0


    // 背景颜色类型，默认纯色
    var backgroundColorType: BackgroundColorType = BackgroundColorType.SOLID

    // 背景渐变色方向，默认水平
    var backgroundColorOrientation: BackgroundColorOrientation = BackgroundColorOrientation.HORIZONTAL

    // 默认颜色
    val backgroundColors = arrayListOf<Int>()

    // 按下颜色
    val backgroundPressColors = arrayListOf<Int>()

    // 不可用颜色
    val backgroundDisableColors = arrayListOf<Int>()


    // 字体默认颜色
    var textColor: Int? = null

    // 字体按下颜色
    var pressColor: Int? = null

    // 字体不可用颜色
    var disableColor: Int? = null
}