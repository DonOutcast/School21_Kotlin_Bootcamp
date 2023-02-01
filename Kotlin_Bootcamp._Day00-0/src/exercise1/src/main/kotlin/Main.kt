import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    while(true) {
        println("Input x1:")
        val numberX1 = readLine()!!.toDoubleOrNull()
        println("Input y1:")
        val numberY1 = readLine()!!.toDoubleOrNull()
        println("Input r1:")
        val radius1 = readLine()!!.toDoubleOrNull()
        println("Input x2:")
        val numberX2 = readLine()!!.toDoubleOrNull()
        println("Input y2:")
        val numberY2 = readLine()!!.toDoubleOrNull()
        println("Input r2:")
        val radius2 = readLine()!!.toDoubleOrNull()
        if (numberX1 is Double && numberY1 is Double && numberX2 is Double && numberY2 is Double && radius1 is Double && radius2 is Double) {
            giveCirclesIntersectOrNot (numberX1, numberY1, numberX2, numberY2, radius1, radius2)
            break
        } else
            println("Couldn't parse a number. Please, try again")

    }
}

fun giveCirclesIntersectOrNot (numberX1: Double, numberY1: Double, numberX2: Double, numberY2: Double, radius1: Double, radius2: Double) {
    val d: Double = sqrt((numberX1 - numberX2).pow(2) + (numberY1 - numberY2).pow(2))
    val a: Double = (abs(radius1*radius1 - radius2*radius2) + d*d) / (2*d)
// if ((radius1 > radius2 && (d + radius2) <= radius1) || (radius2 > radius1 && (d + radius1) <= radius2)) {
    if (d <= abs(radius1 - radius2)) {
        println("One circle is inside another")
    } else if (d > radius1 + radius2)
        println("Result: the circles do not intersect")
    else if (a == radius1 || a == radius2)
        println("Result: the circles touch")
    else
        println("Result: the circles intersect")
}