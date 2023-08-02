package com.rayhaddadcompany.moodtrackr;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


@Dao
interface UserDao {
    @Query("SELECT * FROM UserModel")
    fun getAll(): List<UserModel>

    @Query("SELECT * FROM UserModel WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<UserModel>

    @Query("SELECT * FROM UserModel WHERE nickname LIKE :nickname LIMIT 1")
    fun findByName(nickname: String): UserModel

    @Insert
    fun insertAll(vararg userModels:UserModel)

    @Delete
    fun delete(userModel:UserModel)

}