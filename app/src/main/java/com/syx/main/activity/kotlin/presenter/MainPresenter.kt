package com.syx.main.activity.kotlin.presenter

import com.syx.main.activity.kotlin.contract.MainContract
import com.syx.main.activity.kotlin.model.bean.MainBean
import com.syx.main.activity.kotlin.model.http.Api
import com.syx.main.activity.kotlin.model.service.MainService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainPresenter : MainContract.IPresenter {

    private var view: MainContract.IView? = null

    override fun getNetWorkData() {

        var page = "2"

        var length = "8"

        Api.getInstance(MainService::class.java)
                .getMainData(page,length)!!
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<MainBean> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(t: MainBean) {
                        view!!.showToast("我特么会Kotlin了！")
                        view!!.showData(t.getData()!!.list as ArrayList<MainBean.DataBean.ListBean>)
                    }

                    override fun onError(e: Throwable) {
                        view!!.showToast(e.message.toString())
                    }

                })
    }

    override fun attachView(view: MainContract.IView) {
        this.view = view
    }



    override fun detachView() {
        this.view = null
    }

}