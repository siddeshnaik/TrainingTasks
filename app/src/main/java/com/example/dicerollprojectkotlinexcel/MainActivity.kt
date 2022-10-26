package com.example.dicerollprojectkotlinexcel

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
//        println("Testing Print Statements")
//        println(rollButton.id)

        rollButton.setOnClickListener {
//            val toast =  Toast.makeText(this, "Dice Rolled!",Toast.LENGTH_SHORT)
//            toast.show()

//            val resultTextView: TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"

//            rollDice()

            //Challenge
            roll2Dice()

        }

//        rollDice()
        roll2Dice()


    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        val diceImage: ImageView = findViewById(R.id.imageView)
//        diceImage.setImageResource(R.drawable.dice_2)

//        when(diceRoll){
//            1 -> diceImage.setImageResource(R.drawable.dice_1)
//            2 -> diceImage.setImageResource(R.drawable.dice_2)
//            3 -> diceImage.setImageResource(R.drawable.dice_3)
//            4 -> diceImage.setImageResource(R.drawable.dice_4)
//            5 -> diceImage.setImageResource(R.drawable.dice_5)
//            6 -> diceImage.setImageResource(R.drawable.dice_6)
//            else -> {
//                resultTextView.text = "Illegal Move"
//                diceImage.setImageResource(R.drawable.questionmark)
//            }
//        }

        val drawableResourceName = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> {
                resultTextView.text = "Illegal Move"
                R.drawable.questionmark
            }
        }
        diceImage.setImageResource(drawableResourceName)

        diceImage.contentDescription = diceRoll.toString()
    }

    // Challenge
    private fun roll2Dice() {
        val twoDiceObj = TwoDice(numSides = 6)
        val twoDiceRoll = twoDiceObj.roll()

        val resultTextView1: TextView = findViewById(R.id.textView)
        resultTextView1.text = twoDiceRoll[0].toString()
        val diceRoll1Outcome = twoDiceRoll[0].toString()

        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = twoDiceRoll[1].toString()
        val diceRoll2Outcome = twoDiceRoll[1].toString()


        val drawableResourceName1 = when (twoDiceRoll[0]) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> {
                resultTextView1.text = "Illegal Move"
                R.drawable.questionmark
            }
        }

        val diceImage1 : ImageView = findViewById(R.id.imageView)
        diceImage1.setImageResource(drawableResourceName1)
        diceImage1.contentDescription = diceRoll1Outcome.toString()


        val drawableResourceName2 = when (twoDiceRoll[1]) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> {
                resultTextView2.text = "Illegal Move"
                R.drawable.questionmark
            }
        }
        val diceImage2 : ImageView = findViewById(R.id.imageView2)
        diceImage2.setImageResource(drawableResourceName2)
        diceImage2.contentDescription = diceRoll2Outcome.toString()



    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

class TwoDice(private val numSides: Int) {
    fun roll(): ArrayList<Int> {
        val twoDiceArray: ArrayList<Int> = ArrayList(2)
        twoDiceArray.add((1..numSides).random())
        twoDiceArray.add((1..numSides).random())

        return twoDiceArray
    }
}