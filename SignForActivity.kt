package com.exercise.cafechatmaterial3ver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.exercise.cafechatmaterial3ver.navigation.NavGraphSignFor
import com.exercise.cafechatmaterial3ver.ui.theme.CafeChatMaterial3verTheme

class SignForActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CafeChatMaterial3verTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavGraphSignFor(navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    CafeChatMaterial3verTheme {
        val navController = rememberNavController()
        NavGraphSignFor(navController = navController)
    }
}