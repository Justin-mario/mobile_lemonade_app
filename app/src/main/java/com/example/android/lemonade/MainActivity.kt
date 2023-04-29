package com.example.android.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.Image

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                    LemonadeApp()
            }
        }
    }
}



@Composable
fun Lemonade(modifier: Modifier = Modifier) {
    var image  by remember { mutableStateOf(
        R.drawable.lemon_tree) }

    var text by remember {mutableStateOf(R.string.tap_to_select) }
  //  val count = remember { mutableStateOf(0) }
    Column(
        modifier = modifier,

        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(id = text), fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Image(painter = painterResource(id = image), contentDescription = "lemon tree",
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .border(2.dp, Color(red = 105, green = 205, blue = 216))
            .clickable(enabled = true, onClick = {
                val returnedImage = when(image){
                    R.drawable.lemon_tree -> {
                        text = R.string.tap_to_squeeze
                        R.drawable.lemon_squeeze
                    }
                    R.drawable.lemon_squeeze -> {
//                        Modifier.clickable { count.value += 1 }
//                        if (count.value == 3 ){
//                            text = R.string.tap_to_squeeze
//                        }
                        text = R.string.tap_to_drink
                        R.drawable.lemon_drink
                    }
                    R.drawable.lemon_drink -> {
                        text = R.string.tap_to_start_again
                        R.drawable.lemon_restart
                    }
                    else -> {
                        text = R.string.tap_to_select
                        R.drawable.lemon_tree
                    }
                }
                image = returnedImage
            }),)

    }
}



@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
   Lemonade(modifier = Modifier
       .fillMaxSize()
       .wrapContentSize(Alignment.Center))
}