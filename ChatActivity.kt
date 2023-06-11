package com.chatproject.chatcafeproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chatproject.chatcafeproject.Logic.ChatActivityLogic
import com.chatproject.chatcafeproject.ui.theme.ChatCafeProjectTheme

lateinit var chatLogic : ChatActivityLogic

class ChatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chatLogic = ChatActivityLogic(this)
        setContent {
            ChatCafeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ChatScreen()
                }
            }
        }
    }
}

@Composable
fun ChatScreen(){
    MyAppTopBar()
    Column(
        Modifier
            .fillMaxWidth()
            .padding()) {

    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyAppTopBar(){
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = chatLogic.meetingRoomName)},
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            },
            actions = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite"
                )
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                , modifier = Modifier.padding(end = 20.dp)
                )
            }
        )
    }
    ){}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview7() {
    ChatCafeProjectTheme {
        ChatScreen()
    }
}