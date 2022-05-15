package com.kongqw.view.interfaces

import com.kongqw.view.enums.CornerType


interface ICorner {

    fun setCornerType(cornerType: CornerType)

    fun setCornerRadius(radius: Float)
}