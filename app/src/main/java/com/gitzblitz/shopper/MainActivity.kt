package com.gitzblitz.shopper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gitzblitz.shopfinder.interfaces.WebServiceFacade

class MainActivity : AppCompatActivity() {
    val service by lazy { WebServiceFacade() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCities()
    }

    fun getCities() {

        service.getCities().forEach {
            Log.d("MAIN", it.name)
        }
    }
}
