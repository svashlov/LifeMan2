package com.glitchlink.lifeman2.data.user

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM users ORDER BY id ASC")
    fun getAllUsers() : LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user : User)

    @Delete
    suspend fun deleteUser(user : User)

}