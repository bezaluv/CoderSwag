package com.milleb.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.milleb.coderswag.R
import com.milleb.coderswag.Utilities.EXTRA_CATEGORY

class productsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
       val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        println(categoryType)
    }
}
