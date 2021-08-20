package com.hswizy.roomdemo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author: hsw
 * @date: 2021/8/20
 * @desc:
 */
@Entity(tableName = "table_product")
data class ProductEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    @ColumnInfo(name = "product_name")
    val productName: String? = null,

    val price: Float? = null
) {
    override fun toString(): String {
        return "$id, $productName, $price"
    }
}
