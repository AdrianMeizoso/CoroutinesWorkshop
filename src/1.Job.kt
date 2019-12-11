import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun showUserData() {
    println("User-> Name: AyobaUserName")
}

fun main() = runBlocking {
    val job = launch {
        showUserData()
    }
    //job.join() // This line waits until showUserData is finished
    println("Coroutine is done")
}

//fun main() = runBlocking {
//    launch {
//        println("job1: I run independently!")
//        delay(1000)
//        println("job1: I am not affected by cancellation of the request")
//    }
//    val request = launch {
//        launch {
//            println("job3: I am a child of the request coroutine!")
//            delay(1000)
//            println("job3: I will not execute this line if my parent request is cancelled\"")
//        }
//        println("job2: I am the request coroutine")
//        delay(1000)
//        println("job2: I will not execute this line I am cancelled")
//    }
//    delay(500)
//    request.cancel() // cancel processing of the request
//    delay(1000) // delay a second to see what happens
//    println("main: Who has survived request cancellation?")
//}