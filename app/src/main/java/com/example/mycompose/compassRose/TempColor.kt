package com.example.mycompose.compassRose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class TempColor {

    @Composable
    fun Test() {

        var testColor = Color(0xFFF47A38)
        var altTestColor = Color(AltStandardColors.T_0_m5.stndColor)

        Row {

            Column {
                StandardColors.values().forEach {
                    Box(
                        modifier = Modifier
                            .background(color = it.stndColor)
                            .height(10.dp)
                            .width(100.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                AltStandardColors.values().forEach {
                    Box(
                        modifier = Modifier
                            .background(color = Color(it.stndColor))
                            .height(10.dp)
                            .width(100.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column{
                for (i in 115 downTo -5 step 6){
                    println(i)
                    Box(
                        modifier = Modifier
                            .background(color = getTempColorFromTemp(i))
                            .height(10.dp)
                            .width(10.dp)
                    )
                }
            }

            Column{
                for (i in 115 downTo -5 step 5){
                    println(i)
                    Box(
                        modifier = Modifier
                            .background(color = getTempColorFromTemp(i))
                            .height(10.dp)
                            .width(10.dp)
                    )
                }
            }

            Column{
                for (i in 115 downTo -5 step 4){
                    println(i)
                    Box(
                        modifier = Modifier
                            .background(color = getTempColorFromTemp(i))
                            .height(10.dp)
                            .width(10.dp)
                    )
                }
            }

            Column{
                for (i in 115 downTo -5 step 3){
                    println(i)
                    Box(
                        modifier = Modifier
                            .background(color = getTempColorFromTemp(i))
                            .height(10.dp)
                            .width(10.dp)
                    )
                }
            }
        }
    }

    fun getTempColorFromTemp(temp: Int): Color {
        return when {
            temp > 110 -> StandardColors.T_GRT_110.stndColor
            temp in 110 downTo 105 -> StandardColors.T_110_105.stndColor
            temp in 104 downTo 100 -> StandardColors.T_105_100.stndColor
            temp in 99 downTo 95 -> StandardColors.T_100_95.stndColor
            temp in 94 downTo 90 -> StandardColors.T_95_90.stndColor
            temp in 89 downTo 85 -> StandardColors.T_90_85.stndColor
            temp in 84 downTo 80 -> StandardColors.T_85_80.stndColor
            temp in 79 downTo 75 -> StandardColors.T_80_75.stndColor
            temp in 74 downTo 70 -> StandardColors.T_75_70.stndColor
            temp in 69 downTo 65 -> StandardColors.T_70_65.stndColor
            temp in 64 downTo 60 -> StandardColors.T_65_60.stndColor
            temp in 59 downTo 55 -> StandardColors.T_60_55.stndColor
            temp in 54 downTo 50 -> StandardColors.T_55_50.stndColor
            temp in 49 downTo 45 -> StandardColors.T_50_45.stndColor
            temp in 44 downTo 40 -> StandardColors.T_45_40.stndColor
            temp in 39 downTo 35 -> StandardColors.T_40_35.stndColor
            temp in 34 downTo 30 -> StandardColors.T_35_30.stndColor
            temp in 29 downTo 25 -> StandardColors.T_30_25.stndColor
            temp in 24 downTo 20 -> StandardColors.T_25_20.stndColor
            temp in 19 downTo 15 -> StandardColors.T_20_15.stndColor
            temp in 14 downTo 10 -> StandardColors.T_15_10.stndColor
            temp in 9 downTo 5 -> StandardColors.T_10_5.stndColor
            temp in 4 downTo 0 -> StandardColors.T_5_0.stndColor
            temp in -1 downTo -5 -> StandardColors.T_0_m5.stndColor
            else -> Color.Black
        }
    }
}


enum class StandardColors(val stndColor: Color) {
    T_GRT_110(Color(0xfffdf0f0)), // wicked hot!
    T_110_105(Color(0xfffac8dc)),
    T_105_100(Color(0xfff0273c)),
    T_100_95(Color(0xff8c0101)),
    T_95_90(Color(0xffb42703)),
    T_90_85(Color(0xffdc5004)),
    T_85_80(Color(0xfff08c12)),
    T_80_75(Color(0xfff7b429)),
    T_75_70(Color(0xfff5dd5a)),
    T_70_65(Color(0xfff9f673)),
    T_65_60(Color(0xfffafba0)),
    T_60_55(Color(0xffb4ffb5)),
    T_55_50(Color(0xff8cff8c)),
    T_50_45(Color(0xff64e764)),
    T_45_40(Color(0xff3ec805)),
    T_40_35(Color(0xff32a131)),
    T_35_30(Color(0xff217802)),
    T_30_25(Color(0xff96e7fe)),
    T_25_20(Color(0xff41b5fd)),
    T_20_15(Color(0xff338cf0)),
    T_15_10(Color(0xff233cfd)),
    T_10_5(Color(0xff1400c8)),
    T_5_0(Color(0xff0c0096)),
    T_0_m5(Color(0xff8c01af)), // wicked cold!
}

enum class AltStandardColors(val stndColor: Long) {
    T_GRT_110(0xfffdf0f0),
    T_110_105(0xfffac8dc),
    T_105_100(0xfff0273c),
    T_100_95(0xff8c0101),
    T_95_90(0xffb42703),
    T_90_85(0xffdc5004),
    T_85_80(0xfff08c12),
    T_80_75(0xfff7b429),
    T_75_70(0xfff5dd5a),
    T_70_65(0xfff9f673),
    T_65_60(0xfffafba0),
    T_60_55(0xffb4ffb5),
    T_55_50(0xff8cff8c),
    T_50_45(0xff64e764),
    T_45_40(0xff3ec805),
    T_40_35(0xff32a131),
    T_35_30(0xff217802),
    T_30_25(0xff96e7fe),
    T_25_20(0xff41b5fd),
    T_20_15(0xff338cf0),
    T_15_10(0xff233cfd),
    T_10_5(0xff1400c8),
    T_5_0(0xff0c0096),
    T_0_m5(0xff8c01af),
}

