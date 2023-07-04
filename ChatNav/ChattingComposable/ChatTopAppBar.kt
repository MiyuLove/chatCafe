package com.exercise.cafechatmaterial3ver.ChatNav.ChattingComposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exercise.cafechatmaterial3ver.composeAct.profileImage
import com.exercise.cafechatmaterial3ver.composeAct.textFieldCaptionText
import com.exercise.cafechatmaterial3ver.ui.theme.ColorCopy


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChattingTopBar(s : String = "hello"){
    Scaffold(
        topBar = {
        TopAppBar(
            title = {
                    textFieldCaptionText(caption = if(s.length < 10)s else s.substring(0,6) + "...")
            },
            actions = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Localized description"
                    )
                }
            },
            modifier = Modifier
                .drawBehind {
                    val border = 4.dp.toPx()
                    val y = size.height - border / 2

                    drawLine(
                        color = ColorCopy().TitleColor,
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = border
                    )
                }
                .padding(bottom = 4.dp)
        )
    },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier.padding(20.dp),
            ) {
                items(23) {
                    MyChatBox("Hello")
                    OtherChatBox("Good Man", " size?")
                    MyChatBox("Hello im sdfnsadkjfnsadjkfnsdjkasadfksdanjkas")
                    OtherChatBox("Good Man","Good Manasdfnjskdanfjkasnfjksdaknjfasd")
                    MyChatBox("Hello asdfnsadkjfnsadj\nkfns\ndjkasadfksdanjkas")
                    OtherChatBox("Good Man","Good Manasdfnjskda\nnfj\nk\na\ns\nn\nfjksdaknjfasd")
                    OtherChatBox("Good Man","Good Manasdfnjskdajhafdfjdafjdbhfadjbfsdkajfbshdakbfsadjk")
                }
            }
        }
    )
}

@Composable
fun OtherChatBox(nick : String, chat : String){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 10.dp)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)){
            Box(modifier = Modifier.size(40.dp)) {
                profileImage(modifier = Modifier)
            }
            textFieldCaptionText(caption = nick)
        }
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Row(verticalAlignment = Alignment.Bottom) {
                Text(text = "4:47pm", modifier = Modifier
                    .padding(end = 10.dp, start = 5.dp))
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.background(ColorCopy().ChatUserColor)
                    ) {
                        Text(text = chat, fontSize = 25.sp, modifier = Modifier.padding(10.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun MyChatBox(chat : String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 10.dp, bottom = 20.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End
    ){

        Text(text = "6:47pm", textAlign = TextAlign.End, modifier = Modifier.padding(start = 10.dp, end = 5.dp))
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(top = 10.dp)
                .background(ColorCopy().ChatOtherColor)
        ) {
            Text(text = chat, fontSize = 25.sp,modifier = Modifier.padding(10.dp))
        }
    }
}