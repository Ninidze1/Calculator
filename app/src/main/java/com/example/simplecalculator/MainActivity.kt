package com.example.simplecalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import java.math.RoundingMode
import java.text.DecimalFormat
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.simplecalculator.SecondActivity
import java.lang.Math.round

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

        findViewById<TextView>(R.id.toSecondCalc).setOnClickListener {
            startActivity(Intent(this,SecondActivity::class.java))
        }

    }

    fun numberClick(view: View) {

        if (view is TextView) {

            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = result + number

        }

    }

    fun operationClick(view: View) {

        if (view is TextView) {
            if (resultTextView.text.isNotEmpty()) {
                operand = resultTextView.text.toString().toDouble()
            }

            this.operation = view.text.toString()
            resultTextView.text = ""

        }

    }

    fun equalsClick(view: View) {

        val secondOperandText: String = resultTextView.text.toString()
        var secondOperand: Double = 0.0

        if (secondOperandText.isNotEmpty()) {
            secondOperand = secondOperandText.toDouble()
        }

        if ((operand / secondOperand) % 1.0 == 0.0) {
            when (operation) {
                "/" -> resultTextView.text = (operand / secondOperand).toInt().toString()
            }

        } else {
            when (operation) {
            "/" -> resultTextView.text = (operand / secondOperand).toString()
        }

        }

        if ((operand * secondOperand) % 1.0 == 0.0) {
            when (operation) {
                "x" -> resultTextView.text = (operand * secondOperand).toInt().toString()
            }
        } else {
            when (operation) {
                "x" -> resultTextView.text = (operand * secondOperand).toString()
            }

        }

        if ((operand + secondOperand) % 1.0 == 0.0) {
            when (operation) {
                "+" -> resultTextView.text = (operand + secondOperand).toInt().toString()
            }
        } else {
            when (operation) {
                "+" -> resultTextView.text = (operand + secondOperand).toString()
            }

        }

        if ((operand - secondOperand) % 1.0 == 0.0) {
            when (operation) {
                "-" -> resultTextView.text = (operand - secondOperand).toInt().toString()
            }
        } else {
            when (operation) {
                "-" -> resultTextView.text = (operand - secondOperand).toString()
            }

        }

        if (operand % 1.0 != 0.0 && secondOperand % 1.0 != 0.0) {

            val number = resultTextView
            val df = DecimalFormat("#.###############")
            df.roundingMode = RoundingMode.CEILING
            resultTextView.text = df.format((operand / secondOperand))

        }

        if (operand % 1.0 != 0.0 && secondOperand % 1.0 != 0.0) {

            val number = resultTextView
            val df = DecimalFormat("#.###############")
            df.roundingMode = RoundingMode.CEILING
            resultTextView.text = df.format((operand * secondOperand))

        }

    }

    fun ACClick(view: View) {

        resultTextView.text = ""

    }

    fun BackClick(view: View) {

        val str: String = resultTextView.text.toString()
        if (str.isNotEmpty()) {
            resultTextView.text = str.substring(0, str.length - 1)

        }

    }

    fun dotClick(view: View) {

        if (view is TextView) {

            var number: String = view.text.toString()
            val result: String = resultTextView.text.toString()

            if(result.isEmpty() && !result.contains(".")) {
                number = "0."
            } else if (result.isNotEmpty() && !result.contains(".")) {
                number = "."
            } else if (result.isNotEmpty() && result.contains("."))
                number = ""

            resultTextView.text = result + number

        }

    }

}
