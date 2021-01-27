package com.example.fadel.data.repository

import androidx.lifecycle.LiveData
import com.example.fadel.data.dao.UserDao
import com.example.fadel.data.entity.UserEntity

class UserRepositry(private val userDao: UserDao) {

    val readAllData : LiveData<List<UserEntity>> = userDao.readAllData()

    suspend fun addUser(userEntity: UserEntity){
        userDao.addUser(userEntity)
    }

    suspend fun deleteUser(userEntity: UserEntity){
        userDao.deleteUser(userEntity)
    }

    suspend fun deleteAllUser(userEntity: UserEntity){
        userDao.deleteAllUser()
    }

    suspend fun updateUser(userEntity: UserEntity){
        userDao.updateUser(userEntity)
    }

}