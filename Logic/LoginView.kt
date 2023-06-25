package com.exercise.cafechatmaterial3ver.Logic

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.exercise.cafechatmaterial3ver.ChatUtil.chatDvUtil

open class LoginView() : ViewModel() {
    val statesSize = 4
    val statesIntSize = 2
    private val _uiStates = arrayListOf<MutableState<String>>()
    private val _uiStatesInt = arrayListOf<MutableState<Int>>()
    val uiStates = arrayListOf<State<String>>()
    val uiStatesInt = arrayListOf<State<Int>>()

    fun startData(){
        for(i in 0 until statesSize){
            _uiStates.add(mutableStateOf(""))
            uiStates.add(_uiStates[i])
        }

        for(i in 0 until statesIntSize) {
            _uiStatesInt.add(mutableStateOf(0))
            uiStatesInt.add(_uiStatesInt[i])
        }
    }

    fun clickData(){//update room

    }
    fun updateMethod(num : Int, text: String){
        when(num) {
            in 0..3 -> _uiStates[num].value = text
            in 4..5 -> _uiStatesInt[num-4].value = text.toInt()
        }
        //hello_uistate()
    }
    fun hello_uistate(){
        chatDvUtil().logChat(_uiStates[0].value)
        chatDvUtil().logChat(_uiStates[3].value)
    }
}

class ChatView : LoginView(){

}

/*
0 -> loginID = loginItem
1 -> loginPW = loginItem
2 -> loginName = loginItem
3 -> loginNickname = loginItem
4 -> loginSex = loginItem.toInt()
5 -> loginAge = loginItem.toInt()

 */