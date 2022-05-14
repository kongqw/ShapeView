package com.kongqw.shapeview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kongqw.shapeview.databinding.ActivityTestShapeImageViewBinding

class TestShapeImageViewActivity : AppCompatActivity() {

    companion object {

        @JvmStatic
        fun startActivity(context: Context?) {
            context?.startActivity(Intent(context, TestShapeImageViewActivity::class.java))
        }
    }

    private lateinit var mViewBinding : ActivityTestShapeImageViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityTestShapeImageViewBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)
    }
}