package com.example.androidsandbox

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("SELECT * FROM User")
    fun getAllLive() : LiveData<List<User>>

    @Query("SELECT * FROM User")
    fun getAll() : List<User>

    @Query("SELECT * FROM User where id = :id")
    fun get(id: Int) : User
}