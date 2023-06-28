package com.exercise.cafechatmaterial3ver.SignFor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exercise.cafechatmaterial3ver.Logic.LoginView
import com.exercise.cafechatmaterial3ver.composeAct.NavButton
import com.exercise.cafechatmaterial3ver.composeAct.SexButtonsGroup
import com.exercise.cafechatmaterial3ver.composeAct.SignForTextField
import com.exercise.cafechatmaterial3ver.navigation.SignForScreens

//second nav screen of Sign for

@Composable
fun PrivacyScreen(nc : NavController, model : LoginView){
    Column(verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.weight(2f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.weight(2f))
            SignForTextField(caption = "이름", viewModel = model , a = 0, placeholderText = "한글만 입력 가능합니다.",
                modifier = Modifier.fillMaxWidth().padding(start = 40.dp, end = 40.dp))
            Spacer(modifier = Modifier.weight(1f))
            SexButtonsGroup(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp))
            Spacer(modifier = Modifier.weight(1f))
        }

        val oc = arrayOf({nc.navigate(SignForScreens.AgeAndPN.route)},{nc.navigate(SignForScreens.Terms.route)})
        val ta = arrayOf("입 력 하 기","뒤 로 가 기")
        NavButton(modifier = Modifier
            .weight(1f)
            .padding(30.dp), oc,ta)
    }
}
