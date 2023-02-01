fun main(args: Array<String>) {
    while(true){
        var error: Boolean = false
        // typesOfTemperatures = "Kelvin", "Celsius", "Fahrenheit"
        val outputMode: String = args[0]
        println("Output mode: $outputMode")
        println("Enter a season - (W)inter or (S)ummer:")
        val season = readlnOrNull()!![0]
        println("Enter a temperature:")
        var userTemperature: Double = readlnOrNull()!!.toDouble()
        if (season != 'W' && season != 'S') {
            println("Incorrect input. Enter a season:")
            error = true
        }
        if (userTemperature !is Double) {
            println("Incorrect input. Enter a temperature:")
            error = true
        }
        if (!error) {
            thermometer(season, userTemperature, outputMode)
            break
        }
    }
}

fun thermometer(season: Char, userTemperature: Double, typesOfTemperatures: String) {
    println("The temperature is  ${convertTemper(typesOfTemperatures[0], userTemperature)} ${convertChar(typesOfTemperatures[0])}")
    if (season == 'S') {
        println("The comfortable temperature is from ${convertTemper(typesOfTemperatures[0], 22.0)} to ${convertTemper(typesOfTemperatures[0], 25.0)} ${convertChar(typesOfTemperatures[0])}.")
        if (userTemperature < 22) {
            println("Please, make it warmer by ${convertTemper(typesOfTemperatures[0], 22.0 - userTemperature)} degrees.")
        } else if (userTemperature > 25) {
            println("Please, make it colder by ${convertTemper(typesOfTemperatures[0], userTemperature - 25.0)} degrees.")
        } else {
            println("The temperature is comfortable")
        }
    } else {
        println("The comfortable temperature is from ${convertTemper(typesOfTemperatures[0], 20.0)} to ${convertTemper(typesOfTemperatures[0], 22.0)} ${convertChar(typesOfTemperatures[0])}.")
        if (userTemperature < 20) {
            println("Please, make it warmer by ${convertTemper(typesOfTemperatures[0], 20.0 - userTemperature)} degrees.")
        } else if (userTemperature > 22) {
            println("Please, make it colder by ${convertTemper(typesOfTemperatures[0], userTemperature - 22.0)} degrees.")
        } else {
            println("The temperature is comfortable")
        }
    }

}

fun convertTemper(typesOfTemperatures: Char, temperature: Double):Double {
    var result: Double = temperature
    if(typesOfTemperatures == 'K') {
        result += 273.15
    } else if (typesOfTemperatures == 'F') {
        result = result * 9 / 5 + 32
    }
    return result
}

fun convertChar(typesOfTemperatures: Char): String {
    var charTemperature: String = "°C"
    if (typesOfTemperatures == 'K') {
        charTemperature = "K"
    } else if (typesOfTemperatures == 'F') {
        charTemperature = "°F"
    }
    return charTemperature
}