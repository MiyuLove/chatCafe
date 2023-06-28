package com.exercise.cafechatmaterial3ver.SignFor

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exercise.cafechatmaterial3ver.Logic.LoginView
import com.exercise.cafechatmaterial3ver.composeAct.LogTextField
import com.exercise.cafechatmaterial3ver.composeAct.NavButton
import com.exercise.cafechatmaterial3ver.composeAct.SignForTextField


//final nav screen of Sign for
//if the back button in this activity, this nav is exit(0)
//and return to LoginActivity.
//this is not recycle

@Composable
fun SettingInfroScreen(nc : NavController, model : LoginView){
    val activity = LocalContext.current as? Activity
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.weight(2f).background(Color.Black))
            LogTextField(txt = "프로필 사진", modifier = Modifier)
            Spacer(modifier = Modifier.weight(1f))
            SignForTextField(caption = "닉네임", viewModel = model , a = 3, placeholderText = "특수문자와 비속어는 안 돼요")
            Spacer(modifier = Modifier.weight(0.5f))
            SignForTextField(caption = "닉네임", viewModel = model , a = 5, placeholderText = "자유롭게 적어주세요")
            Spacer(modifier = Modifier.weight(1f))
        }

        val oc = arrayOf({ val q = activity?.finish()},{
            val q = activity?.finish()})
        val ta = arrayOf("입 력 하 기","난 중 에 !")
        NavButton(modifier = Modifier.weight(1f).padding(30.dp), oc,ta)

    }
}