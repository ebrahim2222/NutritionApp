package com.example.nutritionapp.domain.model.nutritionResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Ingredients (

	@SerializedName("text")
	@Expose
	val text : String,
	@SerializedName("parsed")
	@Expose
	val parsed : List<Parsed>
)