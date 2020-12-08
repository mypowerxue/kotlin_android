package com.syx.main.activity.kotlin.model.service

import com.syx.main.activity.kotlin.model.bean.MainBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {

    @GET("gift/getlist")
    fun getMainData(
            @Query("page") page:String,
            @Query("length") length:String

    ): Observable<MainBean>?
}