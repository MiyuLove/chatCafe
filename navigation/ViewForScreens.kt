package com.exercise.cafechatmaterial3ver.navigation

sealed class ViewForScreens(val route: String) {
    object Profile: ViewForScreens("profile_screen")
    object FriendList: ViewForScreens("friend_list_screen")
    object RoomList: ViewForScreens("room_list_screen")
    object Setting: ViewForScreens("setting_screen")
}