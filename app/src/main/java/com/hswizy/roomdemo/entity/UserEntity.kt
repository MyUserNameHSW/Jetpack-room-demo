package com.hswizy.roomdemo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author: hsw
 * @date: 2021/8/19
 * @desc:
 */
//自定义表名，如果没自定义就使用类名作为表名
@Entity(tableName = "table_user")
data class UserEntity(
    //设置主键，id自增
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    //自定义字段名称何默认值，不自定则使用变量名称
    @ColumnInfo(name = "user_name", defaultValue = "new_user")
    var userName: String? = null,

    val password: String? = null,

    val age: Int? = null
) {
    override fun toString(): String {
        return "$id,$userName,$password,$age"
    }
}