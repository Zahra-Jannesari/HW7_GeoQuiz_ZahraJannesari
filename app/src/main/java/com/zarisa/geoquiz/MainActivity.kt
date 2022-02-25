package com.zarisa.geoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.zarisa.geoquiz.databinding.ActivityCheatPageBinding
import com.zarisa.geoquiz.databinding.ActivityMainBinding


var numberOfPage=0
const val number="number"
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var maxNumberOfPages=9
//    private var questionList: Array<String> = arrayOf(
//        "Nile River is the longest river in the world.", "Ottawa is the capital of Canada.",
//        "Langerhans islets are located in the Pacific Ocean.", "The October Revolution happened in November",
//        "Adolf Hitter was an animal lover and a vegetarian", "Friction matches were invented before lighter.",
//        "The United States military has lost 6 nuclear weapons to this date.", "Teddy bear is named after it's creator's son.",
//        "Puma and Adidas founders were brothers.", "Barack Obama was the tallest American president.")
//    private var answerList= arrayOf(true, true, false, true, true, false, true, false, true, false)
//    var haveBeenAnswered=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        var view=binding.root
        setContentView(view)
//        if (savedInstanceState!=null){
//            haveBeenAnswered=savedInstanceState.getBoolean("haveBeenAnswered")
////            with(savedInstanceState){
////                haveBeenAnswered=getBoolean("haveBeenAnswered")
////            }
//        }
        QuestionList.setQuestion()
        primaryInit()
        setOnClickListeners()
    }
    private fun primaryInit() {
        if(numberOfPage==0){
            binding.buttonPrev.isClickable = false
        }
        if (numberOfPage==maxNumberOfPages){
            binding.buttonNext.isClickable=false
        }
        binding.textViewQuestion.text=QuestionList.listOfQuestions[numberOfPage].question
        if (QuestionList.haveBeenAnswered){
            binding.buttonFalseAnswer.isEnabled = false
            binding.buttonTrueAnswer.isEnabled = false
        }else{
            binding.buttonFalseAnswer.isEnabled = true
            binding.buttonTrueAnswer.isEnabled = true
        }
    }
    private fun setOnClickListeners() {
        binding.buttonTrueAnswer.setOnClickListener { checkAnswer(true) }
        binding.buttonFalseAnswer.setOnClickListener { checkAnswer(false) }
        binding.buttonNext.setOnClickListener {
            numberOfPage++
            restartThePage()
        }
        binding.buttonPrev.setOnClickListener {
            numberOfPage--
            restartThePage()
        }
        binding.buttonCheat.setOnClickListener {
            val intent= Intent(this,CheatPage::class.java)
            intent.putExtra(number,numberOfPage)
            startActivity(intent)
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode==1&&resultCode== RESULT_OK){
//            val resultOfCheat=intent.getIntExtra(cheat,0)
//            if(resultOfCheat==1)
//                cheatedList[numberOfPage]=true
//        }
//    }
    private fun checkAnswer(userAnswer:Boolean){
        if(QuestionList.listOfQuestions[numberOfPage].correctAnswer==userAnswer){
            if(!(QuestionList.listOfQuestions[numberOfPage].isCheated))
                Toast.makeText(this,"Correct!", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Cheating is wrong!", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Incorrect!", Toast.LENGTH_SHORT).show()
        }
        binding.buttonFalseAnswer.isClickable = false
        binding.buttonTrueAnswer.isClickable = false
        QuestionList.haveBeenAnswered=true
    }
    private fun restartThePage(){
        binding.buttonTrueAnswer.isClickable=true
        binding.buttonFalseAnswer.isClickable=true
        binding.buttonCheat.isClickable=true
        binding.buttonPrev.isClickable=true
        binding.buttonNext.isClickable=true
        QuestionList.haveBeenAnswered=false
        primaryInit()
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        outState.putBoolean("haveBeenAnswered",haveBeenAnswered)
//        super.onSaveInstanceState(outState)
//    }



}
//android:configChanges="orientation|screenSize|keyboardHidden"

//    override fun onSaveInstanceState(outState: Bundle) {
//
//        super.onSaveInstanceState(outState)
//        haveBeenAnswered?.let { outState.putBoolean("haveBeenAnswered", it) }
//    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        haveBeenAnswered=savedInstanceState.getBoolean("haveBeenAnswered")
//    }