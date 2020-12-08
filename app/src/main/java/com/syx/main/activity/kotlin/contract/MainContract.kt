package com.syx.main.activity.kotlin.contract

import com.syx.main.activity.kotlin.base.BasePresenter
import com.syx.main.activity.kotlin.model.bean.MainBean

interface MainContract {

    interface IPresenter : BasePresenter<IView> {

        fun getNetWorkData()

    }

    interface IView {

        fun showData(list : ArrayList<MainBean.DataBean.ListBean>)

        fun showToast(message : String)

    }

}