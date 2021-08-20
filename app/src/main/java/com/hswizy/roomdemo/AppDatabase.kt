package com.hswizy.roomdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hswizy.roomdemo.dao.ProductDao
import com.hswizy.roomdemo.dao.UserDao
import com.hswizy.roomdemo.entity.ProductEntity
import com.hswizy.roomdemo.entity.UserEntity

/**
 * @author: hsw
 * @date: 2021/8/19
 * @desc:
 */

@Database(entities = [UserEntity::class, ProductEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(App.instance()).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "hsw_db"
            ).addMigrations(MIGRATION_1_2)
                .build()
        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "create table `table_product` (`id` INTEGER, `product_name` TEXT, `price` REAL, PRIMARY KEY (`id`))"
                )
            }
        }
    }

    abstract fun userDao(): UserDao

    abstract fun productDao(): ProductDao
}