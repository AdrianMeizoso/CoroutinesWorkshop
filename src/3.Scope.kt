import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
import kotlin.system.measureTimeMillis

data class UserData(
        val name: String,
        val messages: List<String>
)

class GetUserData {
    suspend fun execute(): UserData =
            coroutineScope {
                val userData = async(Dispatchers.IO) {
                    UserDatabase.getUserData()
                }
                val userMessages = async(Dispatchers.IO) {
                    UserDatabase.getUserMessages()
                }
                return@coroutineScope UserData(userData.await(), userMessages.await())
            }
}

class ViewModel : CoroutineScope by CoroutineScope(Dispatchers.Default) {
    private val getUserData = GetUserData()

    suspend fun getUserData(callBack: (UserData) -> Unit) {
        callBack(getUserData.execute())
    }
}

fun main() = runBlocking {
    val viewModel = ViewModel()
    println("Loading")
    launch {
        viewModel.getUserData {
            println("User -> ${it.name}")
            println("Messages -> ${it.messages}")
        }
    }.join()
    println("All good")
}