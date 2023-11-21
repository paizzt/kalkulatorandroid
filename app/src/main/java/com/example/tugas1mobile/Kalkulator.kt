package com.example.tugas1mobile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import java.text.DecimalFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Kalkulator.newInstance] factory method to
 * create an instance of this fragment.
 */

class Kalkulator : Fragment() {

    val ADDITION: Char = '+'
    val SUBTRACTION: Char = '-'
    val MULTIPLICATION: Char = '*'
    val DIVISION: Char = '/'
    val PERCENT: Char = '%'
    var currentSymbol: Char = ' '// Variabel ini dapat diubah, sesuaikan dengan kebutuhan Anda
    private var firstValue: Double = Double.NaN
    private var secondValue: Double = 0.0
    private lateinit var inputDisplay: TextView
    private lateinit var outputDisplay: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.kalkulator, container, false)

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val decimalFormat = DecimalFormat("#.##")
        inputDisplay = view.findViewById(R.id.input)
        outputDisplay= view.findViewById(R.id.output)
        val button0: MaterialButton = view.findViewById(R.id.btn0)
        val button1: MaterialButton = view.findViewById(R.id.btn1)
        val button2: MaterialButton = view.findViewById(R.id.btn2)
        val button3: MaterialButton = view.findViewById(R.id.btn3)
        val button4: MaterialButton = view.findViewById(R.id.btn4)
        val button5: MaterialButton = view.findViewById(R.id.btn5)
        val button6: MaterialButton = view.findViewById(R.id.btn6)
        val button7: MaterialButton = view.findViewById(R.id.btn7)
        val button8: MaterialButton = view.findViewById(R.id.btn8)
        val button9: MaterialButton = view.findViewById(R.id.btn9)
        val buttonAdd: MaterialButton = view.findViewById(R.id.add)
        val buttonSub: MaterialButton = view.findViewById(R.id.subtract)
        val buttonDivide: MaterialButton = view.findViewById(R.id.division)
        val buttonDot: MaterialButton = view.findViewById(R.id.btnPoint)
        val buttonMultiply: MaterialButton = view.findViewById(R.id.multiply)
        val buttonClear: MaterialButton = view.findViewById(R.id.clear)
        val buttonClearAll: MaterialButton = view.findViewById(R.id.clearAll)
        val buttonEqual: MaterialButton = view.findViewById(R.id.equal)
        val buttonPercent: MaterialButton = view.findViewById(R.id.percent)

        button0.setOnClickListener { inputDisplay.text = "${inputDisplay.text}0" }
        button1.setOnClickListener { inputDisplay.text = "${inputDisplay.text}1" }
        button2.setOnClickListener { inputDisplay.text = "${inputDisplay.text}2" }
        button3.setOnClickListener { inputDisplay.text = "${inputDisplay.text}3" }
        button4.setOnClickListener { inputDisplay.text = "${inputDisplay.text}4" }
        button5.setOnClickListener { inputDisplay.text = "${inputDisplay.text}5" }
        button6.setOnClickListener { inputDisplay.text = "${inputDisplay.text}6" }
        button7.setOnClickListener { inputDisplay.text = "${inputDisplay.text}7" }
        button8.setOnClickListener { inputDisplay.text = "${inputDisplay.text}8" }
        button9.setOnClickListener { inputDisplay.text = "${inputDisplay.text}9" }

        buttonAdd.setOnClickListener {
            allCalculations()
            currentSymbol = ADDITION
            outputDisplay.text = "${decimalFormat.format(firstValue)}"
            inputDisplay.text = null
        }

        buttonSub.setOnClickListener {
            allCalculations()
            currentSymbol = SUBTRACTION
            outputDisplay.text = "${decimalFormat.format(firstValue)}"
            inputDisplay.text = null
        }

        buttonMultiply.setOnClickListener {
            allCalculations()
            currentSymbol = MULTIPLICATION
            outputDisplay.text = "${decimalFormat.format(firstValue)}"
            inputDisplay.text = null
        }

        buttonDivide.setOnClickListener {
            allCalculations()
            currentSymbol = DIVISION
            outputDisplay.text = "${decimalFormat.format(firstValue)}"
            inputDisplay.text = null
        }

        buttonPercent.setOnClickListener {
            allCalculations()
            currentSymbol = PERCENT
            outputDisplay.text = "${decimalFormat.format(firstValue)}%"
            inputDisplay.text = null
        }

        buttonDot.setOnClickListener {
            inputDisplay.text = "${inputDisplay.text}."
        }

        buttonClear.setOnClickListener {
            if (inputDisplay.text.isNotEmpty()) {
                val currentText = inputDisplay.text
                inputDisplay.text = currentText.subSequence(0, currentText.length - 1)
            } else {
                firstValue = Double.NaN
                secondValue = Double.NaN
                inputDisplay.text = ""
                outputDisplay.text = ""
            }
        }

        buttonClearAll.setOnClickListener {
            firstValue = Double.NaN
            secondValue = Double.NaN
            inputDisplay.text = ""
            outputDisplay.text = ""
        }

        buttonEqual.setOnClickListener {
            allCalculations()
            outputDisplay.text = decimalFormat.format(firstValue)
            firstValue = Double.NaN
            currentSymbol = '0'
        }
    }

    private fun allCalculations() {
        if (!firstValue.isNaN()) {
            val inputValue = inputDisplay.text.toString().toDoubleOrNull() ?: 0.0
            inputDisplay.text = null
            firstValue = when (currentSymbol) {
                ADDITION -> firstValue + inputValue
                SUBTRACTION -> firstValue - inputValue
                MULTIPLICATION -> firstValue * inputValue
                DIVISION -> firstValue / inputValue
                PERCENT -> firstValue % inputValue
                else -> firstValue // Handle kondisi default jika diperlukan
            }
        } else {
            try {
                firstValue = inputDisplay.text.toString().toDoubleOrNull() ?: 0.0
            } catch (e: Exception) {
                // Handle exception jika diperlukan
            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Kalkulator().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}