package com.example.nutritionapp.ui.third

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.nutritionapp.databinding.FragmentThirdBinding
import com.example.nutritionapp.domain.model.ingredients.Ingr
import com.example.nutritionapp.domain.model.nutritionResponse.Json4Kotlin_Base
import com.example.nutritionapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import java.text.NumberFormat
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.nutritionapp.R


@AndroidEntryPoint
class ThirdFragment : Fragment() {
    lateinit var data: Ingr
    lateinit var binding: FragmentThirdBinding
    private val TAG = "ThirdFragment"
    lateinit var navController: NavController
    val thiedviewModel: ThiedviewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater)
        val view = binding.root

        getData()

        getNutritionData()

        onBackPressed()


        return view
    }

    private fun onBackPressed() {

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    navController.navigate(R.id.firstFragment)
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(requireActivity(), callback)
    }

    private fun getNutritionData() {
        thiedviewModel.getNutrition(data)
        lifecycleScope.launchWhenCreated {
            thiedviewModel.mutableStateFlow.collect {
                when (it.status) {
                    Status.SUCCESS -> {
                        val ingredients = it.data!!

                        displayData(ingredients)

                    }
                    Status.ERROR -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                        Log.d(TAG, "onCreateView: " + it.message)
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    @SuppressLint("SetTextI18n")
    private fun displayData(ingredients: Json4Kotlin_Base) {
        val numberFormat = NumberFormat.getPercentInstance()
        numberFormat.maximumFractionDigits = 1

        binding.caloriesValue.text = ingredients.calories.toString()
        binding.totalFatValue1.text =
            if (ingredients.totalNutrients.fAT != null) Math.round(ingredients.totalNutrients.fAT.quantity)
                .toString() + " " + ingredients.totalNutrients.fAT.unit else "-"

        binding.totalFatValue.text =
            if (ingredients.totalDaily.fAT != null) Math.round(((ingredients.totalDaily.fAT.quantity / 100) * 100))
                .toString() + ingredients.totalDaily.fAT.unit else "-"

        binding.saturatedValue1.text =
            if (ingredients.totalNutrients.fASAT != null) Math.round(ingredients.totalNutrients.fASAT.quantity)
                .toString() + " " + ingredients.totalNutrients.fASAT.unit else "-"

        binding.saturatedValue.text =
            if (ingredients.totalDaily.fASAT != null) Math.round(((ingredients.totalDaily.fASAT.quantity / 100) * 100))
                .toString() + ingredients.totalDaily.fASAT.unit else "-"

        binding.cholesterolValue1.text =
            if (ingredients.totalNutrients.cHOLE != null) Math.round(ingredients.totalNutrients.cHOLE.quantity)
                .toString() + " " + ingredients.totalNutrients.cHOLE.unit else "-"

        binding.cholesterolValue2.text =
            if (ingredients.totalDaily.cHOLE != null) Math.round(((ingredients.totalDaily.cHOLE.quantity / 100) * 100))
                .toString() + ingredients.totalDaily.cHOLE.unit else "-"

        binding.sadiumValue1.text =
            if (ingredients.totalNutrients.nA != null) Math.round(ingredients.totalNutrients.nA.quantity)
                .toString() + " " + ingredients.totalNutrients.nA.unit else "-"

        binding.sadiumValue2.text =
            if (ingredients.totalDaily.nA != null) Math.round((ingredients.totalDaily.nA.quantity / 100) * 100)
                .toString() + ingredients.totalDaily.nA.unit else "-"

        binding.totalCarbohydrateValue.text =
            if (ingredients.totalDaily.cHOCDF != null) Math.round(((ingredients.totalDaily.cHOCDF.quantity / 100) * 100))
                .toString() + ingredients.totalDaily.cHOCDF.unit else "-"

        binding.dietaryFibervalue2.text =
            if (ingredients.totalNutrients.fIBTG != null) Math.round(ingredients.totalNutrients.fIBTG.quantity)
                .toString() + " " + ingredients.totalNutrients.fIBTG.unit else "-"

        binding.dietaryFibervalue3.text =
            if (ingredients.totalDaily.fIBTG != null) Math.round(((ingredients.totalDaily.fIBTG.quantity / 100) * 100))
                .toString() + ingredients.totalDaily.fIBTG.unit else "-"

        /*  binding.totalSugervalue.text =
              ((ingredients.totalDaily.sUGAR.quantity/100)*100).toString() + ingredients.totalDaily.sUGAR.unit

         */
        binding.proteinValue1.text =
            if (ingredients.totalNutrients.pROCNT != null) Math.round(ingredients.totalNutrients.pROCNT.quantity)
                .toString() + " " + ingredients.totalNutrients.pROCNT.unit else "-"

        binding.proteinValue2.text =
            if (ingredients.totalDaily.pROCNT != null) Math.round(((ingredients.totalDaily.pROCNT.quantity / 100) * 100))
                .toString() + ingredients.totalDaily.pROCNT.unit else "-"


        binding.vitaminValue1.text =
            if (ingredients.totalNutrients.vITB12 != null) Math.round(ingredients.totalNutrients.vITB12.quantity)
                .toString() + " " + ingredients.totalNutrients.vITB12.unit else "-"

        binding.vitaminValue2.text =
            if (ingredients.totalDaily.vITB12 != null) Math.round(((ingredients.totalDaily.vITB12.quantity / 100) * 100))
                .toString() + ingredients.totalDaily.vITB12.unit else "-"


        binding.calclumValue1.text =
            if (ingredients.totalNutrients.cA != null) Math.round(ingredients.totalNutrients.cA.quantity)
                .toString() + " " + ingredients.totalNutrients.cA.unit else "-"
        binding.calclumValue2.text =
            if (ingredients.totalDaily.cA != null) Math.round((ingredients.totalDaily.cA.quantity / 100) * 100)
                .toString() + ingredients.totalDaily.cA.unit else "_"

        binding.ironValue1.text =
            if (ingredients.totalNutrients.fE != null) Math.round(ingredients.totalNutrients.fE.quantity)
                .toString() + " " + ingredients.totalNutrients.fE.unit else "-"
        binding.ironValue2.text =
            if (ingredients.totalDaily.fE != null) Math.round(((ingredients.totalDaily.fE.quantity / 100) * 100))
                .toString() + ingredients.totalDaily.fE.unit else "-"

        binding.potassiumValue1.text =
            if (ingredients.totalNutrients.k != null) Math.round(ingredients.totalNutrients.k.quantity)
                .toString() + " " + ingredients.totalNutrients.k.unit else "-"
        binding.potassiumValue2.text =
            if (ingredients.totalNutrients.k != null) Math.round(((ingredients.totalDaily.k.quantity / 100) * 100))
                .toString() + ingredients.totalDaily.k.unit else "-"

    }

    private fun getData() {
        data = arguments?.getParcelable<Ingr>("data")!!
    }


}