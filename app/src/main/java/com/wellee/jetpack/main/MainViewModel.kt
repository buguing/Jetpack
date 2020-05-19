package com.wellee.jetpack.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.DiffUtil
import com.wellee.jetpack.adapter.MyAdapter
import com.wellee.jetpack.db.User
import com.wellee.jetpack.db.UserDatabase

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val diffCallback = object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.uid == newItem.uid
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    val adapter = MyAdapter(diffCallback)
    val liveList: LiveData<PagedList<User>>

    init {

        val userDao = UserDatabase.getInstance(getApplication())
            .getUserDao()

        liveList = LivePagedListBuilder(
            userDao.queryAll(),
            PagedList.Config.Builder()
                .setInitialLoadSizeHint(20)
                .setPageSize(10)
                .setEnablePlaceholders(false)
                .setPrefetchDistance(10)
                .build()
        ).build()
    }
}