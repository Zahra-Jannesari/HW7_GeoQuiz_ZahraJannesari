package com.zarisa.geoquiz
data class Question(var question :String,var correctAnswer:Boolean,var isCheated:Boolean=false){}
object QuestionList{
    var listOfQuestions= mutableListOf<Question>()
    var haveBeenAnswered=false
    fun setQuestion(){
        var q1=Question("Nile River is the longest river in the world.",true)
        listOfQuestions.add(q1)
        var q2=Question("Ottawa is the capital of Canada.",true)
        listOfQuestions.add(q2)
        var q3=Question("Langerhans islets are located in the Pacific Ocean.",false)
        listOfQuestions.add(q3)
        var q4=Question("The October Revolution happened in November",true)
        listOfQuestions.add(q4)
        var q5=Question("Adolf Hitter was an animal lover and a vegetarian",true)
        listOfQuestions.add(q5)
        var q6=Question("Friction matches were invented before lighter.",false)
        listOfQuestions.add(q6)
        var q7=Question("The United States military has lost 6 nuclear weapons to this date.",true)
        listOfQuestions.add(q7)
        var q8=Question("Teddy bear is named after it's creator's son.",false)
        listOfQuestions.add(q8)
        var q9=Question("Puma and Adidas founders were brothers.",true)
        listOfQuestions.add(q9)
        var q10=Question("Barack Obama was the tallest American president.",false)
        listOfQuestions.add(q10)
    }
}