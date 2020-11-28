package com.example.jetpack

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.jetpack.result
import kotlinx.android.synthetic.main.fragment_cuatro.*
import kotlinx.android.synthetic.main.fragment_result.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [cuatro.newInstance] factory method to
 * create an instance of this fragment.
 */
class cuatro : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cuatro, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment cuatro.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            cuatro().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    var num1 : Float? = null
    var num2 : Float? = null

    var navRes: NavController?= null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

        botonCalcular.setOnClickListener(this)

        navRes = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.botonCalcular)?.setOnClickListener(this)

    }

    override fun onClick(view: View){

        if(TextUtils.isEmpty(editText1.text.toString())){

            editText1.error = "Ingresa un número"
            editText1.requestFocus()
            return
        }else{
            num1 = editText1.text.toString().toFloat()
        }

        if(TextUtils.isEmpty(editText2.text.toString())){

            editText2.error = "Ingresa un número"
            editText2.requestFocus()
            return
        }else{
            num2 = editText2.text.toString().toFloat()
        }


        if (radioButton2.isChecked == true){

            when(view?.id){

                R.id.botonCalcular -> {result.text = num1?.plus(num2!!).toString()}

            }

        }else if(radioButton3.isChecked == true){

            when(view?.id){

                R.id.botonCalcular -> {result.text = num1?.minus(num2!!).toString()}

            }

        }else if(radioButton4.isChecked == true){

        when(view?.id){

            R.id.botonCalcular -> {result.text = num1?.div(num2!!).toString()}

        }

    }


    }
}