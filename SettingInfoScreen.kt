package com.exercise.cafechatmaterial3ver.SignFor

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exercise.cafechatmaterial3ver.Logic.LoginView
import com.exercise.cafechatmaterial3ver.composeAct.NavButton
import com.exercise.cafechatmaterial3ver.composeAct.RoundedImageSet
import com.exercise.cafechatmaterial3ver.composeAct.SignForTextField
import com.exercise.cafechatmaterial3ver.composeAct.textFieldCaptionText


//final nav screen of Sign for
//if the back button in this activity, this nav is exit(0)
//and return to LoginActivity.
//this is not recycle

@Composable
fun SettingInfroScreen(nc : NavController, model : LoginView){
    val activity = LocalContext.current as? Activity
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize().padding(start = 20.dp, end = 20.dp)

    ) {
        Column(modifier = Modifier.weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            textFieldCaptionText(caption = "프로필 사진")
            RoundedImageSet( modifier = Modifier
                .weight(2f)
                .size(350.dp)
                .padding(top = 30.dp))
            //Row 주석 여기 위치
            Spacer(modifier = Modifier.weight(1f))
            SignForTextField(caption = "닉네임", model = model , a = 8, placeholderText = "특수문자와 비속어는 안 돼요",
            modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.weight(0.5f))
            SignForTextField(caption = "자기 소개", model = model , a = 9, placeholderText = "자유롭게 적어주세요",
                modifier = Modifier.fillMaxWidth())
        }

        val oc = arrayOf({ val q =nc.popBackStack()},{ val q = activity?.finish()})
        val ta = arrayOf("나 중 에 ","입 력 하 기")
        NavButton(modifier = Modifier
            .weight(1f), oc,ta)
    }
}

/*Row(modifier = Modifier.weight(4f).fillMaxWidth().background(Color.Black)){
                Spacer(modifier = Modifier.weight(1f))
                RoundedImageSet( modifier = Modifier.fillMaxHeight().weight(2f))
                Spacer(modifier = Modifier.weight(1f))
            }
            fillMaxHeight했을 때 그 크기를 알아야만 사용 가능
             */