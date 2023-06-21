package com.exercise.cafechatmaterial3ver.SignFor

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.exercise.cafechatmaterial3ver.navigation.SignForScreens

//third nav screen of Sign for

@Composable
fun BaseInfoScreen(nc : NavController){
    Button(onClick = {
        nc.navigate(SignForScreens.SettingInfo.route)
    }) {
        Text(text = "BaseInfoScreen")
    }
}