package com.exercise.cafechatmaterial3ver.Logic

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.exercise.cafechatmaterial3ver.ChatUtil.chatDvUtil
import com.exercise.cafechatmaterial3ver.ChatUtil.secureFile

class LogInActivityLogic(activity : Activity) {
    val cdu = chatDvUtil()
    val activity : Activity
    val secureManager : secureFile
    private var logInOut = false
    private var tfID : String =""
    private var tfPW : String =""


    init{
        secureManager = secureFile(activity)
        this.activity = activity
    }

    public fun logInBtnClick(){

        secureManager.isNet()
        Toast.makeText(activity,"not Internet",Toast.LENGTH_SHORT)
        if(!logInOut)return
        if(!secureManager.checkNet) return
        //activity.startActivity(Intent(activity, ViewActivity::class.java))
        activity.finish()
    }
    public fun logInBtnClick(intent: Intent){
        //secureManager.isNet()
        //Toast.makeText(activity,"not Internet",Toast.LENGTH_SHORT)
        //if(!logInOut)return
        //if(!secureManager.checkNet) return
        activity.startActivity(intent)
    }

    fun isLogIn(tfID : String, tfPW : String){
        this.tfID = tfID
        this.tfPW = tfPW
        logInOut = true
        return
        if( tfID == "Server와 Room에 있는 ID" && tfPW == "Server와 Room에 있는 PW"){

            logInOut = true
        }
        else logInOut = false
    }
}