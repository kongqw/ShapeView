package com.kongqw.shapeview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kongqw.shapeview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mViewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)

        // ShapeButton
        mViewBinding.sbtnShapeButton.setOnClickListener {
            TestShapeButtonActivity.startActivity(this)
        }
        // ShapeEditText
        mViewBinding.sbtnShapeEditText.setOnClickListener {
            TestShapeEditTextActivity.startActivity(this)
        }
        // ShapeImageButton
        mViewBinding.sbtnShapeImageButton.setOnClickListener {
            TestShapeImageButtonActivity.startActivity(this)
        }
        // ShapeImageView
        mViewBinding.sbtnShapeImageView.setOnClickListener {
            TestShapeImageViewActivity.startActivity(this)
        }
        // ShapeTextView
        mViewBinding.sbtnShapeTextView.setOnClickListener {
            TestShapeTextViewActivity.startActivity(this)
        }
        // ShapeView
        mViewBinding.sbtnShapeView.setOnClickListener {
            TestShapeViewActivity.startActivity(this)
        }
        // ShapeConstraintLayout
        mViewBinding.sbtnShapeConstraintLayout.setOnClickListener {
            TestShapeConstraintLayoutActivity.startActivity(this)
        }

//        mViewBinding.testtv.setOnClickListener {
//            mViewBinding.testtv.text = "老长了老长了老长了老长了老长了老长了老长了老长了老长了老长了老长了"
//        }

//
//        mViewBinding.cb.setOnCheckedChangeListener { compoundButton, b ->
//            mViewBinding.shapeButton.isEnabled = !b
//        }
//
//
//        mViewBinding.shapeButton.setOnClickListener {
//            Toast.makeText(applicationContext, "shapeButton", Toast.LENGTH_SHORT).show()
//        }
//
//
//        mViewBinding.stv1.setOnClickListener {
//            Toast.makeText(applicationContext, "stv1", Toast.LENGTH_SHORT).show()
//        }
//
//        mViewBinding.shapeButton.setOnLongClickListener {
//            Toast.makeText(applicationContext, "setOnLongClickListener", Toast.LENGTH_SHORT).show()
//            true
//        }
    }
}