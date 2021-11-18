package com.glitchlink.lifeman2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.glitchlink.lifeman2.data.user.User
import com.glitchlink.lifeman2.data.user.UserViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val user1 = User(0, "John", 54)
        val user2 = User(0, "Richard", 63)

        // Allowed inserts in main thread only for testing purposes
        userViewModel.insertUser(user1)
        userViewModel.insertUser(user2)

        userViewModel.getAllUsers.observe(this, { users ->
            // Show Users
            Log.d("Users in DB:", users.toString())
        })


    }
}