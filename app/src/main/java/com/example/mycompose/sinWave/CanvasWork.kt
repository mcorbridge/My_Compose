package com.example.mycompose.sinWave

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp


class CanvasWork {

    @Composable
    fun doInit() {
        //SmileyFaceCanvas()
        var simpleAddPath = SimpleAddPath()
        simpleAddPath.AddPath()
    }


    /*
    The onDraw lambda on the Canvas give us access to the DrawScope. This scope is allowing us
    to draw everything we want in the Canvas. Remember that the origin (x=0, y=0) of the Canvas
    is located at the top left.
     */
    @Composable
    fun SmileyFaceCanvas() {
        Canvas(
            modifier = Modifier.size(300.dp),
            onDraw = {
                // Head
                drawCircle(
                    Brush.radialGradient(
                        colors = listOf(Color.Black, Color.White)
                    ),
                    radius = size.width / 2,
                    center = center,
                )

                // Smile
                val smilePadding = size.width * 0.15f
                drawArc(
                    color = Color.Red,
                    startAngle = 0f,
                    sweepAngle = 180f,
                    useCenter = true,
                    topLeft = Offset(smilePadding, smilePadding),
                    size = Size(size.width - (smilePadding * 2f), size.height - (smilePadding * 2f))
                )

                // Left eye
                drawRect(
                    color = Color.White,
                    topLeft = Offset(size.width * 0.25f, size.height / 4),
                    size = Size(smilePadding, smilePadding)
                )

                // Right eye
                drawRect(
                    color = Color.White,
                    topLeft = Offset((size.width * 0.75f) - smilePadding, size.height / 4),
                    size = Size(smilePadding, smilePadding)
                )

                var foo:List<Pair<Float, Float>> = listOf(
                   Pair(150f,150f),
                    Pair(150f, 300f),
                    Pair(300f, 300f),
                    Pair(300f, 150f),
                    Pair(150f, 150f))

                var pathz = Path().apply {
                    moveTo(50f, 50f)
                    lineTo(50f, 200f)
                    lineTo(200f, 200f)
                    lineTo(200f, 50f)
                    lineTo(50f, 50f)
                    close()

                }

                var pathx = Path().apply {
                    moveTo(150f, 150f)
                    foo.forEach{
                        lineTo(it.first, it.second)
                    }
                    close()
                }

                drawPath(
                    path = pathz,
                    color = Color.Green,
                    alpha = 1f,
                    style = Stroke(30f)
                )

                drawPath(
                    path = pathx,
                    color = Color.Black,
                    alpha = 0.5f,
                    style = Stroke(25f)
                )
            }
        )
    }

}


