package com.example.nutritionapp.domain.model.nutritionResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class RIBF (

	@SerializedName("label")
	@Expose
	val label : String,
	@SerializedName("quantity")
	@Expose
	val quantity : Float,
	@SerializedName("unit")
	@Expose
	val unit : String
)