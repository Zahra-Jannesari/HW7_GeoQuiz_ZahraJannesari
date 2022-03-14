package com.zarisa.geoquiz

import androidx.lifecycle.ViewModel
class ViewModel1 : ViewModel(){
    fun getTotalNumberOfQuestions():Int{
        return DataBank.listOfQuestions.size
    }
    fun getQuestionText(numberOfPage:Int):String{
        return DataBank.listOfQuestions[numberOfPage].questionText
    }
    fun getCorrectAnswerBoolean(numberOfPage:Int):Boolean{
        return DataBank.listOfQuestions[numberOfPage].correctAnswerBoolean
    }
    fun getCorrectAnswerText(numberOfPage:Int):String{
        return DataBank.listOfQuestions[numberOfPage].correctAnswerText
    }
    fun getIsCheated(numberOfPage:Int):Boolean{
        return DataBank.listOfQuestions[numberOfPage].isCheated
    }
    fun getIsAnswered(numberOfPage:Int):Boolean{
        return DataBank.listOfQuestions[numberOfPage].isAnswered
    }
}
