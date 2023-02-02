data class Incident(
    val x: Int,
    val y: Int,
    val description: String,
    // ...
)

enum class IncidentType(val name: String) {
    FIRE("Fire"),
    // ...
}