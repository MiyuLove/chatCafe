package com.chatproject.chatcafeproject.Logic

import android.app.Activity

class ChatActivityLogic(activity : Activity) {
    val activity : Activity

    var meetingRoomName = "HI"

    init{
        this.activity = activity
    }

    fun SetMeetingRoomName(roomName : String){
        meetingRoomName = roomName
    }
}