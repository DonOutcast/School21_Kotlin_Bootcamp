package data

data class Incident(
    val x: Int,
    val y: Int,
    val description: String,
    val phone: String?,
    val type: String?,

    )


fun printIncidentInfo(incident: Incident) {
    println()
    println("The incident info:")
    println("\tDescription: ${incident.description}")
    println("\tPhone number: ${incident.phone!!.formatPhone()}")
    println("\tType: ${incident.type}")
    println()
}

enum class IncidentType(val type: String?) {
    FIRE("fire"),
    CAT_TREE("cat on the tree"),
    FLOOD("flood"),
    SHOOTING("shooting"),
    ACCIDENT("accident"),
    EARTQUAKE("earthquake"),
    NULL(null)
}

enum class Desciption(val description: String) {
    CAT("the woman said her cat can't get off the tree"),
    FIRE("my house is on fire"),
    NEIGHBOR("the neighbor said he didn't like my sweater..."),
    ASSEMBLY("they make me program in assembly")
}

enum class Phone(val phone: String?) {
    A("+79435698845"),
    B("+76524596324"),
    C("+78547321152"),
    D("+79834521183"),
    E("+74596872210"),
    NULL("")

}