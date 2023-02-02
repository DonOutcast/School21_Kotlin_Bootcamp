package data

sealed class Errors(_code: Int) {
    val code = _code
    init {
        when(code){
            1000 -> {
                println("LogicError:")
                println("\tCode: $_code")
                println("\tTitle: The user is not identified")
                println("\tDescription: The user is not identified")
            }
            1001 -> {
                println("Error:")
                println("\tCode: $_code")
                println("\tTitle: The session is expired")
                println("\tDescription: The session is expired")
            }
            1002 -> {
                println("Error:")
                println("\tCode: $_code")
                println("\tNo connection")
                println("\tNo connection")
            }
            1003 -> {
                println("Error:")
                println("\tCode: $_code")
                println("\tThe device has failed the verification")
                println("\tDescription: The device has failed the verification")
            }
            else -> {
                println("Error code: $_code")
                println("Unknown error. Please, try again late")
            }
        }
    }

}

//enum class Errors(var errorTitle: String){
//    CONNECTION("1003", "")
//
//}
