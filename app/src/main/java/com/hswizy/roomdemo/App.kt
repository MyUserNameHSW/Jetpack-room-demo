package com.hswizy.roomdemo

import android.app.Application

/**
 * @author: hsw
 * @date: 2021/8/20
 * @desc:
 */
class App: Application() {

    companion object {
        private var instance: App? = null
        fun instance(): App {
            return instance!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}