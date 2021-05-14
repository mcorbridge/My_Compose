package com.example.mycompose.nhl

import androidx.compose.ui.graphics.Color

class TeamColors {

    val Anaheim: TeamColor = TeamColor(
        Color(1, 1, 1, 256),
        Color(181, 152, 90, 256),
        Color(249, 86, 2, 256),
        Color(164, 169, 173, 256)
    )

    val Arizona: TeamColor = TeamColor(
        Color(1, 1, 1, 256),
        Color(181, 152, 90, 256),
        Color(249, 86, 2, 256),
    )

    val Boston: TeamColor = TeamColor(
        Color(252,181,20, 256),
        Color(17,17,17, 256),
    )

    val Buffalo: TeamColor = TeamColor(
        Color(0,38,84, 256),
        Color(252,181,20, 256),
        Color(173,175,170, 256)
    )

    val Calgary : TeamColor = TeamColor(
        Color(200,16,46, 256),
        Color(241, 190, 72, 256),
        Color(17,17,17, 256)
    )

    val Carolina  : TeamColor = TeamColor(
        Color(226,24,54, 256),
        Color(35,31,32, 256),
        Color(162,170,173, 256),
        Color(118,35,47, 256)
    )

    val Chicago   : TeamColor = TeamColor(
        Color(207,10,44, 256),
        Color(255,103,27, 256),
        Color(0,131,62, 256),
        Color(255,209,0, 256)
    )

    val Colorado   : TeamColor = TeamColor(
        Color(111, 38, 61, 256),
        Color(35, 97, 146, 256),
        Color(162, 170, 173, 256),
        Color(20, 0, 0, 256)
    )

    val Columbus    : TeamColor = TeamColor(
        Color(0,38,84, 256),
        Color(206,17,38, 256),
        Color(164,169,173, 256),
    )

    val Dallas     : TeamColor = TeamColor(
        Color(0,104,71, 256),
        Color(143,143,140, 256),
        Color(17,17,17, 256),
    )

    val Detroit      : TeamColor = TeamColor(
        Color(206,17,38, 256),
        Color(255,255,255, 256),
    )

}

data class TeamColor(
    val primaryColor: Color,
    val secondaryColor: Color,
    val tertiaryColor: Color? = null,
    val quaternaryColor: Color? = null,
    val quinaryColor: Color? = null
)