package com.kongqw.shapeview

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kongqw.shapeview.databinding.ActivityTestShapeTextViewBinding
import com.kongqw.view.enums.BackgroundColorOrientation
import com.kongqw.view.enums.CornerType

class TestShapeTextViewActivity : AppCompatActivity() {

    companion object {

        @JvmStatic
        fun startActivity(context: Context?) {
            context?.startActivity(Intent(context, TestShapeTextViewActivity::class.java))
        }
    }

    private lateinit var mViewBinding: ActivityTestShapeTextViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityTestShapeTextViewBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)


        mViewBinding.stvTest.apply {

            setCornerType(CornerType.TOP)
            setCornerRadius(10f)

            setStrokeWidth(30f)
            setStrokeColor(Color.RED)

            setStrokePressedWidth(30f)
            setStrokePressedColor(Color.BLUE)

            setTextDefaultColor(Color.CYAN)
            setTextPressedColor(Color.WHITE)

            setBackgroundColorOrientation(BackgroundColorOrientation.HORIZONTAL)
//            setBackgroundColors("#123456,#987654,#ABCEDF")
//            setBackgroundColors("#123456,#987654", "#ABCEDF")
            setBackgroundColors(Color.parseColor("#123456"), Color.parseColor("#987654"), Color.parseColor("#ABCEDF"))

            setBackgroundPressedColors(Color.RED, Color.BLUE)
        }
    }
}