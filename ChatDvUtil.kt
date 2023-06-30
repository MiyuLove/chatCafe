package com.exercise.cafechatmaterial3ver.ChatUtil

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

public class chatDvUtil{
    fun logChat(getLog : String){
        println("dd123 : " + getLog + '\n')
    }

    @Composable
    fun finishLocalActivity(){
        val activity = (LocalContext.current as? Activity)
        activity?.finish()

    }

    fun isPhoneNumber(s : String): Boolean{
        val s = s.replace("-","")
        val isPhoneWord = {ch : Char -> Boolean
            ch in '0'..'9'
        }
        for(x in s){
            if(x == ' ')return false
            if(!isPhoneWord(x))return false
        }
        return true
    }

    fun isKorean(s : String) : Boolean {
        val isKoreanWord = { ch : Char -> Boolean
            ch in '가'..'힣'
        }
        for(x in s){
            if(x == ' ')return false
            if(!isKoreanWord(x))return false
        }
        return true
    }

    fun isKoreanSpell(s : String) : Boolean{
        val isKoreanWord = { ch : Char -> Boolean
            ch in '가'..'힣' || ch in 'ㄱ'..'ㅣ'
        }
        for(x in s){
            if(x == ' ')return false
            if(!isKoreanWord(x))return false
        }
        return true
    }

    fun isEnglish(s:String):Boolean{
        val isEnglishAlpha = { ch : Char -> Boolean
            ch in 'a'..'z' || ch in 'A'..'Z'
        }
        for(x in s){
            if(x == ' ')return false
            if(!isEnglishAlpha(x))return false
        }
        return true
    }
    fun isNumberI(s:String):Boolean{
        val isNumI = { ch : Char -> Boolean
            ch in '0'..'9'
        }
        for(x in s){
            if(x == ' ')return false
            if(!isNumI(x))return false
        }
        return true
    }
    /*
    data type
    val id: Int = 0,
    val name: String,
    val nickname: String,
    val sex : Int = 0,
    val age : Int = 20,
    val pid : String,
    val pw : String,
     */
}