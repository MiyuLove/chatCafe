package com.chatproject.chatcafeproject.Logic

import android.app.Activity
import android.content.Context
import androidx.core.app.ActivityCompat
import com.chatproject.chatcafeproject.chatDvUtil
import com.chatproject.chatcafeproject.secureFile
import kotlin.concurrent.timer
import kotlin.system.exitProcess

public class mainActivityLogic (activity : Activity){
    val activity = activity
    val cdu = chatDvUtil()
    lateinit var secureManager : secureFile

    var reconnectingNum = 0

    init{
        secureManager = secureFile(activity)
        if(secureManager.checkNet)introTimer(4)
        else reconnectNet()
    }

    fun introTimer(second : Int){
        var finisher = second
        timer(period = 1000){
            finisher--
            if(finisher == 0){
                //activity.finish()
                //cancel()
            }
        }
        return
    }

    fun reconnectNet(){
        var finisher = 4
        reconnectingNum ++
        if(reconnectingNum == 8){
            ActivityCompat.finishAffinity(activity)
            exitProcess(0)
        }

        timer(period = 1000){
            finisher--
            if(finisher == 0){
                secureManager.isNet()
                if(secureManager.checkNet) {
                    introTimer(1000)
                    cancel()
                }
                else {
                    reconnectNet()
                    cancel()
                }
                cdu.logChat("reconnecting..." + reconnectingNum.toString())
                cancel()
            }
        }

    }
}