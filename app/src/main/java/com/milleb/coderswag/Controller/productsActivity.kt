package com.milleb.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.milleb.coderswag.Adapters.productsAdapter
import com.milleb.coderswag.R
import com.milleb.coderswag.Services.DataService
import com.milleb.coderswag.Utilities.EXTRA_CATEGORY
import com.milleb.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*

class productsActivity : AppCompatActivity() {

    lateinit var adapter : productsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
       val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = productsAdapter(this, DataService.getProducts(categoryType)) {product ->

            val productDetailIntent = Intent(this, productDetailActivity::class.java)
            productDetailIntent.putExtra(EXTRA_PRODUCT, product)
            startActivity(productDetailIntent)
        }

       var spanCount = 2
       val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManager
        productListView.adapter = adapter

    }
}
