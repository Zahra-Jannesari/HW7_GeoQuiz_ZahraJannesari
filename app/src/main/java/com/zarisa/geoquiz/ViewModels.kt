package com.zarisa.geoquiz

import androidx.lifecycle.ViewModel
class ViewModel : ViewModel(){
    var listOfQuestions = arrayListOf(
        Question("Nile River is the longest river in the world.", true,"Nile River is the longest river in the world."),
        Question("Ottawa is the capital of Canada.", true,"Ottawa is the capital of Canada."),
        Question("Langerhans islets are located in the Pacific Ocean.", false,"Langerhans islets are a part of the body!"),
        Question("The October Revolution happened in November", true, "The October Revolution happened in November"),
        Question("Adolf Hitter was an animal lover and a vegetarian", true,"Adolf Hitter was an animal lover and a vegetarian"),
        Question("Friction matches were invented before lighter.", false, "Matches were invented in 1827 while lighter was invented in 1823"),
        Question("The United States military has lost 6 nuclear weapons to this date.", true,"The United States military has lost 6 nuclear weapons to this date."),
        Question("Teddy bear is named after it's creator's son.", false,"The teddy bear is named after President Theodore Roosevelt. After he refused to shoot a captured black bear on a hunt, a stuffed-animal maker decided to create a bear and name it after the president."),
        Question("Puma and Adidas founders were brothers.", true,"Puma and Adidas founders were brothers."),
        Question("Barack Obama was the tallest American president.", false, "Abraham Lincoln was the tallest American president.(193cm)")
    )

    fun getTotalNumberOfQuestions():Int{
        return listOfQuestions.size
    }
    fun getQuestionText(numberOfPage:Int):String{
        return listOfQuestions[numberOfPage].questionText
    }
    fun getCorrectAnswerBoolean(numberOfPage:Int):Boolean{
        return listOfQuestions[numberOfPage].correctAnswerBoolean
    }
    fun getCorrectAnswerText(numberOfPage:Int):String{
        return listOfQuestions[numberOfPage].correctAnswerText
    }
    fun getIsCheated(numberOfPage:Int):Boolean{
        return listOfQuestions[numberOfPage].isCheated
    }
    fun getIsAnswered(numberOfPage:Int):Boolean{
        return listOfQuestions[numberOfPage].isAnswered
    }
    fun setAnswering(numberOfPage:Int){
        listOfQuestions[numberOfPage].isAnswered=true
    }
    fun setCheating(numberOfPage: Int){
        listOfQuestions[numberOfPage].isCheated=true
    }
}
