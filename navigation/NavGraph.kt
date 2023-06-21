package com.exercise.cafechatmaterial3ver.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.exercise.cafechatmaterial3ver.SignFor.BaseInfoScreen
import com.exercise.cafechatmaterial3ver.SignFor.PrivacyScreen
import com.exercise.cafechatmaterial3ver.SignFor.SettingInfroScreen
import com.exercise.cafechatmaterial3ver.SignFor.TermsScreen

@Composable
fun NavGraphSignFor (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = SignForScreens.Terms.route)
    {
        composable(route = SignForScreens.Terms.route){
            TermsScreen(navController)
        }
        composable(route = SignForScreens.Privacy.route){
            PrivacyScreen(navController)
        }
        composable(route = SignForScreens.BaseInfo.route){
            BaseInfoScreen(navController)
        }
        composable(route = SignForScreens.SettingInfo.route){
            SettingInfroScreen(navController)
        }
    }
}