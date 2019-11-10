package com.example.insurancepremiumcalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var ageStored = 0
        val age = (1..99).toList().toTypedArray()
        val spinner = findViewById<Spinner>(R.id.spinnerAge)
        if(spinner!=null){
            val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, age)
            spinner.adapter = arrayAdapter
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    ageStored = age[position]

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        }
        btnSubmit.setOnClickListener{
            calculateInsurance()
        }
        btnReset.setOnClickListener{
            resetBtn()
        }

    }


    private fun calculateInsurance(){
        val age = spinnerAge.selectedItem.toString()
        var price = 0
        var smokerPrice = 0
        var malePrice = 0

        if(age.toInt()<17){
            price += 60
            txtResult.text = getString(R.string.below17)+" "+getString(R.string.currency)+" "+price.toString()+ "\n" +
                    getString(R.string.totalPrice) +" "+getString(R.string.currency) + price.toString()
        }
        else if(age.toInt() in 17..24){
            price+=70
            var strOutput = getString(R.string.from17to25) + " " +getString(R.string.currency)+" "+price + "\n"

            if(btnMale.isChecked){
                price += 50
                malePrice = 50
                strOutput += getString(R.string.extraMale)+" : "+getString(R.string.currency)+ malePrice + "\n"
            }
            if(cbxSmoker.isChecked){
                price+=100
                smokerPrice = 100
                strOutput += getString(R.string.extraSmoker)+" : "+getString(R.string.currency) + smokerPrice +"\n"
            }
            strOutput += getString(R.string.totalPrice) +" "+getString(R.string.currency) + price.toString()
            txtResult.text = strOutput
        }
        else if(age.toInt() in 26..30){
            price+=90
            var strOutput = getString(R.string.from26to30) + " " +getString(R.string.currency)+" "+price + "\n"
            if(btnMale.isChecked){
                price += 100
                malePrice = 100
                strOutput += getString(R.string.extraMale)+" : "+getString(R.string.currency)+ malePrice + "\n"
            }
            if(cbxSmoker.isChecked){
                price+=150
                smokerPrice =150
                strOutput += getString(R.string.extraSmoker)+" : "+getString(R.string.currency) + smokerPrice +"\n"
            }
            strOutput += getString(R.string.totalPrice) +" "+getString(R.string.currency) + price.toString()
            txtResult.text = strOutput
        }
        else if(age.toInt() in 31..40){
            price+=120
            var strOutput = getString(R.string.from31to40) + " " +getString(R.string.currency)+" "+price + "\n"
            if(btnMale.isChecked){
                price+=150
                malePrice =150
                strOutput += getString(R.string.extraMale)+" : "+getString(R.string.currency)+ malePrice + "\n"
            }
            if(cbxSmoker.isChecked){
                price+=200
                smokerPrice =200
                strOutput += getString(R.string.extraSmoker)+" : "+getString(R.string.currency) + smokerPrice +"\n"
            }
            strOutput += getString(R.string.totalPrice) +" "+getString(R.string.currency) + price.toString()
            txtResult.text = strOutput
        }
        else if(age.toInt() in 41..55){
            price += 150
            var strOutput = getString(R.string.from41to55) + " " +getString(R.string.currency)+" "+price + "\n"
            if(btnMale.isChecked){
                price+=200
                malePrice = 200
                strOutput += getString(R.string.extraMale)+" : "+getString(R.string.currency)+ malePrice + "\n"
            }
            if(cbxSmoker.isChecked){
                price +=250
                smokerPrice =250
                strOutput += getString(R.string.extraSmoker)+" : "+getString(R.string.currency) + smokerPrice +"\n"
            }
            strOutput += getString(R.string.totalPrice) +" "+getString(R.string.currency) + price.toString()
            txtResult.text = strOutput
        }
        else
        {
            price += 150
            var strOutput = getString(R.string.above55) + " " +getString(R.string.currency)+" "+price + "\n"
            if(btnMale.isChecked){
                price+=200
                malePrice = 200
                strOutput += getString(R.string.extraMale)+" : "+getString(R.string.currency)+ malePrice + "\n"
            }
            if(cbxSmoker.isChecked){
                price+=300
                smokerPrice = 300
                strOutput += getString(R.string.extraSmoker)+" : "+getString(R.string.currency) + smokerPrice +"\n"
            }
            strOutput += getString(R.string.totalPrice) +" "+getString(R.string.currency) + price.toString()
            txtResult.text = strOutput
        }
    }

    private fun resetBtn(){
        txtResult.text = " "
        rdGroupGender.clearCheck()
        cbxSmoker.isChecked = false
        spinnerAge.setSelection(0)
    }
}
