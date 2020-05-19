package com.wellee.jetpack

import android.app.Application
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.blankj.utilcode.util.Utils
import com.wellee.jetpack.workmanager.MyWorker

class App : Application() {

    private val listWorker = OneTimeWorkRequest.Builder(MyWorker::class.java).build()
    val workFlag = "init list data"

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)

        //work 任务
        WorkManager.getInstance(this)
            .beginUniqueWork(workFlag, ExistingWorkPolicy.REPLACE, listWorker)
            .enqueue()
    }
}