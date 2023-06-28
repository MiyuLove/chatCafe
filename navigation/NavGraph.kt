package com.exercise.cafechatmaterial3ver.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.exercise.cafechatmaterial3ver.Logic.LoginView
import com.exercise.cafechatmaterial3ver.MainView.MainFriendListScreen
import com.exercise.cafechatmaterial3ver.MainView.MainProfileScreen
import com.exercise.cafechatmaterial3ver.MainView.MainRoomListScreen
import com.exercise.cafechatmaterial3ver.MainView.MainSettingScreen
import com.exercise.cafechatmaterial3ver.SignFor.AgeAndPNScreen
import com.exercise.cafechatmaterial3ver.SignFor.BaseInfoScreen
import com.exercise.cafechatmaterial3ver.SignFor.PrivacyScreen
import com.exercise.cafechatmaterial3ver.SignFor.SettingInfroScreen
import com.exercise.cafechatmaterial3ver.SignFor.TermsScreen

@Composable
fun NavGraphSignFor (navController: NavHostController, model : LoginView = LoginView()){
    NavHost(
        navController = navController,
        startDestination = SignForScreens.Terms.route)
    {
        composable(route = SignForScreens.Terms.route){
            TermsScreen(navController)
        }
        composable(route = SignForScreens.Privacy.route){
            PrivacyScreen(navController, model)
        }
        composable(route = SignForScreens.AgeAndPN.route){
            AgeAndPNScreen(navController,model)
        }
        composable(route = SignForScreens.BaseInfo.route){
            BaseInfoScreen(nc = navController, model)
        }
        composable(route = SignForScreens.SettingInfo.route){
            SettingInfroScreen(navController, model)
        }
    }
}

@Composable
fun NavGraphMain(navController: NavHostController, //model : viewView = viewView()
){
    NavHost(
        navController = navController,
        startDestination = ViewForScreens.Profile.route)
    {
        composable(route = ViewForScreens.Profile.route){
            MainProfileScreen(navController)
        }
        composable(route = ViewForScreens.FriendList.route){
            MainFriendListScreen(navController)
        }
        composable(route = ViewForScreens.RoomList.route){
            MainRoomListScreen(nc = navController)
        }
        composable(route = ViewForScreens.Setting.route){
            MainSettingScreen(navController)
        }
    }
}