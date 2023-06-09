package com.exercise.cafechatmaterial3ver.SignFor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exercise.cafechatmaterial3ver.Logic.LoginView
import com.exercise.cafechatmaterial3ver.composeAct.NavButton
import com.exercise.cafechatmaterial3ver.composeAct.SignForTextField
import com.exercise.cafechatmaterial3ver.navigation.SignForScreens

//third nav screen of Sign for

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseInfoScreen(
    nc : NavController, model : LoginView
){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.weight(2f))
            SignForTextField(caption = "ID", viewModel = model , a = 0, placeholderText = "영어와 숫자만 사용해주세요")
            Spacer(modifier = Modifier.weight(1f))
            SignForTextField(caption = "PW", viewModel = model , a = 1, placeholderText = "6~15글자면 적당할 것 같아요")
            Spacer(modifier = Modifier.weight(1f))
            SignForTextField(caption = "PW 확인", viewModel = model , a = 1, placeholderText = "확인 한 번만 더 할게요")
            Spacer(modifier = Modifier.weight(1f))
            SignForTextField(caption = "추천인 아이디", viewModel = model , a = 4, placeholderText = "추천 아이디를 알려주세요")
            Spacer(modifier = Modifier.weight(1f))
        }


        //BackStack 관리하는 법을 적용해야 합니다.
        val oc = arrayOf({
            nc.navigate(SignForScreens.SettingInfo.route) },
            {
            nc.navigate(SignForScreens.AgeAndPN.route)}
        )
        val ta = arrayOf("입 력 하 기","뒤 로 가 기")
        NavButton(modifier = Modifier.weight(1f).padding(30.dp), oc, ta)
    }
}