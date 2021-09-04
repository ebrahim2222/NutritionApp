package com.example.nutritionapp.data.repositoryimpl

import com.example.nutritionapp.data.source.remote.API
import com.example.nutritionapp.domain.model.ingredients.Ingr
import com.example.nutritionapp.domain.model.nutritionResponse.Json4Kotlin_Base
import com.example.nutritionapp.domain.repository.Repository
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    val api:API
    ) : Repository {
    override suspend fun getNutrition(appID: String, appKey: String, ingr: Ingr): Json4Kotlin_Base {
        return api.getNutrition(appID,appKey,ingr)
    }
}