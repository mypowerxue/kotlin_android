package com.syx.main.activity.kotlin.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

@Suppress("UNREACHABLE_CODE", "CAST_NEVER_SUCCEEDS", "UNCHECKED_CAST")
abstract class BaseFragment<T : BasePresenter<*>> : Fragment() {

    var presenter: T? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getPresenter()
        presenter!!.attachView(this as Nothing)
        return inflater!!.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity.window.decorView.post({
            initData()
        })
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun initData()

    //获取Presenter方法
    private fun getPresenter() {
        val type: Type? = javaClass.genericSuperclass
        if (type != BaseFragment::class.java) {
            val arguments = (type as ParameterizedType).actualTypeArguments
            val tClass = arguments[0] as Class<*>
            presenter = tClass.newInstance() as T?
            return
        }
        presenter = null
    }

}
