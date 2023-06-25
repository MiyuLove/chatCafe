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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exercise.cafechatmaterial3ver.Logic.LogInActivityLogic
import com.exercise.cafechatmaterial3ver.Logic.LoginView
import com.exercise.cafechatmaterial3ver.composeAct.LogTextField

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
        Spacer(modifier = Modifier.weight(.5f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .weight(1f),

        )
        {
            LogTextField("ID",viewModel = loginView, 0, modifier = Modifier.padding(bottom = 20.dp))
            LogTextField("PW",viewModel = loginView, 1, modifier = Modifier.padding(bottom = 20.dp))

        }

        Row(modifier = Modifier
            .weight(1f)
            .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly
            ){
            Button(
                modifier = Modifier.weight(.4f).padding(start = 20.dp, end = 10.dp),
                onClick = {
            //        lc.logInBtnClick()
                    },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.main_color)
                )

            ){
                Text("로 그 인", fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.base_font)),
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
            }

            Button(
                modifier = Modifier.weight(.4f).padding(start = 10.dp, end = 20.dp),
                onClick = {
                    lc.logInBtnClick(Intent(la,SignForActivity::class.java))
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.main_color)
                )

            ){
                Text("회 원 가 입", fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.base_font)),
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun asdf(){
    LoginScreen()
}