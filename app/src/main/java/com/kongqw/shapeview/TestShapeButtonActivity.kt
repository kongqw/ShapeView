package com.kongqw.shapeview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kongqw.shapeview.databinding.ActivityTestShapeButtonBinding

class TestShapeButtonActivity : AppCompatActivity() {

    companion object {

        @JvmStatic
        fun startActivity(context: Context?) {
            context?.startActivity(Intent(context, TestShapeButtonActivity::class.java))
        }
    }

    private lateinit var mViewBinding : ActivityTestShapeButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityTestShapeButtonBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)
    }
}