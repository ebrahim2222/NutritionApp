package com.example.nutritionapp.domain.model.nutritionResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Nutrients (

    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.RIBF")
    @Expose
    val rIBF : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.VITD")
    @Expose
    val vITD : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.THIA")
    @Expose
    val tHIA : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.FAPU")
    @Expose
    val fAPU : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.NIA")
    @Expose
    val nIA : RIBF,
    @SerializedName("ENERC_KCAL")
    @Expose
    val eNERC_KCAL : eNERC_KCAL,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.FASAT")
    @Expose
    val fASAT : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.VITC")
    @Expose
    val vITC : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.PROCNT")
    @Expose
    val pROCNT : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.CHOLE")
    @Expose
    val cHOLE : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.FAMS")
    @Expose
    val fAMS : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.CHOCDF")
    @Expose
    val cHOCDF : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.FAT")
    @Expose
    val fAT : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.VITB6A")
    @Expose
    val vITB6A : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.VITB12")
    @Expose
    val vITB12 : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.WATER")
    @Expose
    val wATER : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.K")
    @Expose
    val k : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.P")
    @Expose
    val p : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.NA")
    @Expose
    val nA : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.ZN")
    @Expose
    val zN : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.CA")
    @Expose
    val cA : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.MG")
    @Expose
    val mG : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.FE")
    @Expose
    val fE : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.FOLFD")
    @Expose
    val fOLFD : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.FOLAC")
    @Expose
    val fOLAC : RIBF,
    @SerializedName("com.example.nutritionapp.domain.model.nutritionResponse.FOLDFE")
    @Expose
    val fOLDFE : RIBF
)