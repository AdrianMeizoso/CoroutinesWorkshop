import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun getUserData(): String {
    return "Name: AyobaUserName"
}

//fun main() = runBlocking {
//    val userDataDeferred = async {
//        getUserData()
//    }
//    println("User -> ${userDataDeferred.await()}")
//    println("Coroutine is done")
//}

fun main() = runBlocking {
    val time = measureTimeMillis {
        val wasLoginSuccessful = withContext(Dispatchers.IO) {
            AuthentificationService.loginUser()
        }
        val userData = withContext(Dispatchers.IO) {
            UserDatabase.getUserData()
        }
        val userMessages = withContext(Dispatchers.IO) {
            UserDatabase.getUserMessages()
        }

        if (wasLoginSuccessful) {
            println("User-> $userData")
            println("Messages: $userMessages")
        } else {
            println("What happened?")
        }
    }
    print("Time: $time")
}

//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        val wasLoginSuccessful = withContext(Dispatchers.IO) {
//            AuthentificationService.loginUser()
//        }
//        val userData = async(Dispatchers.IO) {
//            UserDatabase.getUserData()
//        }
//        val userMessages = async(Dispatchers.IO) {
//            UserDatabase.getUserMessages()
//        }
//
//        if (wasLoginSuccessful) {
//            println("User-> ${userData.await()}")
//            println("Messages: ${userMessages.await()}")
//        } else {
//            println("What happened?")
//        }
//    }
//    print("Time: $time")
//}