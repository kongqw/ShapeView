package com.kongqw.shapeview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kongqw.shapeview.databinding.ActivityTestShapeViewBinding

class TestShapeViewActivity : AppCompatActivity() {

    companion object {

        @JvmStatic
        fun startActivity(context: Context?) {
            context?.startActivity(Intent(context, TestShapeViewActivity::class.java))
        }
    }

    private lateinit var mViewBinding : ActivityTestShapeViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityTestShapeViewBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)
    }
}