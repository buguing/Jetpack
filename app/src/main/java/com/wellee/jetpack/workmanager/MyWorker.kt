package com.wellee.jetpack.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.wellee.jetpack.db.User
import com.wellee.jetpack.db.UserDatabase

class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    private val userDao = UserDatabase.getInstance(context)
        .getUserDao()
    private val userList = mutableListOf<User>()

    override fun doWork(): Result {
        for (i in 0 until 200) {
            userList.add(User(i, "user $i", i%2, i%10, ""))
        }
        userDao.insert(userList)
        return Result.success()
    }
}
