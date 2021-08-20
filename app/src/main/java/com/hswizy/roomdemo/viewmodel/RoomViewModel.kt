package com.hswizy.roomdemo.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.hswizy.roomdemo.App
import com.hswizy.roomdemo.AppDatabase
import com.hswizy.roomdemo.dao.UserDao
import com.hswizy.roomdemo.entity.ProductEntity
import com.hswizy.roomdemo.entity.UserEntity
import kotlinx.coroutines.launch
import java.util.*

/**
 * @author: hsw
 * @date: 2021/8/20
 * @desc:
 */
class RoomViewModel constructor(application: Application): AndroidViewModel(application), LifecycleObserver {
    private val userDao by lazy {
        AppDatabase.getInstance().userDao()
    }

    private val productDao by lazy {
        AppDatabase.getInstance().productDao()
    }


    var listLiveData = MutableLiveData<List<UserEntity>?>()

    var productLiveData = MutableLiveData<List<ProductEntity>>()

    init {
        queryAll()
        queryProductAll()
    }



    fun insert() {
        viewModelScope.launch {
            val randInt = Random().nextInt(100)
            val userEntity = UserEntity(userName = "name-$randInt", age = randInt, password = "password$randInt")
            userDao.insert(userEntity)
            queryAll()
        }
    }

    fun updateFirst() {
        viewModelScope.launch {
            val list = userDao.queryAll()
            if (!list.isNullOrEmpty()) {
                val randInt = Random().nextInt(100)
                val userEntity = list.first()
                userEntity.userName = "changeName-$randInt"
                userDao.update(userEntity)
                queryAll()
            }
        }
    }

    fun deleteLast() {
        viewModelScope.launch {
            val list = userDao.queryAll()
            if (!list.isNullOrEmpty()) {
                val randInt = Random().nextInt(100)
                val userEntity = list.last()
                userEntity.userName = "changeName-$randInt"
                userDao.delete(userEntity)
                queryAll()
            }
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            userDao.deleteAll()
            productDao.deleteAll()
            queryAll()
            queryProductAll()
        }
    }

    fun queryAll() {
        viewModelScope.launch {
            listLiveData.value = userDao.queryAll()
        }
    }


    fun insertProduct() {
        viewModelScope.launch {
            val randInt = Random().nextInt(100)
            val productEntity = ProductEntity(productName = "name-$randInt", price = randInt.toFloat(),)
            productDao.insert(productEntity)
            queryProductAll()
        }
    }

    fun queryProductAll() {
        viewModelScope.launch {
            productLiveData.value = productDao.queryAll()
        }
    }
}