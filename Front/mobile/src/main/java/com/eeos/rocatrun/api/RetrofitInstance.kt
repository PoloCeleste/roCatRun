package com.eeos.rocatrun.api

import android.content.Context
import com.eeos.rocatrun.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private lateinit var client: Retrofit

    fun initialize(context: Context) {
        val apiAddress = context.getString(R.string.api_address) + "/"
        client = Retrofit.Builder()
            .baseUrl(apiAddress)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getInstance(): Retrofit {
        return client
    }
}
