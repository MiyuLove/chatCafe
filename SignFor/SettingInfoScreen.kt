package com.exercise.cafechatmaterial3ver.SignFor

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exercise.cafechatmaterial3ver.ViewActivity
import com.exercise.cafechatmaterial3ver.composeAct.LogTextField


//final nav screen of Sign for
//if the back button in this activity, this nav is exit(0)
//and return to LoginActivity.
//this is not recycle

@Composable
fun SettingInfroScreen(nc : NavController){
    val activity = LocalContext.current as? Activity
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.weight(2f).background(Color.Black))
            LogTextField(txt = "프로필 사진", modifier = Modifier)
            Spacer(modifier = Modifier.weight(1f))
            LogTextField(txt = "닉네임", modifier = Modifier)
            Spacer(modifier = Modifier.weight(0.5f))
            LogTextField(txt = "소개글 60자 이하", modifier = Modifier)
            Spacer(modifier = Modifier.weight(1f))
        }

        Row(modifier = Modifier
            .weight(1f)
            .padding(30.dp),
            verticalAlignment = Alignment.CenterVertically){

            signForBtn(oc = {
                activity?.startActivity(Intent(activity, ViewActivity::class.java))
                activity?.finish()
            }, s = "입 력 하 기",
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxHeight(0.3f),
                nc = nc)

            Spacer(Modifier.weight(0.1f))

            signForBtn(oc = {activity?.finish()},s = "나 중 에 !",
                modifier = Modifier.weight(0.4f).fillMaxHeight(0.3f),
                nc = nc)
        }
    }
}