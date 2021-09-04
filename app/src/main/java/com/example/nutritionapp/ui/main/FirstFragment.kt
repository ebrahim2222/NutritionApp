package com.example.nutritionapp.ui.main

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.FragmentFirstBinding
import com.example.nutritionapp.domain.model.ingredients.Ingr
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FirstFragment : Fragment() {
    private val TAG = "FirstFragment"
    lateinit var binding: FragmentFirstBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(inflater)
        val view = binding.root

        setTextColor()


        val bundle = Bundle()
        binding.analyseButton.setOnClickListener {
            val data: String = binding.dataField.text.toString()
            val split = data.split(",")
            Log.d(TAG, "onCreateView: " + data)
            val ingr = Ingr(split)
            bundle.putParcelable("data", ingr)
            navController.navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    private fun setTextColor() {
        val text: String =
            "Enter an ingredient list for what you are cooking. like \"1 cup rice, 10 oz chickpeas\", etc."
        val spannableStringBuilder = SpannableStringBuilder(text)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                //Toast.makeText(requireContext(),"Clicked",Toast.LENGTH_LONG).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.color = ContextCompat.getColor(requireContext(), R.color.spannable)
                ds.isUnderlineText = false
            }
        }
        spannableStringBuilder.setSpan(clickableSpan, 56, 85, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.firstExplain.text = spannableStringBuilder
        binding.firstExplain.movementMethod = LinkMovementMethod.getInstance()
    }

}