package com.kongqw.view.util

import android.graphics.Color

internal object ColorUtils {

    fun parseColor(colors: String?): ArrayList<Int>? {
        val colorList = ArrayList<Int>()
        colors?.split(",")?.forEach { color ->
            try {
                colorList.add(Color.parseColor(color))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (colorList.isNotEmpty()) {
            return colorList
        }
        return null
    }

    fun parseColor(color: Int?): ArrayList<Int>? {
        color ?: return null
        val colorList = ArrayList<Int>()
        try {
            colorList.add(color)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        if (colorList.isNotEmpty()) {
            return colorList
        }
        return null
    }

    fun parseStringColors(colors: List<String>): ArrayList<Int>? {
        val colorList = ArrayList<Int>()
        colors.forEach { color ->
            try {
                parseColor(color)?.apply {
                    colorList.addAll(this)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (colorList.isNotEmpty()) {
            return colorList
        }
        return null
    }

    fun parseIntColors(colors: List<Int>?): ArrayList<Int>? {
        colors ?: return null
        val colorList = ArrayList<Int>()
        colorList.addAll(colors)
        return colorList
    }
}