package com.example.nutritionapp.domain.model.nutritionResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class TotalDaily (

    @SerializedName("ENERC_KCAL")
    @Expose
    val eNERC_KCAL : RIBF,
    @SerializedName("FAT")
    @Expose
    val fAT : RIBF,
    @SerializedName("FASAT")
    @Expose
    val fASAT : RIBF,
    @SerializedName("FAMS")
    @Expose
    val fAMS : RIBF,
    @SerializedName("FAPU")
    @Expose
    val fAPU : RIBF,
    @SerializedName("CHOCDF")
    @Expose
    val cHOCDF : RIBF,
    @SerializedName("FIBTG")
    @Expose
    val fIBTG : RIBF,
    @SerializedName("SUGAR")
    @Expose
    val sUGAR : RIBF,
    @SerializedName("PROCNT")
    @Expose
    val pROCNT : RIBF,
    @SerializedName("CHOLE")
    @Expose
    val cHOLE : RIBF,
    @SerializedName("NA")
    @Expose
    val nA : RIBF,
    @SerializedName("CA")
    @Expose
    val cA : RIBF,
    @SerializedName("MG")
    @Expose
    val mG : RIBF,
    @SerializedName("K")
    @Expose
    val k : RIBF,
    @SerializedName("FE")
    @Expose
    val fE : RIBF,
    @SerializedName("ZN")
    @Expose
    val zN : RIBF,
    @SerializedName("P")
    @Expose
    val p : RIBF,
    @SerializedName("VITA_RAE")
    @Expose
    val vITA_RAE : RIBF,
    @SerializedName("VITC")
    @Expose
    val vITC : RIBF,
    @SerializedName("THIA")
    @Expose
    val tHIA : RIBF,
    @SerializedName("RIBF")
    @Expose
    val rIBF : RIBF,
    @SerializedName("NIA")
    @Expose
    val nIA : RIBF,
    @SerializedName("VITB6A")
    @Expose
    val vITB6A : RIBF,
    @SerializedName("FOLDFE")
    @Expose
    val fOLDFE : RIBF,
    @SerializedName("FOLFD")
    @Expose
    val fOLFD : RIBF,
    @SerializedName("FOLAC")
    @Expose
    val fOLAC : RIBF,
    @SerializedName("VITB12")
    @Expose
    val vITB12 : RIBF,
    @SerializedName("VITD")
    @Expose
    val vITD : RIBF,
    @SerializedName("TOCPHA")
    @Expose
    val tOCPHA : RIBF,
    @SerializedName("VITK1")
    @Expose
    val vITK1 : RIBF,
    @SerializedName("WATER")
    @Expose
    val wATER : RIBF
)