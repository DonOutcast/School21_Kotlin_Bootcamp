import kotlin.math.*

fun main(args: Array<String>) {
    val input = MutableList(6) { getPoint(it) }
    val d = sqrt((input[0] - input[3]).pow(2) + (input[1] + input[4]).pow(2))
    if (d < input[2] + input[4]) {
        println("Result:")
        println("the circles intersect")
    } else if (d == input[2] + input[4]) {
        println("Result:")
        println("The circles touch")
    } else {
        println("Result:")
        println("The circles don't touch")
    }
}

private fun getPoint(i: Int): Double {
    println("Input x${i + 1}:")
    return try {
        readln().toDouble()
    } catch (e: Exception) {
        println("Couldn't parse a number. Please, try again")
        getPoint(i)
    }
}