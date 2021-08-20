package com.hswizy.roomdemo.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hswizy.roomdemo.entity.UserEntity

/**
 * @author: hsw
 * @date: 2021/8/20
 * @desc:
 */
@Dao
interface UserDao {
    @Insert
    suspend fun insert(userEntity: UserEntity)

    @Update
    suspend fun update(userEntity: UserEntity)

    @Delete
    suspend fun delete(userEntity: UserEntity)

    @Query("select * from table_user")
    suspend fun queryAll(): List<UserEntity>

    @Query("select * from table_user where id=:id")
    suspend fun queryById(id: Long): UserEntity?

    @Query("delete from table_user")
    suspend fun deleteAll()
}