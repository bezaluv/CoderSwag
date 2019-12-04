package com.milleb.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.milleb.coderswag.Model.Product
import com.milleb.coderswag.R
import com.milleb.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_detail.*

class productDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        val resourceId = resources.getIdentifier(product.image, "drawable", packageName)
        detailImageView.setImageResource(resourceId)
        detailProductName.text = product.title
        detailProductPrice.text = product.price
    }
}
