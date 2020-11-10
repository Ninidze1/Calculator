
package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.simplecalculator.R
import kotlinx.android.synthetic.main.activity_second.*
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.Exception
import kotlin.Result

class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        findViewById<TextView>(R.id.num0).setOnClickListener {
            if ((MathOperation.text == "0") && MathOperation.text.isEmpty()) {
               setTextField("")
            } else if ((MathOperation.text.isNotEmpty())) {
                setTextField("0")
            }
        }
        findViewById<TextView>(R.id.num1).setOnClickListener { setTextField("1") }
        findViewById<TextView>(R.id.num2).setOnClickListener { setTextField("2") }
        findViewById<TextView>(R.id.num3).setOnClickListener { setTextField("3") }
        findViewById<TextView>(R.id.num4).setOnClickListener { setTextField("4") }
        findViewById<TextView>(R.id.num5).setOnClickListener { setTextField("5") }
        findViewById<TextView>(R.id.num6).setOnClickListener { setTextField("6") }
        findViewById<TextView>(R.id.num7).setOnClickListener { setTextField("7") }
        findViewById<TextView>(R.id.num8).setOnClickListener { setTextField("8") }
        findViewById<TextView>(R.id.num9).setOnClickListener { setTextField("9") }
        findViewById<TextView>(R.id.dot).setOnClickListener {
            if (MathOperation.text.isEmpty() && !MathOperation.text.contains(".")) {
                setTextField("0.")
            } else if (MathOperation.text.isNotEmpty() && !MathOperation.text.contains(".")){
                setTextField(".")
            } else if (MathOperation.text.isNotEmpty() && MathOperation.text.contains(".") && (MathOperation.text.contains("+") || MathOperation.text.contains("-") || MathOperation.text.contains("*") || MathOperation.text.contains("/"))) {
                setTextField(".")
            }
        }
        findViewById<TextView>(R.id.gamokleba).setOnClickListener { setTextField("-") }
        findViewById<TextView>(R.id.sum).setOnClickListener { setTextField("+") }
        findViewById<TextView>(R.id.division).setOnClickListener { setTextField("/") }
        findViewById<TextView>(R.id.multiply).setOnClickListener { setTextField("*") }
        findViewById<TextView>(R.id.leftFrchxili).setOnClickListener { setTextField("(") }
        findViewById<TextView>(R.id.RightFrchxili).setOnClickListener { setTextField(")") }

        findViewById<TextView>(R.id.AC).setOnClickListener {
            MathOperation.text = ""
            ResultView.text = ""
        }

        findViewById<TextView>(R.id.Back).setOnClickListener {
            val str = MathOperation.text.toString()
            if (str.isNotEmpty()) {
                MathOperation.text = str.substring(0, str.length - 1)
            }
        }

        findViewById<TextView>(R.id.equalButton).setOnClickListener {

            try {

                val express = ExpressionBuilder(MathOperation.text.toString()).build()
                val res = express.evaluate()

                val longResult = res.toLong()
                if (res == longResult.toDouble()) {
                    ResultView.text = longResult.toString()
                } else {
                    ResultView.text = res.toString()
                }

            } catch(e:Exception) {
                Log.d("Error", "შეცდომა: ${e.message}")
                ResultView.text = e.message
            }

            val express = ExpressionBuilder(MathOperation.text.toString()).build()
            val res = express.evaluate()

            val longResult = res.toLong()
            if (res == longResult.toDouble()) {
                ResultView.text = longResult.toString()
            } else {
                ResultView.text = res.toString()

            }

        }

    }

    fun setTextField(str: String) {
        MathOperation.append(str)
    }
}