package com.kongqw.shapeview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kongqw.shapeview.databinding.ActivityTestShapeTextViewBinding

class TestShapeTextViewActivity : AppCompatActivity() {

    companion object {

        @JvmStatic
        fun startActivity(context: Context?) {
            context?.startActivity(Intent(context, TestShapeTextViewActivity::class.java))
        }
    }

    private lateinit var mViewBinding : ActivityTestShapeTextViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityTestShapeTextViewBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)
    }
}