package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private var firstNumber: Double = 0.0
    private var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onNumberClick(clickedView: View){
        var textView: TextView = findViewById(R.id.textField)
        if(clickedView is Button){
            var inputText = textView.text.toString()
            if (inputText == "0"){
                inputText = ""
            }
            inputText += clickedView.text.toString()
            textView.text = inputText
        }
    }

    fun operatorClick(clickedView: View){
        var textView: TextView = findViewById(R.id.textField)
        if(clickedView is Button){
            operator = clickedView.text.toString()
            firstNumber = textView.text.toString().toDouble()
            textView.text = "0"
        }
    }

    fun rootClick(clickedView: View){
        var textView: TextView = findViewById(R.id.textField)
        if(clickedView is Button){
            var number = textView.text.toString().toDouble()
            textView.text = sqrt(number).toString()
        }
    }

    fun percentClick(clickedView: View){
        var textView: TextView = findViewById(R.id.textField)
        if(clickedView is Button){
            var number = textView.text.toString().toDouble()
            textView.text = (number / 100).toString()
        }
    }

    fun switchClick(clickedView: View){
        var textView: TextView = findViewById(R.id.textField)
        if(clickedView is Button){
            var number = textView.text.toString().toDouble()
            textView.text = (number * -1).toString()
        }
    }

    fun pointClick(clickedView: View){
        var textView: TextView = findViewById(R.id.textField)
        if(clickedView is Button){
            var text = textView.text.toString()
            if(!text.contains(".")){
                text += "."
                textView.text = text
            }
        }
    }

    fun calculate(clickedView: View){
        var textView: TextView = findViewById(R.id.textField)
        var secondNumber: Double = textView.text.toString().toDouble()
        if(clickedView is Button){
            var result = when(operator){
                "+"-> firstNumber + secondNumber
                "-"-> firstNumber - secondNumber
                "/"-> firstNumber / secondNumber
                "*"-> firstNumber * secondNumber
                "^"->  Math.pow(firstNumber, secondNumber)
                else -> null
            }
            textView.text = result.toString()
        }
    }

    fun clear(clickedView: View){
        var textView: TextView = findViewById(R.id.textField)
        if(clickedView is Button){
            textView.text = "0"
            firstNumber = 0.0
        }
    }
}