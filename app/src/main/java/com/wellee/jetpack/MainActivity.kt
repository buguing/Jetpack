package com.wellee.jetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.wellee.jetpack.db.UserDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UserDatabase.getInstance(this)
            .getLoginStatusDao()
            .queryLoginStatus()
            .observe(this, Observer {
                if (it != true) {
                    Navigation.findNavController(this, R.id.nav_host_main)
                        .navigate(R.id.nav_to_login)
                }
            })
    }
}
