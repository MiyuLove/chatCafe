package com.exercise.cafechatmaterial3ver.composeAct

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
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
    onClick: () -> Unit,
    pResource :Int,
    sex : String,
    modifier: Modifier,
    buttonColor : Color
){
    Button(
        onClick =  onClick,
        shape = RoundedCornerShape(50.dp),
        contentPadding = PaddingValues(15.dp),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
        )
    ){
        Box(
        ){
            Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
                Icon(painterResource(id = pResource),"", tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(10.dp))
                Text(sex, color = Color.Black, fontStyle = FontStyle(R.font.base_font), fontSize = 25.sp)
            }
        }
    }
}


@Composable
fun SexButtonsGroup(
    modifier: Modifier,
    model : LoginView
){
    Column(modifier = modifier,) {
        textFieldCaptionText(caption = "성별", modifier = Modifier)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.border(2.dp,ColorCopy().TFColor)
        ){
            SexButton({model.updateMethod(1,"1")},
                pResource = R.drawable.pictogram_man, sex = "남", modifier = Modifier
                    .weight(0.4f)
                    .padding(end = 10.dp), buttonColor = when(model.uiStates[1].value) {
                    "1" -> ColorCopy().BtnColor
                    "2" -> Color.White
                    else -> Color.White
                })

            SexButton({ model.updateMethod(1,"2") },
                pResource = R.drawable.pictogram_woman, sex = "여", modifier = Modifier
                    .weight(0.4f)
                    .padding(start = 10.dp),buttonColor = when(model.uiStates[1].value) {
                    "2" -> ColorCopy().BtnColor
                    "1" -> Color.White
                    else -> Color.White
                })
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
    model : LoginView,
    modifier: Modifier
){
    var age by rememberSaveable{ mutableStateOf(if(model.uiStates[3].value=="")20 else model.uiStates[3].value.toInt()) }
    model.updateMethod(3,age)

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
                    model.updateMethod(3,age)
                },
                modifier = btnModifier
            )
            AgeButton(
                text = "-1",
                {
                    age -=1
                    if(age < 0) age = 1
                    model.updateMethod(3,age)
                },
                modifier = btnModifier
            )
            Text(
                text = model.uiStates[3].value,
                color = ColorCopy().MainColor,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(0.5f)
            )


            AgeButton(text = "+1",{
                age +=1
                if(age > 100) age = 100
                model.updateMethod(3,age)
            },
                modifier = btnModifier)
            AgeButton(text = "+5", {
                age +=5
                if(age > 100) age = 100
                model.updateMethod(3,age)
            }, modifier = btnModifier)
        }
    }
}

@Composable
fun RoundedImageSet (
    modifier: Modifier
){
    val images = ImageBitmap.imageResource(id = R.drawable.pictogram_man).asAndroidBitmap()

    val result = remember{ mutableStateOf<Bitmap?>(images) }
    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()){
            result.value = it
        }

    result.value?.let { image ->
        Image (image.asImageBitmap(), null)
    }



    Column() {
        IconButton(
            onClick = {
                cameraLauncher.launch()
            },
            modifier = modifier.then(Modifier.background(Color.Magenta)),

            ) {

                //Image(painter = painterResource(id = R.drawable.latteart), contentDescription = "good")
            result
        }
    }

}