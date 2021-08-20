package com.hswizy.roomdemo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author: hsw
 * @date: 2021/8/19
 * @desc:
 */
@Entity(tableName = "table_user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "user_name", defaultValue = "new_user")
    var userName: String? = null,

    val password: String? = null,

    val age: Int? = null
) {
    override fun toString(): String {
        return "$id,$userName,$password,$age"
    }
}