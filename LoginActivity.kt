package com.exercise.cafechatmaterial3ver

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exercise.cafechatmaterial3ver.Logic.LogInActivityLogic
import com.exercise.cafechatmaterial3ver.Logic.LoginView
import com.exercise.cafechatmaterial3ver.composeAct.LogTextField
import com.exercise.cafechatmaterial3ver.composeAct.LoginButton
import com.exercise.cafechatmaterial3ver.ui.theme.ColorCopy

lateinit var lc : LogInActivityLogic
lateinit var la : Activity
val loginView = LoginView()//수정 꼭 필요합니다

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        loginView.startData()
        super.onCreate(savedInstanceState)
        lc = LogInActivityLogic(this)
        la = this
        setContent {
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ){
        Spacer(modifier = Modifier.weight(.2f))
        Text(
            "ChatCafe", textAlign = TextAlign.Center, color = ColorCopy().TitleColor,
            fontSize = 80.sp,
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.weight(1f),
        )
        {
            LogTextField("ID",viewModel = loginView, 0,
                modifier = Modifier.fillMaxWidth().padding(start = 40.dp, bottom = 20.dp, end = 40.dp), captionPadding = 40)
            LogTextField("PW",viewModel = loginView, 1,
                modifier = Modifier.fillMaxWidth().padding(start = 40.dp, bottom = 20.dp, end = 40.dp), captionPadding = 40)//will be changed the PW LogTextField
        }

        Row(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly
            ){
            LoginButton(
                modifier = Modifier
                    .weight(.4f),
                onClick = {
                    la.startActivity(Intent(la,ViewActivity::class.java))
                    la.finish()
                },
                text = "시 작 하 기",
                fontSize = 30
            )
            Spacer(Modifier.weight(.1f))
            LoginButton(
                modifier = Modifier
                    .weight(.4f),
                onClick = {
                    la.startActivity(Intent(la,SignForActivity::class.java))
                          },
                text = "회 원 가 입",
                fontSize = 30
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun asdf(){
    LoginScreen()
}