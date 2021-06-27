package com.example.mycompose.compassRose


/**
 * Convert degrees to compass bearing (one of 16 bearings)
 */

class Bearing {

    companion object {

        fun findBearing(deg: Float?): String {

            val points = 11.25

            var bearing = "X"

            if (deg != null) {
                bearing = when {
                    deg > 0 && deg <= points -> "N"
                    deg > points && deg <= points * 3 -> "NNE"
                    deg > (points * 3) && deg <= (points * 5) -> "NE"
                    deg > (points * 5) && deg <= (points * 7) -> "ENE"
                    deg > (points * 7) && deg <= (points * 9) -> "E"
                    deg > (points * 9) && deg <= (points * 11) -> "ESE"
                    deg > (points * 11) && deg <= (points * 13) -> "SE"
                    deg > (points * 13) && deg <= (points * 15) -> "SSE"
                    deg > (points * 15) && deg <= (points * 17) -> "S"
                    deg > (points * 17) && deg <= (points * 19) -> "SSW"
                    deg > (points * 19) && deg <= (points * 21) -> "SW"
                    deg > (points * 21) && deg <= (points * 23) -> "WSW"
                    deg > (points * 23) && deg <= (points * 25) -> "W"
                    deg > (points * 25) && deg <= (points * 27) -> "WNW"
                    deg > (points * 27) && deg <= (points * 29) -> "NW"
                    deg > (points * 29) && deg <= (points * 31) -> "NNW"
                    deg > (points * 31) && deg <= (points * 32) -> "N"
                    else -> "X"
                }
            }
            return bearing
        }
    } // end companion object

} // end class