package sf333.assign1.guessnum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameLogic()
    }


    fun gameLogic(){
        setContent {
            var randomNumber by remember { mutableStateOf(Random.nextInt(0, 101)) }
            var num by remember { mutableStateOf("") }
            var message by remember { mutableStateOf("") }
            var guesses by remember { mutableStateOf(0) }
            var gameEnded by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Header("Guess the number!")
                NumberTxt(num)

                if (!gameEnded) {
                    Row {
                        NumButton("1") { num = appendNumber(num, "1") }
                        NumButton("2") { num = appendNumber(num, "2") }
                        NumButton("3") { num = appendNumber(num, "3") }
                    }

                    Row {
                        NumButton("4") { num = appendNumber(num, "4") }
                        NumButton("5") { num = appendNumber(num, "5") }
                        NumButton("6") { num = appendNumber(num, "6") }
                    }

                    Row {
                        NumButton("7") { num = appendNumber(num, "7") }
                        NumButton("8") { num = appendNumber(num, "8") }
                        NumButton("9") { num = appendNumber(num, "9") }
                    }

                    Row {
                        NumButton("0") { num = appendNumber(num, "0") }
                        GuessButton("GUESS") {
                            guesses += 1  // Increment guess count
                            val guessedNum = num.toInt()
                            when {
                                guessedNum < randomNumber -> message = "Too low!"
                                guessedNum > randomNumber -> message = "Too high!"
                                else -> {
                                    message = "You got it! Guesses: $guesses"
                                    gameEnded = true
                                    randomNumber = Random.nextInt(0, 101)
                                }
                            }
                            num = ""  // Clear the input
                        }
                    }
                } else {
                    Button(onClick = {
                        gameEnded = false
                        guesses = 0
                        message = ""
                        randomNumber = Random.nextInt(0, 100)
                    }) {
                        Text("Play Again")
                    }
                }

                Text(message)
            }
        }
    }

    private fun appendNumber(current: String, append: String): String {
        return current + append
    }

    @Composable
    private fun NumButton(text1: String, onClick: () -> Unit) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(5.dp)
        ) {
            Text(text1)
        }
    }

    @Composable
    fun Header(text1: String, modifier: Modifier = Modifier) {
        Text(
            text = text1,
            modifier = modifier.padding(5.dp),
            fontSize = 24.sp
        )
    }

    @Composable
    fun NumberTxt(num: String, modifier: Modifier = Modifier) {
        Text(
            text = num,
            modifier = modifier.padding(5.dp),
            fontSize = 24.sp
        )
    }

    @Composable
    fun GuessButton(text1: String, onClick: () -> Unit) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
                .padding(5.dp)
        ) {
            Text(text1)
        }
    }
}
