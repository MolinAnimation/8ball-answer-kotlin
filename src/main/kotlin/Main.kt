import kotlin.random.Random

//Declarando valores de las respuestas
const val AFFIRMATIVE_ANSWER = "✅"
const val NEGATIVE_ANSWER = "❌"
const val DOUBTFUL_ANSWER = "?"

//uniendo las respuestas con sus valores
val answers = mapOf(
    "Yes" to AFFIRMATIVE_ANSWER,
    "It's true" to AFFIRMATIVE_ANSWER,
    "Totally" to AFFIRMATIVE_ANSWER,
    "Undoubtedly" to AFFIRMATIVE_ANSWER,
    "Ask in an other moment" to DOUBTFUL_ANSWER,
    "I can't say you in this moment" to DOUBTFUL_ANSWER,
    "Maybe yes, or maybe not" to DOUBTFUL_ANSWER,
    "It's not going to happen" to NEGATIVE_ANSWER,
    "Do not count on it" to NEGATIVE_ANSWER,
    "Definitely not" to NEGATIVE_ANSWER,
    "I don't believe it" to NEGATIVE_ANSWER
)

fun mainMenu(){
    //Declarando el menu principal
    println(
        "1. Ask a question\n" +
                "2. Check all answers\n" +
                "3. Exit")
    //leyendo la respuesta del usuario
    val inputValue = readLine();


    //funciones a executar segun la respuesta del usuario
    when(inputValue){
        "1" -> askQuestion()
        "2" -> checkAnswers()
        "3" -> exit()
        else -> wrongSelection(::mainMenu)
    }
}
fun askQuestion(){
    val randNum = Random.nextInt(0, 4);
    println("What is your question?")
    readLine()

    when(randNum){
        0 ->     println("So that was your question... The answer is:\n")
        1 ->     println("That is a very important question, so the answer is: \n")
        2 ->     println("So that's what ails you? let see the answer is: \n")
        3 ->     println("Are you trying to test me? your answer is: \n")
    }

    val randomAnswer = answers.keys.random()
    println(randomAnswer)
    println("\n \n Want to ask again?")
    println("1. yes\n 2. no")
    val inputValue = readLine();
    when(inputValue){
        "1" -> askQuestion();
        "2" -> exit();
    }
}
fun checkAnswers(){
    println("Select option")
    println("1. Show all answers")
    println("2. Only show affirmative answers")
    println("3. Only show doubtful answers")
    println("4. Only show negative answers")

    val inputValue = readLine()
    when(inputValue) {
        "1" -> showAnswerByType(answers )
        "2" -> showAnswerByType(answers, "✅")
        "3" -> showAnswerByType(answers, "❌")
        "4" -> showAnswerByType(answers,"?")
        else -> wrongSelection(::checkAnswers);
    }
}

fun showAnswerByType(answersMap : Map<String, String>, answer : String ="") {
    if(answer.isBlank()){
        answers.keys.forEach { println(it) }//podria fallar
    }else{
        for((key, answerType) in answersMap){
            if(answerType == answer){
                println(key)
            }
        }
    }
    println("Want to see another kind of options? \n" +
            "1. yes / 2. no")
    val inputValue = readLine()
    when(inputValue){
        "1" -> checkAnswers()
        "2" -> exit()
    }

}
fun wrongSelection(operation: () -> Unit){
    println("Please select a correct option")
    operation();
}

fun exit(){
    println("Bye")
    System.exit(0)
}

fun main(args: Array<String>) {
    println("Hello, I'm the Kotlin 8 Ball. What do you want to do?\n")
    mainMenu();
}








