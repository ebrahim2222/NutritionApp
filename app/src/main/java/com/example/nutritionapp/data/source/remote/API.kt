package com.example.nutritionapp.data.source.remote

import com.example.nutritionapp.domain.model.ingredients.Ingr
import com.example.nutritionapp.domain.model.nutritionResponse.Json4Kotlin_Base
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface API {
    @POST("/api/nutrition-details")
    suspend fun getNutrition(@Query("app_id") appID:String , @Query("app_key") appKey:String ,@Body ingr: Ingr):Json4Kotlin_Base

}