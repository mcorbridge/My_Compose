package com.example.mycompose.compassRose

import androidx.compose.foundation.background
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
        }
    }
}


enum class StandardColors(val stndColor: Color) {

    T_GRT_110(Color(0xfffdf0f0)),
    T_110_105(Color(0xfffac8dc)),
    T_105_100(Color(0xfff0273c)),
    T_100_95(Color(0xff8c0101)),
    T_95_90(Color(0xffb42703)),
    T_90_85(Color(0xffdc5004)),
    T_85_80(Color(0xfff08c12)),
    T_80_75(Color(0xfff7b429)),
    T_75_70(Color(0xfff5dd5a)),
    T_70_65(Color(0xfff9f673)),
    T_60_55(Color(0xffb4ffb5)),
    T_55_50(Color(0xff8cff8c)),
    T_50_45(Color(0xff64e764)),
    T_45_40(Color(0xff3ec805)),
    T_40_35(Color(0xff32a131)),
    T_35_30(Color(0xff217802)),
    T_30_25(Color(0xff96e7fe)),
    T_20_15(Color(0xff338cf0)),
    T_15_10(Color(0xff233cfd)),
    T_10_5(Color(0xff1400c8)),
    T_5_0(Color(0xff0c0096)),
    T_0_m5(Color(0xff8c01af)),

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
    T_60_55(0xffb4ffb5),
    T_55_50(0xff8cff8c),
    T_50_45(0xff64e764),
    T_45_40(0xff3ec805),
    T_40_35(0xff32a131),
    T_35_30(0xff217802),
    T_30_25(0xff96e7fe),
    T_20_15(0xff338cf0),
    T_15_10(0xff233cfd),
    T_10_5(0xff1400c8),
    T_5_0(0xff0c0096),
    T_0_m5(0xff8c01af),

}

