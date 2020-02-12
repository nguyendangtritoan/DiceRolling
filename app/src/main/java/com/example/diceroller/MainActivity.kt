package com.example.diceroller

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

   private lateinit var diceAnimation: AnimationDrawable
    lateinit var diceImage: ImageView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)

        var diceImageAnimation = findViewById<ImageView>(R.id.dice_image).apply {
            setBackgroundResource(R.drawable.animation)
            diceAnimation = background as AnimationDrawable
        }
        rollButton.setOnClickListener {
            Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT).show()
            rollDice()

//            diceAnimation.start()
//            val handler = Handler()
//                    handler.postDelayed({
//                    diceAnimation.stop()
//                    rollDice()
//                },1000)
            }
        diceImage = findViewById(R.id.dice_image)
        rollButton.text = "Let's Roll"
    }
//    fun rollfunc(view: View) {
//        diceAnimation.start()
//        val handler = Handler()
//                    handler.postDelayed({
//                diceAnimation.stop()
//                rollDice()
//            },1000)
//    }
    @SuppressLint("SetTextI18n")
    private fun rollDice() {
        val diceImageExp = when (Random().nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(diceImageExp)
    }
}
