package com.example.nutritionapp.domain.model.nutritionResponse

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class Json4Kotlin_Base (

	@SerializedName("uri")
	@Expose
	val uri : String,
	@SerializedName("yield")
	@Expose
	val yield : Float,
	@SerializedName("calories")
	@Expose
	val calories : Int,
	@SerializedName("totalWeight")
	@Expose
	val totalWeight : Float,
	@SerializedName("dietLabels")
	@Expose
	val dietLabels : List<String>,
	@SerializedName("healthLabels")
	@Expose
	val healthLabels : List<String>,
	@SerializedName("cautions")
	@Expose
	val cautions : List<String>,
	@SerializedName("totalNutrients")
	@Expose
	val totalNutrients : TotalNutrients,
	@SerializedName("totalDaily")
	@Expose
	val totalDaily : TotalDaily,
	@SerializedName("ingredients")
	@Expose
	val ingredients : List<Ingredients>
)