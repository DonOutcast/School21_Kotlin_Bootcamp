package com.example.arithmeticmodule.src

import android.util.Log
import com.example.loggername.src.Logger
import kotlinx.coroutines.delay
import java.math.BigInteger

suspend fun factorial(_value: Long, file: String): String {
    delay(1)
    var value = _value
    if (value < 0) value *= -1
    var result = BigInteger("1")
    for (i in 2..value) {
        result *= i.toBigInteger()
        Log.d("qwer", i.toString())
    }
    Logger.log(file, "ArithmeticModuleActivity_Factorial", "End calculate in function")
    return result.toString()
}