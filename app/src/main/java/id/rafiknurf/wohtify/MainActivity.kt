package id.rafiknurf.wohtify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import id.rafiknurf.wohtify.screens.WohtifyApp
import id.rafiknurf.wohtify.ui.theme.WohTifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WohTifyTheme {
                    Surface(modifier= Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                        FirstComposable()
                        WohtifyApp()
                    }
            }
        }
    }
}

//@Preview(showBackground = true, widthDp = 200)
// use TitleCase
@Composable
fun FirstComposable(){
    var name = remember{ mutableStateOf("") }
    Column(){
        Row() {
            Text("Hello jetpack bruh",
                modifier= Modifier
                    .background(Color.LightGray)
                    .padding(16.dp))
            Text(text = "Hello, ${name.value}!",textAlign= TextAlign.Center)
        }
        TextField(value = name.value, onValueChange ={name.value = it} )
        OutlineBtn {
            println("Hello")
        }
    }
}

@Composable
fun OutlineBtn(onClick:()->Unit){
    OutlinedButton(onClick = { onClick()}) {
        Text("Simpan")
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SecondComposable(){
//     Text("The Second Composable")
//}
