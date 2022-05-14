package com.kongqw.shapeview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kongqw.shapeview.databinding.ActivityTestShapeConstraintLayoutBinding

class TestShapeConstraintLayoutActivity : AppCompatActivity() {

    companion object {

        @JvmStatic
        fun startActivity(context: Context?) {
            context?.startActivity(Intent(context, TestShapeConstraintLayoutActivity::class.java))
        }
    }

    private lateinit var mViewBinding : ActivityTestShapeConstraintLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityTestShapeConstraintLayoutBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)
    }
}