package sf333.assign1.guessnum

import android.os.Bundle
import android.widget.Button
import androidx.compose.ui.text.input.KeyboardType
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import sf333.assign1.guessnum.ui.theme.GuessNumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessNumTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Header("Guess the number!")
                    GuessButton("GUESS")
                }
            }
        }
    }
}

@Composable
fun Header(text1: String, modifier: Modifier = Modifier) {
    Text(
        text = "$text1",
        modifier = modifier
    )
}

@Composable
fun NumberField(modifier: Modifier = Modifier) {
    TextField(
        value = "a"
    )
}

@Composable
fun GuessButton(text1: String, modifier: Modifier = Modifier){
    Button(
        onClick = { },
        modifier = modifier
            .width(240.dp)
            .height(80.dp)
    )
    {
        Text(text1)
    }
}

