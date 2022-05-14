package com.kongqw.view.interfaces


interface IAttributeParams {

    fun onAttrsId(): IntArray

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