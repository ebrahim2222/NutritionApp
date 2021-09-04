package com.example.nutritionapp.domain.model.nutritionResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Parsed (

    @SerializedName("quantity")
    @Expose
    val quantity : Float,
    @SerializedName("measure")
    @Expose
    val measure : String,
    @SerializedName("foodMatch")
    @Expose
    val foodMatch : String,
    @SerializedName("food")
    @Expose
    val food : String,
    @SerializedName("foodId")
    @Expose
    val foodId : String,
    @SerializedName("weight")
    @Expose
    val weight : Float,
    @SerializedName("retainedWeight")
    @Expose
    val retainedWeight : Float,
    @SerializedName("nutrients")
    @Expose
    val nutrients : Nutrients,
    @SerializedName("measureURI")
    @Expose
    val measureURI : String,
    @SerializedName("status")
    @Expose
    val status : String
)