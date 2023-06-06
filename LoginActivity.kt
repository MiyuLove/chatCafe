package com.chatproject.chatcafeproject

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.K
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chatproject.chatcafeproject.Logic.LogInActivityLogic
import com.chatproject.chatcafeproject.ui.theme.ChatCafeProjectTheme

lateinit var lc : LogInActivityLogic

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lc = LogInActivityLogic(this)
        setContent {
            ChatCafeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen(){
    Column() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        {
            LoginText("블 란 서", 90)

        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(3f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Column {
                Row{
                    LoginText("I D", 60,
                    modifier = Modifier.weight(1.5f),
                    textAlign = TextAlign.Center)

                    LogTextField(txt = "", modifier =
                    Modifier
                        .weight(4f)
                        .padding(end = 20.dp))
                }
                Row(Modifier.padding(5.dp)){
                    Box(Modifier.weight(1.5f))

                    LoginText("ID를 기억 못 하세요?", 20,
                        modifier = Modifier
                            .weight(4f)
                            .clickable(enabled = true, onClick = {}),
                        textAlign = TextAlign.Start)
                }
            }
            Column{
                Row{

                    LoginText("PW", 60,
                        modifier = Modifier.weight(1.5f),
                        textAlign = TextAlign.Center)

                    LogTextField(txt = "", modifier =
                    Modifier
                        .weight(4f)
                        .padding(end = 20.dp), "password")
                }

                Row(Modifier.padding(5.dp)){
                    Box(Modifier.weight(1.5f))

                    LoginText("PW도 기억 못 하겠네", 20,
                        modifier = Modifier
                            .weight(4f)
                            .clickable(enabled = true, onClick = {}),
                        textAlign = TextAlign.Start)
                }
            }

        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
            ){
            Button(
                onClick = {
                    lc.isLogIn(idValue, passwordValue)
                    lc.logInBtnClick()
                          },

            ){
                Text("들 어 가 기", fontSize = 70.sp,
                    fontFamily = FontFamily(Font(R.font.base_font))
                )
            }
        }
    }
}

@Composable
fun LoginText(text : String, fontSize : Int
){
    Text(text = text, fontSize = fontSize.sp)
}

@Composable
fun LoginText(text : String, fontSize : Int, modifier: Modifier,
              textAlign: TextAlign
){
    Text(text = text, fontSize = fontSize.sp, modifier = modifier, textAlign = textAlign)
}

var passwordValue = ""
@Composable
fun LogTextField(txt : String, modifier: Modifier,text :String) {
    var password by rememberSaveable{ mutableStateOf("")}
    var passwordVisible by rememberSaveable{ mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { password = it },
        modifier = modifier,
        placeholder = {Text(txt)},
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0x45A7E3EB)
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
fun LogTextField(
    txt : String, modifier: Modifier
) {
    var textID by rememberSaveable{ mutableStateOf("")}
    TextField(
        value = textID,
        onValueChange = { textID = it },
        modifier = modifier,
        placeholder = {Text(txt)},
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0x45A7E3EB)
        ),
        singleLine = true,
    )
    idValue = textID
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview5() {
    ChatCafeProjectTheme {
        LoginScreen()
    }
}