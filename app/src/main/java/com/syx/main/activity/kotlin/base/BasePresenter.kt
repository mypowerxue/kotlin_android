package com.syx.main.activity.kotlin.base

interface BasePresenter <in T> {

    //获取Presenter方法
    fun attachView(t : T)

    //关闭Presenter方法
    fun detachView()

}
