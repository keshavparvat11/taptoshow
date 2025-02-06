package com.example.taptoshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taptoshow.ui.theme.TaptoshowTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaptoshowTheme {
//
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp()
                }
            }
        }
    }
}
@Composable
fun MyApp(){
    var counter by remember { mutableStateOf(1000) }
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        color = Color(0xFF546E7A)
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            if (counter > 0){

                Text(text = "$counter", fontWeight = FontWeight.Bold, fontSize = 50.sp  )
            }
            if (counter <= 0){
                Text(text = "पढ़ले", fontWeight = FontWeight.Bold, fontSize = 50.sp , color = Color.Red )
            }
            if (counter == -2) counter = 1000

            Spacer(modifier = Modifier.padding(10.dp).height(40.dp))

            CreateCircle(onClick = {counter--})

        }
    }
}
@Composable
fun CreateCircle(onClick: () -> Unit){
    Card(modifier = Modifier
        .size(200.dp)
        .clickable {
            onClick()
        }, shape = CircleShape, elevation = CardDefaults.cardElevation(15.dp)) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "TAP", fontWeight = FontWeight.Bold, fontSize = 30.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaptoshowTheme {
        MyApp()
    }
}