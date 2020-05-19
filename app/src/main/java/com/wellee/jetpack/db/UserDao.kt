package com.wellee.jetpack.db

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*

@Dao
interface UserDao {

    @Query("select * from tb_user where uid=0")
    fun query(): LiveData<User>

    @Query("select * from tb_user")
    fun queryAll(): DataSource.Factory<Int, User>

    @Insert(entity = User::class, onConflict= OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: MutableList<User>)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)
}