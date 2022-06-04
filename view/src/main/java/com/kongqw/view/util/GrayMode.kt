package com.kongqw.view.util

import android.content.Context
import android.content.SharedPreferences

object GrayMode {

    private const val SP_NAME = "SP_NAME_GRAY_MODE"
    private const val SP_KEY_GRAY_MODE = "SP_KEY_GRAY_MODE"
    private val mSP: SharedPreferences? = null

    @Synchronized
    private fun getSPInstance(context: Context): SharedPreferences {
        return mSP ?: context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
    }

    /**
     * 全局设置黑白模式
     */
    @JvmStatic
    fun isGrayMode(context: Context, isGrayMode: Boolean) {
        try {
            getSPInstance(context).edit().putBoolean(SP_KEY_GRAY_MODE, isGrayMode).apply()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 获取全局黑白模式设置
     */
    @JvmStatic
    fun isGrayMode(context: Context): Boolean {
        return try {
            getSPInstance(context).getBoolean(SP_KEY_GRAY_MODE, false)
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}