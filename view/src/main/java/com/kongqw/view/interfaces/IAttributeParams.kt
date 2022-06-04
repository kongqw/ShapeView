package com.kongqw.view.interfaces


internal interface IAttributeParams {

    fun onAttrsId(): IntArray

    fun isGrayMode(): Int?

    fun onTextColorIndex(): Int?
    fun onTextPressedColorIndex(): Int?
    fun onTextDisableColorIndex(): Int?

    fun onCornerTypeIndex(): Int
    fun onCornerRadiusIndex(): Int

    fun onBackgroundColorOrientationIndex(): Int
    fun onBackgroundColorsIndex(): Int
    fun onBackgroundPressedColorsIndex(): Int
    fun onBackgroundDisabledIndex(): Int

    fun onStrokeWidthIndex(): Int
    fun onStrokePressedWidthIndex(): Int
    fun onStrokeDisabledWidthIndex(): Int
    fun onStrokeColorIndex(): Int
    fun onStrokePressedColorIndex(): Int
    fun onStrokeDisabledColorIndex(): Int
}