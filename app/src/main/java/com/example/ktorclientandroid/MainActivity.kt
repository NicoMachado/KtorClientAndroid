package com.example.ktorclientandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ktorclientandroid.compose.PostsKtorDemo
import com.example.ktorclientandroid.ui.theme.KtorClientAndroidTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtorClientAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //PostsKtorDemo()
                    Navigation()
                    //MainMenu("Nicolas")
                }
            }
        }
    }
}



@Composable
fun MainMenu(navController: NavController, name: String) {
//    val navController = rememberNavController()
//    NavHost(navController,
//        startDestination = "MainMenu")
//    {
//        composable("MainMenu"){
//            MainMenu(name)
//        }
//        composable("PostsKtorDemo") {
//            PostsKtorDemo()
//        }
//    }
    Column(
        modifier =
            Modifier.padding(2.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly

        )
    {
        Text(
            text = "Menu $name!",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.75f),
            onClick = { navController.navigate("PostsKtorDemo") }
            ) {
                Text(text = "Post Demo")
            }
        Spacer(modifier = Modifier.height(4.dp))
        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.75f),
            onClick = {
            }) {
            Text(text = "Spoonacular Demo")
        }
    }

}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    KtorClientAndroidTheme {
//        MainMenu("Android")
//    }
//}
