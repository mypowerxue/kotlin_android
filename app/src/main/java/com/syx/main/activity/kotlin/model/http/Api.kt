package com.syx.main.activity.kotlin.model.http

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.syx.main.activity.kotlin.base.App
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Api {

    private var retrofit: Retrofit? = null

    private val SERVICE_ADDRESS:    String = "http://cx.connxun.com/cx-api/"

    fun <T> getInstance(c: Class<T>): T {
        if (retrofit == null) {
            synchronized(Api::class.java) {
                if (retrofit == null) {
                    initRetrofit()
                }
            }
        }
        return retrofit!!.create(c)
    }

    private fun initRetrofit() {
        retrofit = Retrofit.Builder()
                .baseUrl(SERVICE_ADDRESS)
                .client(initOkHttp())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private fun initOkHttp(): OkHttpClient {
        //创建OkHttp 并添加拦截器拦截器
        return OkHttpClient.Builder().cache(Cache(App.context!!.cacheDir, (1024 * 1024 * 100).toLong())).addNetworkInterceptor(Interceptor { chain ->
            val request = chain.request()
            val response = chain.proceed(request)
            return@Interceptor response.newBuilder().addHeader("Cache-Control", "max-age=60000").build()
        }).connectTimeout(10000, TimeUnit.MILLISECONDS).writeTimeout(10000, TimeUnit.MILLISECONDS).readTimeout(10000, TimeUnit.MILLISECONDS).build()
    }

}

