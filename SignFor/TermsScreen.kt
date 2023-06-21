package com.exercise.cafechatmaterial3ver.SignFor

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.exercise.cafechatmaterial3ver.R
import com.exercise.cafechatmaterial3ver.navigation.SignForScreens

val termString =
    "안녕하세요 계란님 계란을 먹고 감동을 받으면 감동란이 된다는 것을 알고 계신가요?\n" +
            "그래서 제가 계란님을 맛있게 먹고 감동을 받으면, 제가 감동란이 된다는 뜻이겠죠.\n" +
            "그러므로 당신을 맛있게 먹을 준비를 하겠습니다.\n" +
            "그러나 제가 감동란이 되지 않는다면 어떻게 될까요?\n" +
            "감동란이 되지 않는다면 타버린 구운란이 되겠죠 구운란은 맛이 없고 가격도 싸요. " +
            "참으로 슬픈 현실입니다." +
            "안녕하세요 계란님 계란을 먹고 감동을 받으면 감동란이 된다는 것을 알고 계신가요?\n" +
            "그래서 제가 계란님을 맛있게 먹고 감동을 받으면, 제가 감동란이 된다는 뜻이겠죠.\n" +
            "그러므로 당신을 맛있게 먹을 준비를 하겠습니다.\n" +
            "그러나 제가 감동란이 되지 않는다면 어떻게 될까요?\n" +
            "감동란이 되지 않는다면 타버린 구운란이 되겠죠 구운란은 맛이 없고 가격도 싸요. " +
            "참으로 슬픈 현실입니다." +"안녕하세요 계란님 계란을 먹고 감동을 받으면 감동란이 된다는 것을 알고 계신가요?\n" +
            "그래서 제가 계란님을 맛있게 먹고 감동을 받으면, 제가 감동란이 된다는 뜻이겠죠.\n" +
            "그러므로 당신을 맛있게 먹을 준비를 하겠습니다.\n" +
            "그러나 제가 감동란이 되지 않는다면 어떻게 될까요?\n" +
            "감동란이 되지 않는다면 타버린 구운란이 되겠죠 구운란은 맛이 없고 가격도 싸요. " +
            "참으로 슬픈 현실입니다." +
            "안녕하세요 계란님 계란을 먹고 감동을 받으면 감동란이 된다는 것을 알고 계신가요?\n" +
            "그래서 제가 계란님을 맛있게 먹고 감동을 받으면, 제가 감동란이 된다는 뜻이겠죠.\n" +
            "그러므로 당신을 맛있게 먹을 준비를 하겠습니다.\n" +
            "그러나 제가 감동란이 되지 않는다면 어떻게 될까요?\n" +
            "감동란이 되지 않는다면 타버린 구운란이 되겠죠 구운란은 맛이 없고 가격도 싸요. " +
            "참으로 슬픈 현실입니다."


//first nav screen of Sign for
@Composable
fun TermsScreen(nc : NavController){
    val scrollState = rememberScrollState()
    val activity = (LocalContext.current as? Activity)

    Column(modifier = Modifier.fillMaxSize()
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(60.dp)
                .background(colorResource(id = R.color.main_color))
                .weight(1f)
                .verticalScroll(scrollState)
        ) {
            Text(termString, fontSize = 40.sp, color = Color.White, lineHeight = 30.sp)
        }

        Row(modifier = Modifier
            .weight(1f)
            .padding(60.dp)){

            Button(onClick = {
                nc.navigate(SignForScreens.BaseInfo.route)
            }) {
                Text(text = "TermsScreen")
            }


            Button(onClick = {
                activity?.finish()
            }) {
                Text(text = "Disagree")
            }
        }
    }
}