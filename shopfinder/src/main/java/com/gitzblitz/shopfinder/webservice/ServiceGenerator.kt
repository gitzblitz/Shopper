package com.gitzblitz.shopfinder.webservice

import android.util.Log
import com.gitzblitz.shopfinder.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

// return singleton of webserviceImpl
object ServiceGenerator {

    // get retrofit adapter


   private fun getRetrofitAdapter(baseURL: String): Retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .client(provideOkHttpClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()


    private fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(provideHttpLoggingInterceptor())
        .build()


    fun provideWebService(): Webservice = getRetrofitAdapter(
        "http://www.mocky.io/v2/5b7e8bc03000005c0084c210/"
    ).create(Webservice::class.java)


    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor { msg ->
            Log.d("WebServiceImpl", msg)
        }
        interceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return interceptor
    }
}