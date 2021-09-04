package com.example.nutritionapp.ui.second

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nutritionapp.data.repositoryimpl.RepositoryImp
import com.example.nutritionapp.domain.model.ingredients.Ingr
import com.example.nutritionapp.domain.model.nutritionResponse.Json4Kotlin_Base
import com.example.nutritionapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    val repositoryImp: RepositoryImp,
) : ViewModel() {
    var nutrition: Json4Kotlin_Base? = null

    val mutableStateFlow = MutableStateFlow<Resource<Json4Kotlin_Base>>(Resource.loading(null))
    fun getNutrition(ingr: Ingr) {
        viewModelScope.launch {
            try {
                nutrition = repositoryImp.api.getNutrition(
                    "47379841",
                    "d28718060b8adfd39783ead254df7f92",
                    ingr
                )
                mutableStateFlow.value = Resource.success(nutrition)

            } catch (e: Exception) {
                mutableStateFlow.value = Resource.error(e.message, nutrition)
            }
        }
    }

}