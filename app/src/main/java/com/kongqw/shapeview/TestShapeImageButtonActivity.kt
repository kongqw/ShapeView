package com.kongqw.shapeview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kongqw.shapeview.databinding.ActivityTestShapeImageButtonBinding

class TestShapeImageButtonActivity : AppCompatActivity() {

    companion object {

        @JvmStatic
        fun startActivity(context: Context?) {
            context?.startActivity(Intent(context, TestShapeImageButtonActivity::class.java))
        }
    }

    private lateinit var mViewBinding : ActivityTestShapeImageButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityTestShapeImageButtonBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)
    }
}