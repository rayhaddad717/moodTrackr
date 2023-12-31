package com.rayhaddadcompany.moodtrackr

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserModel::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}