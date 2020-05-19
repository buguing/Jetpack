package com.wellee.jetpack.login

import android.app.Application
import android.os.SystemClock
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.ToastUtils
import com.wellee.jetpack.db.LoginStatus
import com.wellee.jetpack.db.UserDatabase
import kotlin.concurrent.thread

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val username = ObservableField<String>()
    val password = ObservableField<String>()

    val loginOk = MutableLiveData<Boolean>()

    fun login() {
        ToastUtils.showShort("点击了登录按钮")
        thread {
            UserDatabase.getInstance(getApplication())
                .getLoginStatusDao()
                .insertLoginStaus(LoginStatus(isLogin = true))
        }
        SystemClock.sleep(500)

        loginOk.value = true
    }
}