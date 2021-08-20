package com.hswizy.roomdemo.dao

import androidx.room.*
import com.hswizy.roomdemo.entity.ProductEntity

/**
 * @author: hsw
 * @date: 2021/8/20
 * @desc:
 */
@Dao
interface ProductDao {

    @Insert
    suspend fun insert(entity: ProductEntity)

    @Update
    suspend fun update(entity: ProductEntity)

    @Delete
    suspend fun delete(entity: ProductEntity)

    @Query("select * from table_product where id=:id")
    suspend fun queryById(id: Long): ProductEntity?

    @Query("select * from table_product")
    suspend fun queryAll(): List<ProductEntity>?

    @Query("delete from table_product")
    suspend fun deleteAll()
}
