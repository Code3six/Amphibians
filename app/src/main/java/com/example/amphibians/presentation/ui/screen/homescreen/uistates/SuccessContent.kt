package com.example.amphibians.presentation.ui.screen.homescreen.uistates

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.domain.model.Amphibian

@Composable
fun SuccessContent(amphibians: List<Amphibian>){
    LazyColumn (
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
            ){
        items(amphibians){ amphibian ->
            AmphibianItem(
                name = amphibian.name,
                type = amphibian.type,
                description = amphibian.description,
                imgSrc = amphibian.imgsrc
            )
        }
    }
}

@Composable
fun AmphibianItem(
    name: String,
    type: String,
    description: String,
    imgSrc: String
){

    Card(modifier = Modifier.fillMaxSize(), elevation = 8.dp, shape = RoundedCornerShape(8.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(16.dp)
        ){
            var currentRotation by remember { mutableStateOf(0f)}
            var rotation = remember { Animatable(currentRotation) }
            var imageLoading by remember { mutableStateOf(true)}
            LaunchedEffect(key1 = imageLoading){
                if(imageLoading){
                    rotation.animateTo(
                        targetValue = currentRotation + 360f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(3000, easing = LinearEasing),
                            repeatMode = RepeatMode.Restart
                        )
                    ) {
                        currentRotation = value
                    }
                } else {
                    rotation.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(
                            durationMillis = 0, easing = Ease
                        )
                    )
                }
            }


            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(imgSrc)
                    .crossfade(true)
                    .build(), contentDescription = null,
                contentScale = ContentScale.FillBounds,
                error = painterResource(id = R.drawable.ic_baseline_broken_image_24),
                placeholder = painterResource(id = R.drawable.loading_img),
                onSuccess = {
                    imageLoading = false
                },
                modifier = Modifier.rotate(rotation.value)
            )
            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = type,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = description,
                lineHeight = 25.sp
            )
        }
    }
}
