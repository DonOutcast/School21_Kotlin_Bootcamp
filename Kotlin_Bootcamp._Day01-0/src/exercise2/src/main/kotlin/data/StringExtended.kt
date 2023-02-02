package data

import java.lang.StringBuilder

fun String.formatPhone(): String = formatToPhone(this)

fun formatToPhone(_phone: String): String {
    var phone = _phone
    val lenPhone = phone.length
    if (lenPhone < 11 || lenPhone > 12) return phone

    if (phone[0] == '+') phone = phone.replace("+", "")

    var indexPhone: Int
    var mask = ""
    if (phone.startsWith("7800") || phone.startsWith("8800")) {
        mask = "8 (800) xxx xx xx"
        indexPhone = 4
    } else {
        mask = "+7 xxx xxx-xx-xx"
        indexPhone = 1
    }

    var phoneEnded = StringBuilder()
    for (i in mask.indices) {
        if (!phone[indexPhone].isDigit()) {
            phoneEnded = StringBuilder(phone)
            break
        }
        if (mask[i] == 'x') phoneEnded.append(phone[indexPhone++])
        else phoneEnded.append(mask[i])
    }

    return phoneEnded.toString()
}

fun testformatPhone() {
    println("+78002548965".formatPhone())
    println("88002648965".formatPhone())
    println("+74952548965".formatPhone())
    println("84352835724".formatPhone())
    println("123".formatPhone())
    println("+7800254896513".formatPhone())
    println("asdfghjkl;q".formatPhone())
}
