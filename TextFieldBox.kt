@file:OptIn(ExperimentalMaterial3Api::class)

package com.exercise.cafechatmaterial3ver.composeAct

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exercise.cafechatmaterial3ver.ChatUtil.chatDvUtil
import com.exercise.cafechatmaterial3ver.Logic.LoginView
import com.exercise.cafechatmaterial3ver.R
import com.exercise.cafechatmaterial3ver.ui.theme.ColorCopy

val cdu = chatDvUtil()

@SuppressLint("SuspiciousIndentation")
@Composable
fun LogTextField(
    caption : String,
    model: LoginView ,
    a:Int,
    modifier: Modifier = Modifier,
    captionPadding : Int
){
    Column(modifier = Modifier.padding(start = captionPadding.dp, end = captionPadding.dp)){
        Text(
            text = caption,
            textAlign = TextAlign.Start,
            color = ColorCopy().MainColor,
            fontSize = 30.sp,
        )
        TextField(
            value =  model.uiStates[a].value,
            onValueChange = {
                model.updateMethod(a,it)
            },
            trailingIcon ={
                if(model.uiStates[a].value.isEmpty()) null
                else
                IconButton(
                    onClick = { model.updateMethod(a,"") }){
                Icon(
                    Icons.Filled.Clear,"",
                    tint = ColorCopy().TFFontColor )
                }
                          },
            modifier = modifier,
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            textStyle = TextStyle(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = ColorCopy().TFColor,
                textColor = ColorCopy().FontColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.White,
                cursorColor = ColorCopy().FontColor
            ),
        )
    }
}

var passwordValue = ""
@Composable
fun LogTextField(txt : String, modifier: Modifier,text :String) {
    var password by rememberSaveable{ mutableStateOf("") }
    var passwordVisible by rememberSaveable{ mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { password = it },
        modifier = modifier,
        placeholder = {Text(txt)},
        colors = TextFieldDefaults.textFieldColors(
            (colorResource(id = R.color.text_field_color))
        ),
        singleLine = true,
        visualTransformation = if(passwordVisible)
            VisualTransformation.None
        else PasswordVisualTransformation()
    )
    passwordValue = password
}
var idValue = ""

@Composable
fun LogTextField(txt : String, modifier: Modifier) {
    var textID by rememberSaveable{ mutableStateOf("") }

    TextField(
        value = textID,
        onValueChange = { textID = it },
        modifier = modifier,
        placeholder = {Text(txt)},
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            textColor = ColorCopy().FontColor
        ),
        singleLine = true,
    )
    idValue = textID
}

@Composable
fun SignForTextField(
    caption : String,
    model: LoginView,
    a:Int,
    modifier: Modifier = Modifier,
    placeholderText : String,
){
    Column(){
        textFieldCaptionText(caption = caption,modifier)

        TextField(
            value =  model.uiStates[a].value,
            onValueChange = {
                if(caption == "이름")model.updateKoreanMethod(a,it)
                else model.updateMethod(a,it)
            },
            placeholder = { Text(text = placeholderText)},
            trailingIcon ={
                if(model.uiStates[a].value.isEmpty()) null
                else
                    IconButton(
                        onClick = { model.updateMethod(a,"") }){
                        Icon(
                            Icons.Filled.Clear,"",
                            tint = Color.Black )
                    }
            },
            modifier = modifier,
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            textStyle = TextStyle(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = ColorCopy().TFColor,
                textColor = ColorCopy().FontColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.White,
                cursorColor = ColorCopy().FontColor
            ),
        )
    }
}
@Composable
fun LimitedSignForTextField(
    caption : String,
    model : LoginView,
    a:Int,
    modifier: Modifier = Modifier,
    placeholderText : String,
){
    textFieldCaptionText(caption = caption,modifier)
    TextField(
        value =  model.uiStates[a].value,
        onValueChange = {
            if(caption == "이름")model .updateKoreanMethod(a,it)
            else model.updateMethod(a,it)
        },
        placeholder = { Text(text = placeholderText)},
        trailingIcon ={
            if(model.uiStates[a].value.isEmpty()) null
            else
                IconButton(
                    onClick = { model.updateMethod(a,"") }){
                    Icon(
                        Icons.Filled.Clear,"",
                        tint = Color.Black )
                }
        },
        modifier = modifier,
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        textStyle = TextStyle(),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = ColorCopy().TFColor,
            textColor = ColorCopy().FontColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.White,
            cursorColor = ColorCopy().FontColor
        ),
    )
}


//폰 번호는 밑에 DateTextField 사용해서 만들면 됨
@Composable
fun PhoneTextField(
    caption : String,
    model : LoginView,
    a:Int,
    modifier: Modifier = Modifier,
    placeholderText : String,
){
    Column(){
        textFieldCaptionText(caption = caption, modifier = modifier)

        TextField(
            value =  model.uiStates[a].value,
            onValueChange = {
                if(cdu.isPhoneNumber(it)){
                    model.textFieldNumberUpdate(2,it)
                }
            },
            placeholder = { Text(text = placeholderText, color = Color.Black)},
            trailingIcon ={
                if(model.uiStates[a].value.isEmpty()) null
                else
                    IconButton(
                        onClick = { model.updateMethod(a,"") }){
                        Icon(
                            Icons.Filled.Clear,"",
                            tint = Color.Black )
                    }
            },
            modifier = modifier,
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            textStyle = TextStyle(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = ColorCopy().TFColor,
                textColor = ColorCopy().FontColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.White,
                cursorColor = ColorCopy().FontColor
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
fun textFieldCaptionText(caption : String, modifier:Modifier = Modifier){
    Text(
        text = caption,
        textAlign = TextAlign.Start,
        color = ColorCopy().MainColor,
        fontSize = 30.sp,
        modifier = modifier
    )
}