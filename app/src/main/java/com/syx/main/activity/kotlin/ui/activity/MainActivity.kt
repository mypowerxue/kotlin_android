package com.syx.main.activity.kotlin.ui.activity

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import com.syx.main.activity.kotlin.R
import com.syx.main.activity.kotlin.base.App.Companion.context
import com.syx.main.activity.kotlin.base.BaseActivity
import com.syx.main.activity.kotlin.contract.MainContract
import com.syx.main.activity.kotlin.model.bean.MainBean
import com.syx.main.activity.kotlin.presenter.MainPresenter
import com.syx.main.activity.kotlin.ui.adapter.MainAdapter

class MainActivity : BaseActivity<MainPresenter>(), MainContract.IView, View.OnClickListener {

    var mRecycler: RecyclerView? = null
    var mStartActivity: Button? = null
    var mAdapter: MainAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        mRecycler = findViewById(R.id.main_recycler)
        mStartActivity = findViewById(R.id.main_startActivity)
    }

    override fun initData() {
        presenter!!.attachView(this)
        presenter!!.getNetWorkData()

        mStartActivity!!.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.main_startActivity -> super.showActivity(LoginActivity::class.java)
        }
    }

    override fun showData(list: ArrayList<MainBean.DataBean.ListBean>) {
        mAdapter = MainAdapter(list)
        mRecycler!!.layoutManager = LinearLayoutManager(context)
        mRecycler!!.adapter = mAdapter
    }
}
