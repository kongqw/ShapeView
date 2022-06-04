package com.kongqw.view.interfaces

import com.kongqw.view.enums.CornerType


internal interface ICorner {

    fun setCornerType(cornerType: CornerType)

    fun setCornerRadius(radius: Float)
}