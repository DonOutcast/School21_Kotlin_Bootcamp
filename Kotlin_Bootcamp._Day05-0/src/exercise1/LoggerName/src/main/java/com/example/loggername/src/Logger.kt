package com.example.loggername.src

import android.icu.util.Calendar
import java.io.File
import java.io.FileOutputStream

class Logger {
    companion object {
        fun log(_dir: String, tag: String, message: String) {
            var logFile = _dir
            logFile += "/log.txt"

            val fos = FileOutputStream(logFile, true)
            val logMessage = "${Calendar.getInstance().time} [$tag] $message\n"
            fos.write(logMessage.toByteArray())
        }
    }
}
