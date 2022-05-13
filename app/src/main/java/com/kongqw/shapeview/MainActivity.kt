package com.kongqw.shapeview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kongqw.shapeview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mViewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)


        mViewBinding.cb.setOnCheckedChangeListener { compoundButton, b ->
            mViewBinding.shapeButton.isEnabled = !b
        }


        mViewBinding.shapeButton.setOnClickListener {
            Toast.makeText(applicationContext, "shapeButton", Toast.LENGTH_SHORT).show()
        }


        mViewBinding.stv1.setOnClickListener {
            Toast.makeText(applicationContext, "stv1", Toast.LENGTH_SHORT).show()
        }

        mViewBinding.shapeButton.setOnLongClickListener {
            Toast.makeText(applicationContext, "setOnLongClickListener", Toast.LENGTH_SHORT).show()
            true
        }
    }
}