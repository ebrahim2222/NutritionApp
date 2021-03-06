package com.example.nutritionapp.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext

data class Resource<T>(val status:Status ,val data:T? , val message: String?) {


    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String?, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }






}

