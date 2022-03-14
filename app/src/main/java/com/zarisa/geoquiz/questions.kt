package com.zarisa.geoquiz

data class Question(
    var questionText: String,
    var correctAnswerBoolean: Boolean,
    var correctAnswerText:String,
    var isCheated: Boolean = false,
    var isAnswered: Boolean = false
)

object DataBank {
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

}