package com.example.appgym.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllUser()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }

    /*suspend fun showData(email: String){
        userDao.showData(email)
    }

    suspend fun getIdU(email: String){
        userDao.getIdU(email)
    }*/

}