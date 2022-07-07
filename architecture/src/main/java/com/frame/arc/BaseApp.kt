package com.frame.arc

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import kotlin.properties.Delegates

/**
 * base application
 */
open class BaseApp : MultiDexApplication(), ViewModelStoreOwner {

    companion object {
        private var xApp: Application by Delegates.notNull<Application>()
        fun getInstance() = xApp
    }

    private lateinit var viewModelStore: ViewModelStore
    private val mApplicationProvider: ViewModelProvider by lazy {
        ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(this)
        )
    }

    override fun onCreate() {
        super.onCreate()
        xApp = this

        MultiDex.install(this)
        viewModelStore = ViewModelStore()

    }

    override fun onTerminate() {
        super.onTerminate()
    }


    override fun getViewModelStore(): ViewModelStore {
        return viewModelStore
    }

    protected fun <T : ViewModel> getApplicationScopeViewModel(modelClass: Class<T>): T {
        /*if (mApplicationProvider == null) {
            mApplicationProvider = ViewModelProvider(
                this, ViewModelProvider.AndroidViewModelFactory.getInstance(this)
            )
        }*/
        return mApplicationProvider[modelClass]
    }

}