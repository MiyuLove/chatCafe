package com.exercise.cafechatmaterial3ver.navigation

sealed class SignForScreens(val route: String) {
    object Terms: SignForScreens("terms_screen")
    object Privacy: SignForScreens("privacy_screen")
    object AgeAndPN : SignForScreens("privacy2_screen")
    object BaseInfo: SignForScreens("base_info_screen")
    object SettingInfo: SignForScreens("setting_info_screen")
}
