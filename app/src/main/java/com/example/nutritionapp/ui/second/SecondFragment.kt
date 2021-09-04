package com.example.nutritionapp.ui.second

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.FragmentSecondBinding
import com.example.nutritionapp.domain.model.ingredients.Ingr
import com.example.nutritionapp.domain.model.nutritionResponse.Ingredients
import com.example.nutritionapp.domain.model.nutritionResponse.Parsed
import com.example.nutritionapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class SecondFragment : Fragment() {
    private val TAG = "SecondFragment"
    lateinit var binding: FragmentSecondBinding
    lateinit var data: Ingr
    lateinit var navController: NavController
    lateinit var job: Job
    val secondViewModel: SecondViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater)
        val view = binding.root

        getData()


        getNutritionData()


        binding.calculate.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("data", data)
            navController.navigate(R.id.action_secondFragment_to_thirdFragment, bundle)

        }

        return view
    }

    private fun getNutritionData() {
        secondViewModel.getNutrition(data)
        job = lifecycleScope.launchWhenCreated {
            secondViewModel.mutableStateFlow.collect {
                when (it.status) {
                    Status.SUCCESS -> {
                        val ingredients = it.data!!.ingredients
                        for (e in ingredients) {
                            displayTable(e)
                        }

                        // Log.d(TAG, "onCreateView: "+ingredients)
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

    override fun onStop() {
        super.onStop()
        job.cancel()
    }

    private fun getData() {
        data = arguments?.getParcelable<Ingr>("data")!!
        Log.d(TAG, "getData: " + data)
    }

    @SuppressLint("SetTextI18n", "WrongConstant")
    private fun displayTable(ingredients: Ingredients) {
        val layoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.MATCH_PARENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )
        val tableParams = TableLayout.LayoutParams(
            TableLayout.LayoutParams.WRAP_CONTENT,
            TableLayout.LayoutParams.WRAP_CONTENT,
            1f
        )
        for (e in ingredients.parsed) {
            val tableRow = TableRow(requireContext())
            val qty = TextView(requireContext())
            val unit = TextView(requireContext())
            val calories = TextView(requireContext())
            val food = TextView(requireContext())
            val weight = TextView(requireContext())

            tableRow.layoutParams = layoutParams

            qty.text = e.quantity.toInt().toString()
            qty.gravity = Gravity.CENTER
            // qty.layoutParams = tableParams

            unit.text = e.measure
            unit.gravity = Gravity.CENTER

            // unit.layoutParams = tableParams


            food.text = e.foodMatch
            food.gravity = Gravity.CENTER

            //unit.layoutParams = tableParams

            calories.text = e.nutrients.eNERC_KCAL.quantity.toInt()
                .toString() + " " + e.nutrients.eNERC_KCAL.unit
            calories.gravity = Gravity.CENTER

            // calories.layoutParams = tableParams

            weight.text = e.weight.toInt().toString() + " " + "g"
            weight.gravity = Gravity.CENTER

            // weight.layoutParams = tableParams

            tableRow.addView(qty)
            tableRow.addView(unit)
            tableRow.addView(food)
            tableRow.addView(calories)
            tableRow.addView(weight)


            binding.addTable.addView(tableRow)

        }
    }

}