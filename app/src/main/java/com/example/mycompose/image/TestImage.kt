package com.example.mycompose.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mycompose.R
import com.google.accompanist.glide.rememberGlidePainter


/*

painter: Painter,
contentDescription: String?,
modifier: Modifier = Modifier,
alignment: Alignment = Alignment.Center,
contentScale: ContentScale = ContentScale.Fit,
alpha: Float = DefaultAlpha,
colorFilter: ColorFilter? = null
*/

class TestImage {

    companion object {
        @Composable
        fun addImage() {

            Column {


                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                        .background(Color.Cyan, CircleShape)
                ) {
                    Image(
                        painterResource(R.drawable.kettleho),
                        contentDescription = "KettleHo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                ) {
                    Image(
                        painterResource(R.drawable.kettleho),
                        contentDescription = "KettleHo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .size(64.dp)
                            .clip(CircleShape)                       // clip to the circle shape
                            .border(5.dp, Color.Black, CircleShape)
                    )
                }

                Box(
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
                ) {
                    Image(
                        painterResource(R.drawable.kettleho),
                        contentDescription = "KettleHo",
                        contentScale = ContentScale.Crop,
                        alpha = 0.7f,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .border(5.dp, Color.Black, RectangleShape)
                ) {
                    Image(
                        painterResource(R.drawable.kettleho),
                        contentDescription = "KettleHo",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .size(64.dp)
                            .border(2.dp, Color.Black, RectangleShape)
                            .align(Alignment.Center)
                            .clickable { println("image clicked") }
                    )
                }

                    Image(
                        painter = rememberGlidePainter("https://github.com/bumptech/glide/blob/master/static/glide_logo.png?raw=true"),
                        contentDescription = "My content description",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.height(100.dp).width(300.dp)
                    )

                Row(modifier = Modifier.padding(10.dp)){
                    FunBox()
                    Spacer(modifier = Modifier.width(16.dp))
                    FunBox()
                    Spacer(modifier = Modifier.width(16.dp))
                    FunBox()
                }

            }
        }

        @Composable
        fun FunBox(){
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .border(5.dp, Color.Black, RectangleShape)
            ) {
                Box(
                    modifier = Modifier
                        .height(75.dp)
                        .width(75.dp)
                        .border(5.dp, Color.Black, RectangleShape)
                        .align(Alignment.Center)

                ) {
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                            .border(5.dp, Color.Black, RectangleShape)
                            .align(Alignment.Center)
                    ) {
                    }
                }
            }
        }
    }



}
