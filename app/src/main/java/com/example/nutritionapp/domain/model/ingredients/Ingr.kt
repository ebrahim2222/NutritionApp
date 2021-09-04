package com.example.nutritionapp.domain.model.ingredients

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ingr(
    val ingr:List<String>?=null
):Parcelable

