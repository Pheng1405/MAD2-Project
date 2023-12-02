package com.example.gym_app_mad2

import android.content.pm.ModuleInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gym_app_mad2.ui.theme.Gymappmad2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Gymappmad2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorSchema.background,
                ){
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {
                                      print("Hello")
                            },
                            modifier = Modifier.align(Alignment.CenterHorizontally)

                            ) {
                            Text("Add Item")
                        }
                    }
                }

            }
        }
    }
}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Gymappmad2Theme {
        Greeting("Android")
    }
}