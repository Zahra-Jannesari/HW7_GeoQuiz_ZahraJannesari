package com.zarisa.geoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zarisa.geoquiz.databinding.ActivityCheatPageBinding
const val cheat="cheat"
class CheatPage : AppCompatActivity() {
    lateinit var binding2: ActivityCheatPageBinding
    private var questionAnswers: Array<String> = arrayOf(
        "Nile River is the longest river in the world.", "Ottawa is the capital of Canada.",
        "Langerhans islets are a part of the body!", "The October Revolution happened in November",
        "Adolf Hitter was an animal lover and a vegetarian", "Matches were invented in 1827 while lighter was invented in 1823",
        "The United States military has lost 6 nuclear weapons to this date.",
        "The teddy bear is named after President Theodore Roosevelt. After he refused to shoot a captured black bear on a hunt, a stuffed-animal maker decided to create a bear and name it after the president.",
        "Puma and Adidas founders were brothers.", "Abraham Lincoln was the tallest American president.(193cm)")
    var numberOfPage:Int?=0
    var resultOfCheat=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2= ActivityCheatPageBinding.inflate(layoutInflater)
        var view=binding2.root
        setContentView(view)
        numberOfPage=intent?.getIntExtra(number,0)
        binding2.buttonShowInfo.setOnClickListener {
            binding2.textViewCheat.text=questionAnswers[numberOfPage!!]
            resultOfCheat=1
        }
        }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent2= Intent(this,MainActivity::class.java)
        intent2.putExtra(cheat,resultOfCheat)
        setResult(RESULT_OK,intent2)
        finish()
    }

}