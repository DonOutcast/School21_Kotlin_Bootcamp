fun main(args: Array<String>) {
    var groupingOrder: String = args[0]
    println("The grouping order is: $groupingOrder")
    println("Enter a number:")
    val number = readLine()!!.toIntOrNull()
    if (number !is Int)
        println("throw Exception")
    else
        numbersModule(number, groupingOrder)
}

fun numbersModule(number: Int, groupingOrder: String) {
    var tenDiv: Int = 1
    var resultInt: Int = 0
    var copyNumber: Int = number
    var count: Int = 0
    var showResult: Boolean = false
    var remainderOfDivision: Int = 0
    while(copyNumber > 0) {
        copyNumber /= 10
        count++
    }
    copyNumber = number
    if (groupingOrder == "lower") {
        for (i in 1..count)
            tenDiv *= 10
    }
    while (count > 0) {

        var primeNumbers: Boolean = true
        if (groupingOrder == "highest") {
            remainderOfDivision = copyNumber % 10
            copyNumber /= 10
            resultInt = resultInt * 10 + remainderOfDivision
        } else {
            tenDiv /= 10
            resultInt = number / tenDiv

        }
        for (i in 2..resultInt / 2) {
            if (number % i == 0 && i != resultInt) {
                primeNumbers = false
                break
            }
        }
        if (!showResult) {
            println("Result:")
            showResult = true
        }
        if (primeNumbers)
            println("$resultInt - prime")
        else
            println("$resultInt")
        count--
    }
}
