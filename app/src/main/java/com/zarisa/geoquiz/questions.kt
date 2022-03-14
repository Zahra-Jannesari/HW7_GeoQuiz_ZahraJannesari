package com.zarisa.geoquiz

data class Question(
    var question: String,
    var correctAnswer: Boolean,
    var isCheated: Boolean = false,
    var isAnswered: Boolean = false
)

object DataBank {
    var listOfQuestions = arrayListOf(
        Question("Nile River is the longest river in the world.", true),
        Question("Ottawa is the capital of Canada.", true),
        Question("Langerhans islets are located in the Pacific Ocean.", false),
        Question("The October Revolution happened in November", true),
        Question("Adolf Hitter was an animal lover and a vegetarian", true),
        Question("Friction matches were invented before lighter.", false),
        Question("The United States military has lost 6 nuclear weapons to this date.", true),
        Question("Teddy bear is named after it's creator's son.", false),
        Question("Puma and Adidas founders were brothers.", true),
        Question("Barack Obama was the tallest American president.", false)
    )

}