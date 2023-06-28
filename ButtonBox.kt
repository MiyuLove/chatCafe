package com.exercise.cafechatmaterial3ver.composeAct

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exercise.cafechatmaterial3ver.Logic.LoginView
import com.exercise.cafechatmaterial3ver.R
import com.exercise.cafechatmaterial3ver.ui.theme.ColorCopy

@Composable
fun LoginButton(
    modifier: Modifier,
    onClick : () -> Unit,
    text : String,
    fontSize : Int
){
    Button(
        modifier = Modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = ColorCopy().BtnColor
        )
    ){
        Text(text, fontSize = fontSize.sp,
            fontFamily = FontFamily(Font(R.font.base_font)),
            maxLines = 1,
            overflow = TextOverflow.Clip
        )
    }
}

@Composable
fun signForBtn(
    text: String,
    oc : ()-> Unit,
    modifier: Modifier,
    fontSize : Int,
    ){
    Button(
        onClick = oc,
        colors = ButtonDefaults.buttonColors(
            containerColor = ColorCopy().BtnColor
        )
        , modifier = modifier,
        contentPadding = PaddingValues(start =  0.dp, end = 0.dp),

        ){
        Text(
            text = text,
            fontSize = fontSize.sp,
            maxLines = 1,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.base_font)),
        )
    }
}

@Composable
fun SexButton(
    pResource :Int,
    sex : String,
    modifier: Modifier
){
    var selected by remember{mutableStateOf(false)}

    var sexButtonColor = if(selected)ColorCopy().BtnColor else Color.White

    Button(
        onClick = {
                  selected = !selected
        },
        shape = RoundedCornerShape(50.dp),
        contentPadding = PaddingValues(15.dp),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = sexButtonColor,

        )
    ){
        Box(
        ){
            Row(){
                Icon(painterResource(id = pResource),"", tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(10.dp))
                Text(sex, color = Color.Black)
            }
        }
    }
}

@Composable
fun SexButtonsGroup(
    modifier: Modifier
){
    Column(modifier = modifier,) {
        textFieldCaptionText(caption = "성별", modifier = Modifier)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.border(2.dp,ColorCopy().TFColor)
        ){
            SexButton(pResource = R.drawable.pictogram_man, sex = "남성", modifier = Modifier.weight(0.4f).padding(end=10.dp))
            SexButton(pResource = R.drawable.pictogram_woman, sex = "여성", modifier = Modifier.weight(0.4f).padding(start = 10.dp))
        }
        
    }
}

@Composable
fun NavButton(
    modifier: Modifier,
    tc : Array<() -> Unit>,
    text : Array<String>
){
    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically){

        signForBtn(
            text = text[0],
            oc = tc[0],
            modifier = Modifier
                .weight(0.4f)
                .fillMaxHeight(0.3f),
            fontSize = 30
        )
        Spacer(Modifier.weight(0.1f))

        signForBtn(
            text = text[1],
            oc = tc[1],
            modifier = Modifier
                .weight(0.4f)
                .fillMaxHeight(0.3f),
            fontSize = 30
        )
    }
}

@Composable
fun AgeButton(
    text : String,
    onClickButton : () -> Unit,
    modifier: Modifier
){
    Button(onClick = onClickButton,
        modifier = modifier,
        contentPadding = PaddingValues(start = 0.dp, end = 0.dp)
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier
        )
    }
}

@Composable
fun AgeField(
    caption : String,
    viewModel : LoginView,
    modifier: Modifier
){
    var age by rememberSaveable{ mutableStateOf(20) }
    viewModel.updateMethod(2,age)

    Column(
        modifier = modifier
    ) {
        Text(
            text = caption,
            textAlign = TextAlign.Start,
            color = ColorCopy().MainColor,
            fontSize = 30.sp,
        )

        val btnModifier = Modifier
            .padding(2.5.dp)
            .weight(0.5f)
        Row (Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically){
            AgeButton(
                text = "-5",
                {
                    age -=5
                    if(age < 0) age = 1
                    viewModel.updateMethod(2,age)
                },
                modifier = btnModifier
            )
            AgeButton(
                text = "-1",
                {
                    age -=1
                    if(age < 0) age = 1
                    viewModel.updateMethod(2,age)
                },
                modifier = btnModifier
            )
            Text(
                text = viewModel.uiStates[2].value,
                color = ColorCopy().MainColor,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(0.5f)
            )


            AgeButton(text = "+1",{
                age +=1
                if(age > 100) age = 100
                viewModel.updateMethod(2,age)
            },
                modifier = btnModifier)
            AgeButton(text = "+5", {
                age +=5
                if(age > 100) age = 100
                viewModel.updateMethod(2,age)
            }, modifier = btnModifier)

        }

    }
}