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
import com.exercise.cafechatmaterial3ver.composeAct.AgeField
import com.exercise.cafechatmaterial3ver.composeAct.NavButton
import com.exercise.cafechatmaterial3ver.composeAct.SexButtonsGroup
import com.exercise.cafechatmaterial3ver.composeAct.SignForTextField
import com.exercise.cafechatmaterial3ver.navigation.SignForScreens

//second nav screen of Sign for

@Composable
fun PrivacyScreen(nc : NavController, model : LoginView){
    Column(verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
        Column(modifier = Modifier.weight(2f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.weight(2f))
            SignForTextField(caption = "이름", model = model , a = 0, placeholderText = "한글만 입력 가능합니다.",
                modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.weight(1f))
            SexButtonsGroup(
                modifier = Modifier
                    .fillMaxWidth(),
                model = model
            )//a = 1
            Spacer(modifier = Modifier.weight(1f))
            AgeField(caption = "나이", model = model, modifier = Modifier
                .fillMaxWidth())
            Spacer(modifier = Modifier.weight(1f))

        }

        val oc = arrayOf({nc.navigate(SignForScreens.Terms.route)},{nc.navigate(SignForScreens.SettingInfo.route)})
        val ta = arrayOf("뒤 로 가 기","입 력 하 기")
        NavButton(modifier = Modifier
            .weight(1f), oc,ta)
    }
}
