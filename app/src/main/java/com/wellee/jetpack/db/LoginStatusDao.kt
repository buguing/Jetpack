package com.wellee.jetpack.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoginStatusDao {

    @Query("select isLogin from tb_login_status where id = 0")
    fun queryLoginStatus(): LiveData<Boolean>

    @Insert(entity = LoginStatus::class)
    fun insertLoginStaus(status: LoginStatus)
}