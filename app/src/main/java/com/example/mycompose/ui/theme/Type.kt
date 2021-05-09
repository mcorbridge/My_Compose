package com.example.mycompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mycompose.R

// Set of Material typography styles to start with
/*val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
     Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

)*/

val Cormorant = FontFamily(
    fonts = listOf(
        Font(resId = R.font.amatic_bold, weight=FontWeight.W100, style=FontStyle.Normal),
        Font(resId = R.font.amaticsc_regular, weight=FontWeight.W200, style=FontStyle.Normal),
        Font(resId = R.font.cormorant_unicase_regular, weight=FontWeight.W300, style=FontStyle.Normal),
        Font(resId = R.font.cormorant_unicase_bold, weight=FontWeight.W400, style=FontStyle.Normal),
    )
)

val CormorantTypography = Typography(
   h1 = TextStyle(
        fontFamily = Cormorant,
        fontWeight = FontWeight.W100,
        fontSize = 60.sp
    ),
    h2 = TextStyle(
        fontFamily = Cormorant,
        fontWeight = FontWeight.W200,
        fontSize = 40.sp
    ),
    h3 = TextStyle(
        fontFamily = Cormorant,
        fontWeight = FontWeight.W300,
        fontSize = 50.sp
    ),
    h4 = TextStyle(
        fontFamily = Cormorant,
        fontWeight = FontWeight.W400,
        fontSize = 60.sp
    ),
    button = TextStyle(
        fontFamily = Cormorant,
        fontWeight = FontWeight.W400,
        fontSize = 20.sp
    )
)