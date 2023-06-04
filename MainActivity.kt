package com.chatproject.chatcafeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.chatproject.chatcafeproject.Logic.mainActivityLogic
import com.chatproject.chatcafeproject.ui.theme.ChatCafeProjectTheme
import com.chatproject.chatcafeproject.ui.theme.MainFont


val second : Long = 5000

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatCafeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
        mainActivityLogic(this,second)
    }
}

@Composable
fun MainScreen(){
    val state = remember{MutableTransitionState(false)}
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        state.apply{targetState = true}

        AnimatedVisibility(
            visibleState = state,
            enter = fadeIn(animationSpec = tween(5000)),
        ) {
            Text(
                "ChatCafe", textAlign = TextAlign.Center, color = MainFont,
                fontSize = 80.sp
            )
        }

        Image(
            painter = painterResource(id = R.drawable.main_intro),
            contentDescription = "Intro"
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ChatCafeProjectTheme {
        MainScreen()
    }
}