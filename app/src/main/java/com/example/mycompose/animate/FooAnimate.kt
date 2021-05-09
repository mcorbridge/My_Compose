package com.example.mycompose.animate

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.mycompose.R


class FooAnimate {


    companion object{

        @SuppressLint("StaticFieldLeak")
        lateinit var nav:NavController

        @Composable
        fun ImageAnimation(navController: NavController) {
            //DoFirestoreImage()

            nav = navController

            var customShape = CustomZhape()
            customShape.createOutline(size = Size(1f, 1f), layoutDirection = LayoutDirection.Rtl, density = Density(1f))

            Column{
               /* DotsPulsing()
                DotsElastic()
                DotsFlashing()
                DotsTyping(1, customShape)
                DotsCollision()
                DotsTyping(10, CircleShape)*/
                SingleDot.DotFlashing()
            }

        }


        val dotSize = 200.dp // made it bigger for demo
        val delayUnit = 1000 // you can change delay to change animation speed

        @Composable
        fun DotsPulsing() {

            @Composable
            fun Dot(
                scale: Float
            ) = Spacer(
                Modifier
                    .size(dotSize)
                    .scale(scale)
                    .background(
                        color = MaterialTheme.colors.primary,
                        shape = CircleShape
                    )
            )

            val infiniteTransition = rememberInfiniteTransition()

            @Composable
            fun animateScaleWithDelay(delay: Int) = infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 0f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = delayUnit * 4
                        0f at delay with LinearEasing
                        1f at delay + delayUnit with LinearEasing
                        0f at delay + delayUnit * 2
                    }
                )
            )

            val scale1 by animateScaleWithDelay(0)
            val scale2 by animateScaleWithDelay(delayUnit)
            val scale3 by animateScaleWithDelay(delayUnit * 2)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                val spaceSize = 2.dp

                Dot(scale1)
                Spacer(Modifier.width(spaceSize))
                Dot(scale2)
                Spacer(Modifier.width(spaceSize))
                Dot(scale3)
            }
        }

        @Composable
        fun DotsElastic() {
            val minScale = 0.6f

            @Composable
            fun Dot(
                scale: Float
            ) = Spacer(
                Modifier
                    .size(dotSize)
                    .scale(scaleX = minScale, scaleY = scale)
                    .background(
                        color = MaterialTheme.colors.primary,
                        shape = CircleShape
                    )
            )

            val infiniteTransition = rememberInfiniteTransition()

            @Composable
            fun animateScaleWithDelay(delay: Int) = infiniteTransition.animateFloat(
                initialValue = minScale,
                targetValue = minScale,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = delayUnit * 4
                        minScale at delay with LinearEasing
                        1f at delay + delayUnit with LinearEasing
                        minScale at delay + delayUnit * 2
                    }
                )
            )

            val scale1 by animateScaleWithDelay(0)
            val scale2 by animateScaleWithDelay(delayUnit)
            val scale3 by animateScaleWithDelay(delayUnit * 2)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                val spaceSize = 2.dp

                Dot(scale1)
                Spacer(Modifier.width(spaceSize))
                Dot(scale2)
                Spacer(Modifier.width(spaceSize))
                Dot(scale3)
            }
        }

        @Composable
        fun DotsFlashing() {
            val minAlpha = 0.1f

            @Composable
            fun Dot(alpha: Float) = Spacer(
                Modifier
                    .size(dotSize)
                    .alpha(alpha)
                    .background(color = MaterialTheme.colors.primary, shape = CircleShape)
            )

            val infiniteTransition = rememberInfiniteTransition()

            @Composable
            fun animateAlphaWithDelay(delay: Int) = infiniteTransition.animateFloat(
                initialValue = minAlpha,
                targetValue = minAlpha,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = delayUnit * 4
                        minAlpha at delay with LinearEasing
                        1f at delay + delayUnit with LinearEasing
                        minAlpha at delay + delayUnit * 2
                    }
                )
            )

            val alpha1 by animateAlphaWithDelay(0)
            val alpha2 by animateAlphaWithDelay(delayUnit)
            val alpha3 by animateAlphaWithDelay(delayUnit * 2)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                val spaceSize = 2.dp

                Dot(alpha1)
                Spacer(Modifier.width(spaceSize))
                Dot(alpha2)
                Spacer(Modifier.width(spaceSize))
                Dot(alpha3)
            }
        }

        @Composable
        fun DotsTyping(arg0:Int, shape:Shape) {
            val maxOffset = 50f

            @Composable
            fun Dot(
                offset: Float
            ) = Spacer(
                Modifier
                    .size(dotSize)
                    .offset(y = -offset.dp)
                    .background(
                        color = MaterialTheme.colors.error,
                        shape = shape
                    )
                    .clickable { nav.navigate("twentiethScreen") }
            )

            val infiniteTransition = rememberInfiniteTransition()
            var fooOffset = arg0*250

            @Composable
            fun animateOffsetWithDelay(delay: Int) = infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 0f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = (delayUnit * 8) + fooOffset
                        0f at delay with LinearEasing
                        maxOffset at delay + delayUnit with LinearEasing
                        0f at delay + delayUnit * 2
                    }
                )
            )



            val offset1 by animateOffsetWithDelay(fooOffset)
            val offset2 by animateOffsetWithDelay(delayUnit+fooOffset)
            val offset3 by animateOffsetWithDelay((delayUnit * 2)+fooOffset)
            val offset4 by animateOffsetWithDelay((delayUnit * 3)+fooOffset)
            val offset5 by animateOffsetWithDelay((delayUnit * 4)+fooOffset)
            val offset6 by animateOffsetWithDelay((delayUnit * 5)+fooOffset)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = maxOffset.dp)
            ) {
                val spaceSize = 2.dp

                Dot(offset1)
                Spacer(Modifier.width(spaceSize))
                Dot(offset2)
                Spacer(Modifier.width(spaceSize))
                Dot(offset3)
                Spacer(Modifier.width(spaceSize))
                Dot(offset4)
                Spacer(Modifier.width(spaceSize))
                Dot(offset5)
                Spacer(Modifier.width(spaceSize))
                Dot(offset6)
            }
        }

        @Composable
        fun DotsCollision() {
            val maxOffset = 30f
            val delayUnit = 500 // it's better to use longer delay for this animation

            @Composable
            fun Dotz(
                offset: Float
            ) = Spacer(
                Modifier
                    .size(dotSize)
                    .offset(x = offset.dp)
                    .background(
                        color = MaterialTheme.colors.primary,
                        shape = CircleShape
                    )
            )

            val infiniteTransition = rememberInfiniteTransition()

            val offsetLeft by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 0f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = delayUnit * 3
                        0f at 0 with LinearEasing
                        -maxOffset at delayUnit / 2 with LinearEasing
                        0f at delayUnit
                    }
                )
            )
            val offsetRight by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 0f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = delayUnit * 3
                        0f at delayUnit with LinearEasing
                        maxOffset at delayUnit + delayUnit / 2 with LinearEasing
                        0f at delayUnit * 2
                    }
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = maxOffset.dp)
            ) {
                val spaceSize = 2.dp

                Dotz(offsetLeft)
                Spacer(Modifier.width(spaceSize))
                Dotz(0f)
                Spacer(Modifier.width(spaceSize))
                Dotz(offsetRight)
            }
        }




    } // end companion object

} // end class

class CustomShape : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(size.width / 2f, 0f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        return Outline.Generic(path)
    }
}

class CustomZhape : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(size.width / 2f, 0f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        return Outline.Generic(path)
    }
}




