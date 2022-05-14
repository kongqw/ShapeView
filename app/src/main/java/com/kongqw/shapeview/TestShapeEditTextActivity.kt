package com.kongqw.shapeview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kongqw.shapeview.databinding.ActivityTestShapeEditTextBinding

class TestShapeEditTextActivity : AppCompatActivity() {

    companion object {

        @JvmStatic
        fun startActivity(context: Context?) {
            context?.startActivity(Intent(context, TestShapeEditTextActivity::class.java))
        }
    }

    private lateinit var mViewBinding : ActivityTestShapeEditTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityTestShapeEditTextBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)
    }
}