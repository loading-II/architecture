package com.frame.arc.ui.fragment

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.frame.arc.BaseApp
import com.frame.arc.callback.Presenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

abstract class BaseFragment : Fragment(), Presenter.SimplePresenter {
    private var mFragmentProvider: ViewModelProvider? = null
    private var mActivityProvider: ViewModelProvider? = null
    private val mApplicationProvider: ViewModelProvider by lazy {
        ViewModelProvider(
            this.mActivity.application as BaseApp, getAppFactory(mActivity)
        )
    }
    private lateinit var mActivity: Activity
    protected val TAG: String by lazy { this::class.java.simpleName }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = requireActivity()
        arguments?.let {
            initArgs(it)
        }
    }

    protected abstract fun initArgs(bundle: Bundle)

    protected fun doLaunch(block: suspend CoroutineScope.() -> Unit): Job {
        return MainScope().launch {
            block()
        }
    }

    protected fun <T : ViewModel> getFragmentScopeViewModel(modelClass: Class<T>): T {
        if (mFragmentProvider == null) {
            mFragmentProvider = ViewModelProvider(this)
        }
        return mFragmentProvider!!.get(modelClass)
    }

    protected fun <T : ViewModel> getActivityScopeViewModel(modelClass: Class<T>): T {
        if (mActivityProvider == null) {
            mActivityProvider = ViewModelProvider(requireActivity())
        }
        return mActivityProvider!!.get(modelClass)
    }

    protected fun <T : ViewModel> getApplicationScopeViewModel(modelClass: Class<T>): T {
        /*if (mApplicationProvider == null) {
            mApplicationProvider = ViewModelProvider(
                this.mActivity.application as BaseApp, getAppFactory(mActivity)
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