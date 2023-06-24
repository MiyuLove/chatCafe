package com.exercise.cafechatmaterial3ver.SignFor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exercise.cafechatmaterial3ver.composeAct.LogTextField
import com.exercise.cafechatmaterial3ver.navigation.SignForScreens

//third nav screen of Sign for

@Composable
fun BaseInfoScreen(nc : NavController){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.weight(1f))
            LogTextField(txt = "아 이 디", modifier = Modifier)
            Spacer(modifier = Modifier.weight(1f))
            LogTextField(txt = "비 밀 번 호", modifier = Modifier)
            Spacer(modifier = Modifier.weight(1f))
            LogTextField(txt = "비 밀 번 호 확 인", modifier = Modifier)
            Spacer(modifier = Modifier.weight(1f))
            LogTextField(txt = "추천인", modifier = Modifier)
            Spacer(modifier = Modifier.weight(2f))
        }

        Row(modifier = Modifier
            .weight(1f)
            .padding(30.dp),
            verticalAlignment = Alignment.CenterVertically){

            signForBtn(oc = {
                nc.navigate(SignForScreens.SettingInfo.route)
            }, s = "입 력 하 기",
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxHeight(0.3f),
                nc = nc)

            Spacer(Modifier.weight(0.1f))

            signForBtn(oc = {
                nc.popBackStack()
            },s = "뒤 로 가 기",
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxHeight(0.3f),
                nc = nc)
        }

    }


}