package com.wellee.jetpack.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_user")
data class User(
    @PrimaryKey
    val uid: Int = 0,

    @ColumnInfo
    val name: String,

    @ColumnInfo
    val sex: Int,

    @ColumnInfo
    val age: Int,

    @ColumnInfo
    val city: String
)
