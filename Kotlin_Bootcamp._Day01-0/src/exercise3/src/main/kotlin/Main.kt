import data.*

fun main(args: Array<String>) {
    println("Type a response code:")
    val code = readCode()
    Answers.checkAnswer(code)
    println(code)
}

fun readCode(): Int {
    var code: Int?
    do {
        code = readLine()?.toInt()
        if (code == null || code < 0 || (code < 400 && code != 200 && code != 201)) println("You did something wrong...")
    } while (code == null || code < 0)

    return code
}