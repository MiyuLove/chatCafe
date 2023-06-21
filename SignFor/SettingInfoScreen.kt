package com.exercise.cafechatmaterial3ver.SignFor

import android.app.Activity
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController


//final nav screen of Sign for
//if the back button in this activity, this nav is exit(0)
//and return to LoginActivity.
//this is not recycle

@Composable
fun SettingInfroScreen(nc : NavController){
    val activity = (LocalContext.current as? Activity)
    Button(onClick = {
        activity?.finish()
    }) {
        Text(text = "SettingInfroScreen")
    }
}