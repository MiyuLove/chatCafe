package com.exercise.cafechatmaterial3ver.ChatNav

import androidx.compose.runtime.Composable
import com.exercise.cafechatmaterial3ver.ChatNav.ChattingComposable.ChattingTopBar
import com.exercise.cafechatmaterial3ver.Logic.ChatView

@Composable
fun ChatScreen(model : ChatView){
    ChattingTopBar("who is the Fucking Chatting")
}