package com.rayhaddadcompany.moodtrackr

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserModel(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "nickname") val nickname: String,
    @ColumnInfo(name = "language_selected") val languageSelected: String,

    )