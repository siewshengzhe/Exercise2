package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        try {

            fun calculateBMI(Weight: Double, Height: Double): Double {
                return Weight / Math.pow(Height, 2.0)
            }


            buttonCalculate.setOnClickListener() {
                // function to calculate bmi
                val inputWeight: Double = editTextWeight.text.toString().toDouble()
                val inputHeight: Double = editTextHeight.text.toString().toDouble()
                val bmi: Double = calculateBMI(inputWeight, inputHeight)

                // display image
                val status: String
                when {
                    bmi < 18.5 -> {
                        (imageViewProfile.setImageResource(R.drawable.under))
                        status = "under"
                    }
                    bmi <= 24.9 -> {
                        (imageViewProfile.setImageResource(R.drawable.normal))
                        status = "Normal"
                    }
                    else -> {
                        imageViewProfile.setImageResource(R.drawable.over)
                        status = "over"
                    }
                }
                textViewBMI.text = "BMI %.2f (%s)".format(bmi, status)

            }
        }catch (ex:Exception){

            val toast:Toast = Toast.makeText(this, "InValid Input", Toast.LENGTH_LONG)

            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()

        }


            buttonReset.setOnClickListener() {
                editTextHeight.setText("")
                editTextWeight.setText("")
                textViewBMI.setText("")

                imageViewProfile.setImageResource(R.drawable.empty)
                editTextHeight.requestFocus()
            }
    }
}