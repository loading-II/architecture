package com.frame.arc.ui.activity

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.frame.arc.BaseApp
import kotlinx.coroutines.*

open class BaseActivity : AppCompatActivity() {
    protected val TAG by lazy { this::class.java.simpleName }
    private var mActivityProvider: ViewModelProvider? = null

    private val mApplicationProvider: ViewModelProvider by lazy {
        ViewModelProvider(
            this.applicationContext as BaseApp, getAppFactory(this)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
    }

    protected fun doLaunch(block: suspend CoroutineScope.() -> Unit): Job {
        return MainScope().launch {
            block()
        }
    }

    protected fun <T : ViewModel> getActivityScopeViewModel(modelClass: Class<T>): T {
        if (mActivityProvider == null) {
            mActivityProvider = ViewModelProvider(this)
        }
        return mActivityProvider!!.get(modelClass)
    }

    protected fun <T : ViewModel> getApplicationScopeViewModel(modelClass: Class<T>): T {
        /*if (mApplicationProvider == null) {
            mApplicationProvider = ViewModelProvider(
                this.applicationContext as BaseApp, getAppFactory(this)
            )
        }*/
        return mApplicationProvider[modelClass]
    }

    private fun getAppFactory(activity: Activity): ViewModelProvider.Factory {
        val application = checkApplication(activity)
        return ViewModelProvider.AndroidViewModelFactory.getInstance(application)
    }

    private fun checkApplication(activity: Activity): Application {
        return activity.application
            ?: throw IllegalStateException(
                "Your activity/fragment is not yet attached to "
                        + "Application. You can't request ViewModel before onCreate call."
            )
    }

}