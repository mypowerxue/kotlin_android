package com.syx.main.activity.kotlin.base

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

@Suppress("UNREACHABLE_CODE", "CAST_NEVER_SUCCEEDS", "UNCHECKED_CAST")
abstract class BaseActivity<T : BasePresenter<*>> : AppCompatActivity(){

    var presenter : T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        App.context = this
        initView()
        getPresenter()
        //Activity渲染完毕后 在加载数据
        window.decorView.post {
            initData()
        }
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun initData()

    //获取Presenter方法---------------------------------------
    private fun getPresenter() {
        val type: Type? = javaClass.genericSuperclass
        if (type != BaseActivity::class.java) {
            val arguments = (type as ParameterizedType).actualTypeArguments
            val tClass = arguments[0] as Class<*>
            presenter = tClass.newInstance() as T?
            return
        }
        presenter = null
    }

    //Toast--------------------
    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    //startActivity----------
    fun showActivity(c: Class<*>) {
        val intent = Intent(this, c)
        startActivity(intent)
    }


}
