package com.example.nationalparks.util

import android.content.SharedPreferences

class MySharedPreferences (val mSharedPreferences: SharedPreferences) {


    fun putBoolean(key: String, boolean: Boolean) {
        mSharedPreferences.edit().putBoolean(key, boolean).apply()
    }

    fun getBoolean(key: String): Boolean {
        return mSharedPreferences.getBoolean(key,false)
    }
}