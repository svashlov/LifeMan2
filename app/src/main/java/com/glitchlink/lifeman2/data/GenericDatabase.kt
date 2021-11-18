package com.glitchlink.lifeman2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.glitchlink.lifeman2.data.user.User
import com.glitchlink.lifeman2.data.user.UserDao


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class GenericDatabase : RoomDatabase() {

    abstract fun getUserDao() : UserDao

    companion object {
        @Volatile
        private var INSTANCE : GenericDatabase? = null

        fun getDatabase(context : Context) : GenericDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GenericDatabase::class.java,
                    "lifeman2db"
                    )
                    .allowMainThreadQueries()
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}
