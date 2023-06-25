package com.exercise.cafechatmaterial3ver.Logic

import android.app.Activity
import android.content.Intent
import com.exercise.cafechatmaterial3ver.ChatUtil.chatDvUtil
import com.exercise.cafechatmaterial3ver.ChatUtil.secureFile
import com.exercise.cafechatmaterial3ver.LoginActivity
import com.exercise.cafechatmaterial3ver.second
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

public class mainActivityLogic (act : Activity, second : Long){
    val activity = act
    val cdu = chatDvUtil()
    var secureManager : secureFile
    var reconnectingNum = 0

    init{
        secureManager = secureFile(activity)
        GlobalScope.launch(Dispatchers.Main){
            async {
                delay(second)
                introCheck()
            }
        }
    }

    suspend fun introCheck(){
        if(reconnectingNum ++ == 7) {
            System.exit(0)
        }

        cdu.logChat(reconnectingNum.toString())
        if(secureManager.checkNet){
            activity.startActivity(Intent(activity, LoginActivity::class.java))
            activity.finish()
        }
        else{
            secureManager.isNet()
            delay(second)
            introCheck()
        }
        return
    }
}