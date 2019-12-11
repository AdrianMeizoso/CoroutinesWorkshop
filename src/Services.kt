import kotlinx.coroutines.delay

object AuthentificationService {
    suspend fun loginUser(): Boolean {
        delay(500)
        return true
    }
}

object UserDatabase {
    suspend fun getUserData(): String {
        delay(200)
        return "Name: AyobaUserName"
    }

    suspend fun getUserMessages(): List<String> {
        delay(300)
        return listOf(
                "Coroutines are cool!",
                "Using RxJava is like -> (╯°□°)╯︵ ┻━┻",
                ":)"
        )
    }
}