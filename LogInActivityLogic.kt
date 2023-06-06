package com.chatproject.chatcafeproject.Logic

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.chatproject.chatcafeproject.ChatUtil.chatDvUtil
import com.chatproject.chatcafeproject.ChatUtil.secureFile
import com.chatproject.chatcafeproject.LoginActivity
import com.chatproject.chatcafeproject.SignIn
import com.chatproject.chatcafeproject.second
import kotlinx.coroutines.*

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
        activity.startActivity(Intent(activity, SignIn::class.java))
        activity.finish()
    }

    fun isLogIn(tfID : String, tfPW : String){
        this.tfID = tfID
        this.tfPW = tfPW
        if( tfID == "Server와 Room에 있는 ID" && tfPW == "Server와 Room에 있는 PW"){

            logInOut = true
        }
        else logInOut = false
    }
}