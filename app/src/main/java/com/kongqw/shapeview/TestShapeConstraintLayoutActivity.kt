package com.kongqw.shapeview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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


        mViewBinding.scl1.setOnClickListener {
            Toast.makeText(applicationContext,"scl1 click",Toast.LENGTH_SHORT).show()
        }
        mViewBinding.scl1.setOnLongClickListener {
            Toast.makeText(applicationContext,"scl1 long click",Toast.LENGTH_SHORT).show()
            true
        }
    }
}