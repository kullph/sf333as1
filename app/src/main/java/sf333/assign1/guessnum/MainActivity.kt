package sf333.assign1.guessnum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sf333.assign1.guessnum.ui.theme.GuessNumTheme

var num: String = "0"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessNumTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Header("Guess the number!")

                    Row {
                        NumberTxt()
                    }

                    Row {
                        NumButton("1")
                        NumButton("2")
                        NumButton("3")
                    }

                    Row {
                        NumButton("4")
                        NumButton("5")
                        NumButton("6")
                    }

                    Row {
                        NumButton("7")
                        NumButton("8")
                        NumButton("9")
                    }

                    Row {
                        NumButton("0")
                        GuessButton("GUESS")

                    }

                }
            }
        }
    }
}

@Composable
fun Header(text1: String, modifier: Modifier = Modifier) {
    Text(
        text = "$text1",
        modifier = modifier,
    )
}

@Composable
fun NumberTxt(, modifier: Modifier = Modifier) {
    Text(
        text = num,
        modifier = modifier,
    )
}

@Composable
fun NumButton(text1: String, modifier: Modifier = Modifier){
    Button(
        onClick = { num += text1 },
        modifier = modifier
            .width(100.dp)
            .height(100.dp)
            .padding(5.dp)
    )
    {
        Text(text1)
    }

}

@Composable
fun GuessButton(text1: String, modifier: Modifier = Modifier){
    Button(
        onClick = { },
        modifier = modifier
            .width(200.dp)
            .height(100.dp)
            .padding(5.dp)
    )
    {
        Text(text1)
    }
}

