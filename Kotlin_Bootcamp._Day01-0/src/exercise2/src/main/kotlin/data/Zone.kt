package data

import kotlin.math.abs
import kotlin.math.sqrt
import kotlin.random.Random

class Zone(val shape: ZoneShape, val _parameters: String) : RescueService() {
    val type: ZoneShape = shape
    val phone = PhoneZone.values().random().phone!!.formatPhone()
    val name = NameZone.values().random().nameZone
    val emergyDept = (1234..9999).random()
    val dangerLevel = LevelIncident.values().random().level
    val parameters = _parameters

    fun checkIncident(xyInsident: String) {
        val xyZoneList = parameters.split(";", " ").map { it.toInt() }.toList()
        val xyIncidentList: List<Int> = xyInsident.split(";", " ").map { it.toInt() }.toList()
        val xI = xyIncidentList[0]
        val yI = xyIncidentList[1]
        var hasIncident = false
        when (this.type) {
            ZoneShape.CIRCLE -> {
                val x = xyZoneList[0]
                val y = xyZoneList[1]
                val r = xyZoneList[2]
                hasIncident = sqrt((xI * xI + yI * yI).toDouble()) <= (r)
            }

            ZoneShape.TRIANGULAR -> {
                val x1 = xyZoneList[0]
                val y1 = xyZoneList[1]
                val x2 = xyZoneList[2]
                val y2 = xyZoneList[3]
                val x3 = xyZoneList[4]
                val y3 = xyZoneList[5]
                hasIncident = isInsideTriangle(x1, y1, x2, y2, x3, y3, xI, yI)
            }

            ZoneShape.TETRAGON -> {
                val x1 = xyZoneList[0]
                val y1 = xyZoneList[1]
                val x2 = xyZoneList[2]
                val y2 = xyZoneList[3]
                val x3 = xyZoneList[4]
                val y3 = xyZoneList[5]
                val x4 = xyZoneList[6]
                val y4 = xyZoneList[7]
                val triangle1 = isInsideTriangle(x1, y1, x2, y2, x3, y3, xI, yI)
                val triangle2 = isInsideTriangle(x1, y1, x3, y3, x4, y4, xI, yI)
                hasIncident = (triangle1 || triangle2)
            }

            else -> hasIncident = false
        }

        if (hasIncident) {
            println("An incident is in ${this.name}")
            println("We will help you soon!")
        } else {
            println("An incident is not in ${this.name}")
            println("Switch the applicant to the common number: ${this.rescuePhone}")
        }
    }

    fun printInfo() {
        println()
        println("The zone info:")
        println("\tThe shape of area: ${this.type.shape}")
        println("\tPhone number: ${this.phone}")
        println("\tName: ${this.name}")
        println("\tEmergency dept: ${this.emergyDept}")
        println("\tDanger level: ${this.dangerLevel}")
        println()
    }

}

enum class ZoneShape(val shape: String) {
    TETRAGON("tetragon"),
    TRIANGULAR("triangular"),
    CIRCLE("circle")
}

enum class LevelIncident(val level: String) {
    LOW("low"),
    MEDIUM("medium"),
    HIGH("high")
}


fun calcArea(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int): Double {
    return abs((x1.toDouble() * (y2 - y3) + x2.toDouble() * (y3 - y1) + x3.toDouble() * (y1 - y2)) / 2.0)
}


fun isInsideTriangle(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int, x: Int, y: Int): Boolean {
    val a = calcArea(x1, y1, x2, y2, x3, y3)
    val a1 = calcArea(x, y, x2, y2, x3, y3)
    val a2 = calcArea(x1, y1, x, y, x3, y3)
    val a3 = calcArea(x1, y1, x2, y2, x, y)

    /*check if cum of area is equal sum of triangle*/
    return (a == a1 + a2 + a3)

}

enum class PhoneZone(val phone: String?) {
    A("+79435698845"),
    B("+76524596324"),
    C("+78547321152"),
    D("+79834521183"),
    E("+74596872210"),
    NULL("")

}

enum class NameZone(val nameZone: String) {
    SOVET("Sovetsky district"),
    RED("Red district"),
    ZONA("Zona 51"),
    MOON("Moon")
}