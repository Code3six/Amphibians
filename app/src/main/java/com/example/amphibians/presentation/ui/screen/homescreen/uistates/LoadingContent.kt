package com.example.amphibians.presentation.ui.screen.homescreen.uistates

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amphibians.R.drawable.loading_dots

@Composable
fun LoadingContent(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var currentRotation by remember{ mutableStateOf(0f)}
        var rotation = remember{Animatable(currentRotation)}
        LaunchedEffect(key1 = true){
            rotation.animateTo(
                targetValue = currentRotation + 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(1000, easing = LinearEasing),
                    repeatMode = RepeatMode.Restart
                )
            ) {
                currentRotation = value
            }
        }


        Icon(
            painter = painterResource(id = loading_dots),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .rotate(rotation.value),
            tint = Color.Blue
        )

        Text(
            text = "Loading..",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}