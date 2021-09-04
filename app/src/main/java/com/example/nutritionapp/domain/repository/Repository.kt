package com.example.nutritionapp.domain.repository

import com.example.nutritionapp.domain.model.ingredients.Ingr
import com.example.nutritionapp.domain.model.nutritionResponse.Json4Kotlin_Base

interface Repository {
    suspend fun getNutrition(appID:String,  appKey:String, ingr: Ingr): Json4Kotlin_Base
}