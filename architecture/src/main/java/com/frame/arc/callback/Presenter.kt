package com.frame.arc.callback

import android.view.View


interface Presenter : View.OnClickListener {

    override fun onClick(v: View?)
    fun onClickByAny(v: View?, any: Any?)

    interface SimplePresenter : Presenter {
        override fun onClick(v: View?) {
            onClickByAny(v, null)
        }

        override fun onClickByAny(v: View?, any: Any?) {}
    }

}