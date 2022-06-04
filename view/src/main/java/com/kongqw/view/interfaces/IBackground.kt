package com.kongqw.view.interfaces

import androidx.annotation.ColorInt
import com.kongqw.view.enums.BackgroundColorOrientation


internal interface IBackground {

    fun setBackgroundColorOrientation(orientation: BackgroundColorOrientation)

    fun setBackgroundColors(colors: String)
    fun setBackgroundColors(vararg colors: String)
    fun setBackgroundColors(vararg colors: Int)
    fun setBackgroundColors(colors: ArrayList<String>)
    fun setBackgroundColors(colors: List<Int>)

    fun setBackgroundPressedColors(colors: String)
    fun setBackgroundPressedColors(vararg colors: String)
    fun setBackgroundPressedColors(vararg colors: Int)
    fun setBackgroundPressedColors(colors: ArrayList<String>)
    fun setBackgroundPressedColors(colors: List<Int>)

    fun setBackgroundDisabledColors(colors: String)
    fun setBackgroundDisabledColors(vararg colors: String)
    fun setBackgroundDisabledColors(vararg colors: Int)
    fun setBackgroundDisabledColors(colors: ArrayList<String>)
    fun setBackgroundDisabledColors(colors: List<Int>)

    fun setStrokeWidth(strokeWidth: Float)
    fun setStrokePressedWidth(strokeWidth: Float)
    fun setStrokeDisabledWidth(strokeWidth: Float)

    fun setStrokeColor(@ColorInt color: Int)
    fun setStrokePressedColor(@ColorInt color: Int)
    fun setStrokeDisabledColor(@ColorInt color: Int)
}