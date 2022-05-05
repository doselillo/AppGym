package com.example.appgym.data

import androidx.lifecycle.LiveData
import androidx.room.*


//data acces object to access the user table
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User) //suspend function for use with coroutines

    @Query("SELECT * FROM user_table ORDER BY idU ASC")
    fun readAllUser(): LiveData<List<User>>

    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT emailU FROM user_table where emailU = :email")
    suspend fun showData(email: String): String

}


