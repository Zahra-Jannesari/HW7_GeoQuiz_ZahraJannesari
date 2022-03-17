package com.zarisa.geoquiz

data class Question(
    var questionText: String,
    var correctAnswerBoolean: Boolean,
    var correctAnswerText:String,
    var isCheated: Boolean = false,
    var isAnswered: Boolean = false
)

object DataBank {
}