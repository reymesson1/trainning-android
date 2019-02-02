package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.round
import java.text.DecimalFormat
import java.util.*
import java.text.*

class MainActivity : AppCompatActivity() {

    var first_value : String = ""
    var second_value : String = ""
    var res : Double = 0.0
    var signal : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editText = findViewById<EditText>(R.id.editText) as EditText

        editText.inputType = InputType.TYPE_NULL

        var btn0 = findViewById<EditText>(R.id.Btn0) as Button
        var btn1 = findViewById<EditText>(R.id.Btn1) as Button
        var btn2 = findViewById<EditText>(R.id.Btn2) as Button
        var btn3 = findViewById<EditText>(R.id.Btn3) as Button
        var btn4 = findViewById<EditText>(R.id.Btn4) as Button
        var btn5 = findViewById<EditText>(R.id.Btn5) as Button
        var btn6 = findViewById<EditText>(R.id.Btn6) as Button
        var btn7 = findViewById<EditText>(R.id.Btn7) as Button
        var btn8 = findViewById<EditText>(R.id.Btn8) as Button
        var btn9 = findViewById<EditText>(R.id.Btn9) as Button
        var btnC = findViewById<EditText>(R.id.BtnC) as Button
        var btnPunto = findViewById<EditText>(R.id.BtnPunto) as Button
        var btnSum = findViewById<EditText>(R.id.BtnMas) as Button
        var btnMenos = findViewById<EditText>(R.id.BtnMenos) as Button
        var btnDiv = findViewById<EditText>(R.id.BtnDiv) as Button
        var btnX = findViewById<EditText>(R.id.BtnX) as Button
        var btnIgual = findViewById<EditText>(R.id.BtnIgual) as Button
        var btnPorcent = findViewById<EditText>(R.id.BtnPorcent) as Button
        var btnNeg = findViewById<EditText>(R.id.BtnNeg) as Button

        btn0.setOnClickListener{onClick(btn0)}
        btn1.setOnClickListener{onClick(btn1)}
        btn2.setOnClickListener{onClick(btn2)}
        btn3.setOnClickListener{onClick(btn3)}
        btn4.setOnClickListener{onClick(btn4)}
        btn5.setOnClickListener{onClick(btn5)}
        btn6.setOnClickListener{onClick(btn6)}
        btn7.setOnClickListener{onClick(btn7)}
        btn8.setOnClickListener{onClick(btn8)}
        btn9.setOnClickListener{onClick(btn9)}
        btnNeg.setOnClickListener{onClick(btnNeg)}

        btnSum.setOnClickListener{onClickOperator(btnSum)}
        btnMenos.setOnClickListener{onClickOperator(btnMenos)}
        btnDiv.setOnClickListener{onClickOperator(btnDiv)}
        btnX.setOnClickListener{onClickOperator(btnX)}
        btnPorcent.setOnClickListener{onClickOperator(btnPorcent)}
        btnIgual.setOnClickListener{onClickOperator(BtnIgual)}


        btnC.setOnClickListener{

            var currentValue = editText.text.toString()
            if(currentValue.length>1){
                editText.setText(currentValue.substring(0,currentValue.length -1))
            }else{
                editText.setText("")
            }
        }

        btnC.setOnLongClickListener(object : View.OnLongClickListener{

            override fun onLongClick(v: View?) : Boolean{

                editText.setText("")
                return false
            }
        })

        btnPunto.setOnClickListener{

            if(!editText.text.toString().contains(".")){
                editText.append(".")
            }
        }

        btnNeg.setOnClickListener{

            var currentValue = editText.text.toString()

            if(!currentValue.contains("-")){

                editText.setText("-"+currentValue)
            }else{

                editText.setText(currentValue.substring(1))
            }
        }
    }

    fun sum(){

        first_value = editText.text.toString()
        editText.setText("")
        this.signal = "+"
    }

    fun substract(){

        first_value = editText.text.toString()
        editText.setText("")
        this.signal = "-"
    }

    fun mult(){

        first_value = editText.text.toString()
        editText.setText("")
        this.signal = "*"
    }

    fun div(){

        first_value = editText.text.toString()
        editText.setText("")
        this.signal = "/"
    }

    fun porcent(){

        first_value = editText.text.toString()

        editText.setText("")

        this.signal = "%"

    }

    fun onClickOperator(p0: View?){

        var id = p0!!.id
        when(id){
            R.id.BtnMas -> sum()
            R.id.BtnMenos -> substract()
            R.id.BtnX-> mult()
            R.id.BtnDiv -> div()
            R.id.BtnPorcent -> porcent()
            R.id.BtnIgual -> igual()
        }
    }

    fun igual() {

        second_value = editText.text.toString()
        when(this.signal){
            "+" -> this.res = (first_value.toDouble() + second_value.toDouble())
            "-" -> this.res = (first_value.toDouble() - second_value.toDouble())
            "*" -> this.res = (first_value.toDouble() * second_value.toDouble())
            "/" -> this.res = (first_value.toDouble() / second_value.toDouble())
            "%" -> this.res = (first_value.toDouble() % second_value.toDouble())
        }


        var other = DecimalFormatSymbols(Locale.US)

        var df = DecimalFormat("#.#########",other)

        editText.setText( df.format( this.res ) .toString())


    }

    fun onClick(p0 : View?){

        var id = p0!!.id
        var target = p0 as Button
        if(editText.toString()=="0"){
            editText.setText(target.text)
        }else{
            editText.append(target.text)
        }
    }

}