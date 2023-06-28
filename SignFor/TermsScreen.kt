package com.exercise.cafechatmaterial3ver.SignFor

import android.app.Activity
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.exercise.cafechatmaterial3ver.composeAct.signForBtn
import com.exercise.cafechatmaterial3ver.navigation.SignForScreens
import com.exercise.cafechatmaterial3ver.ui.theme.ColorCopy

val termString =
    "수 락 하 기 뒤 로 가 기\n수 락 하 기 뒤 로 가 기\n안녕하세요 계란님 계란을 먹고 감동을 받으면 감동란이 된다는 것을 알고 계신가요?\n" +
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
                .padding(start = 60.dp, end = 60.dp, top = 60.dp)
                .weight(2f)
                .verticalScroll(scrollState)
                .border(width = 2.dp, color = ColorCopy().TFFontColor,shape = RectangleShape)
        ) {
            Text(termString, fontSize = 20.sp, color = Color.Black, lineHeight = 20.sp,
            modifier = Modifier.padding(5.dp))
        }

        Row(modifier = Modifier
            .weight(1f)
            .padding(30.dp),
            verticalAlignment = Alignment.CenterVertically){

            signForBtn(
                text = "수 락 하 기",
                oc = { nc.navigate(SignForScreens.Privacy.route) },
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxHeight(0.3f),
                fontSize = 30
            )

            Spacer(Modifier.weight(0.1f))

            val activity = LocalContext.current as? Activity

            signForBtn(
                text = "뒤 로 가 기",
                oc = { activity?.finish() },
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxHeight(0.3f),
                fontSize = 30
            )
        }
    }
}