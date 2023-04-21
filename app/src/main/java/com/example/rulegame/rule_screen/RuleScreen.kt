package com.example.rulegame.rule_screen
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rulegame.R
import com.example.rulegame.ui.theme.Red
import kotlin.math.roundToInt

@Composable
fun RuleScreen() {

    var rotationValue by remember {
        mutableStateOf(0f)
    }

    var number by remember {
        mutableStateOf(0)
    }

    val angle:Float by animateFloatAsState(
        targetValue = rotationValue,
        animationSpec = tween (
            durationMillis = 2000,
                ),
        finishedListener = {
            val index = (360f - (it % 360)) / (360f / 37)
        number = list[index.roundToInt()]
        }

    )

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .wrapContentHeight()
                        .wrapContentWidth(),
                    text = number.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    color= Color.White

                    )
        
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.ruleta),
                contentDescription = "Ruleta",
                modifier = Modifier
                    .fillMaxSize()
                    .rotate(angle)
            )
            Image(painter = painterResource(id = R.drawable.flecha),
                contentDescription = "Flecha",
                modifier = Modifier.fillMaxSize()
            )

        }

        Button(
            onClick = {
                      rotationValue = (720..1080).random().toFloat() + angle
            },
            colors=ButtonDefaults.buttonColors(backgroundColor = Red),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)

        ) {
            Text (
                text="START",
                color = Color.White
                    )
        }
    }
}
val list = listOf (
    0,
    32,
    15,
    19,
    4,
    21,
    2,
    25,
    17,
    34,
    6,
    27,
    13,
    36,
    11,
    30,
    8,
    23,
    10,
    5,
    24,
    16,
    33,
    1,
    20,
    14,
    31,
    9,
    22,
    18,
    29,
    7,
    28,
    12,
    35,
    3,
    26
)

