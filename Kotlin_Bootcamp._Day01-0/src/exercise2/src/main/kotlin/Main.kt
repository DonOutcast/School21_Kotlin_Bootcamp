import data.*
import kotlin.text.*

fun main(args: Array<String>) {
//    testformatPhone()
    println("Enter zone parameters:")
    val parametrs = readLine().toString()
    val zone: Zone = if (parametrs.matches(Regex("-*\\d+;-*\\d+ \\d+"))) Zone(ZoneShape.CIRCLE, parametrs)
    else if (parametrs.matches(Regex("-*\\d+;-*\\d+ -*\\d+;-*\\d+ -*\\d+;-*\\d+"))) Zone(
        ZoneShape.TRIANGULAR,
        parametrs
    )
    else if (parametrs.matches(Regex("-*\\d+;-*\\d+ -*\\d+;-*\\d+ -*\\d+;-*\\d+ -*\\d+;-*\\d+"))) Zone(
        ZoneShape.TETRAGON,
        parametrs
    )
    else throw Exception("Wrong coordinates: $parametrs")

    zone.printInfo()

    println("Enter an incident coordinates:")
    val coordinates = readLine().toString()
    if (!coordinates.matches(Regex("-*\\d+;-*\\d+"))) throw Exception("Wrong coordinates: $coordinates")
    val xyIncident = coordinates.split(";")
    val incident = Incident(
        xyIncident[0].toInt(),
        xyIncident[1].toInt(),
        Desciption.values().random().description,
        Phone.values().random().phone,
        IncidentType.values().random().type
    )

    printIncidentInfo(incident)

    zone.checkIncident(coordinates)


}