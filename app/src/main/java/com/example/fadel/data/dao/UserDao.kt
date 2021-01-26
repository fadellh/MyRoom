package com.example.fadel.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.fadel.data.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: UserEntity)

    @Update
    suspend fun updateUser(user: UserEntity)

    @Query(value = "SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData() : LiveData<List<UserEntity>>

}