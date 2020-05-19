package com.wellee.jetpack.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_login_status")
data class LoginStatus(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    @ColumnInfo
    val isLogin: Boolean
)