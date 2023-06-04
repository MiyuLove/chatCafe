package com.chatproject.chatcafeproject.Logic

import android.app.Activity
import android.content.Intent
import com.chatproject.chatcafeproject.ChatUtil.chatDvUtil
import com.chatproject.chatcafeproject.ChatUtil.secureFile
import com.chatproject.chatcafeproject.SignIn
import com.chatproject.chatcafeproject.second
import kotlinx.coroutines.*

public class mainActivityLogic (act : Activity, second : Long){
    val activity = act
    val cdu = chatDvUtil()
    lateinit var secureManager : secureFile
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
            activity.startActivity(Intent(activity,SignIn::class.java))
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