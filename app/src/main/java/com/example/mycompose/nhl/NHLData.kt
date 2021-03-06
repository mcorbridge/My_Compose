package com.example.mycompose.nhl

import androidx.compose.ui.graphics.Color
import com.example.mycompose.R

enum class NHLData(val teamData: TeamData) {
    ANAHEIM(
        TeamData(
            "Anaheim",
            "Anaheim Ducks",
            R.drawable.ana_d,
            mutableListOf(
                Color(0xFFF47A38),
                Color(0xFFB9975B),
                Color(0xFFC1C6C8),
                Color(0xFF000000),
                Color(0xFFFFFFFF)
            )
        )
    ),
    ARIZONA(
        TeamData(
            "Arizona",
            "Arizona Coyotes",
            R.drawable.ari_d,
            mutableListOf(
                Color(0xFF8C2633),
                Color(0xFFE2D6B5),
                Color(0xFF111111),
                Color(0xFFFFFFFF)
            )
        )
    ),
    BOSTON(
        TeamData(
            "Boston",
            "Boston Bruins",
            R.drawable.bos_d,
            mutableListOf(
                Color(0xFFFFB81C),
                Color(0xFF000000),
                Color(0xFFFFFFFF)
            )
        )
    ),
    BUFFALO(
        TeamData(
            "Buffalo",
            "Buffalo Sabres",
            R.drawable.buf_d,
            mutableListOf(
                Color(0xFF002654),
                Color(0xFFFCB514),
                Color(0xFFADAFAA),
                Color(0xFFC8102E)
            )
        )
    ),
    CALGARY(
        TeamData(
            "Calgary",
            "Calgary Flames",
            R.drawable.cgy_d,
            mutableListOf(
                Color(0xFFC8102E),
                Color(0xFFF1BE48),
                Color(0xFF111111),
                Color(0xFFFFFFFF)
            )
        )
    ),
    CAROLINA(
        TeamData(
            "Carolina",
            "Carolina Hurricanes",
            R.drawable.car_d,
            mutableListOf(
                Color(0xFFCC0000),
                Color(0xFF000000),
                Color(0xFFA2AAAD),
                Color(0xFF76232F),
                Color(0xFFFFFFFF)
            )
        )
    ),
    CHICAGO(
        TeamData(
            "Chicago",
            "Chicago Black Hawks",
            R.drawable.chi_d,
            mutableListOf(
                Color(0xFFCF0A2C),
                Color(0xFFFF671B),
                Color(0xFF00833E),
                Color(0xFFFFD100),
                Color(0xFFD18A00),
                Color(0xFF001970),
                Color(0xFF000000),
                Color(0xFFFFFFFF)
            )
        )
    ),
    COLORADO(
        TeamData(
            "Colorado",
            "Colorado Avalanche",
            R.drawable.col_d,
            mutableListOf(
                Color(0xFF6F263D),
                Color(0xFF236192),
                Color(0xFFA2AAAD),
                Color(0xFF000000),
                Color(0xFFFFFFFF)
            )
        )
    ),
    COLUMBUS(
        TeamData(
            "Columbus",
            "Columbus Blue Jackets",
            R.drawable.cbj_d,
            mutableListOf(
                Color(0xFF002654),
                Color(0xFFCE1126),
                Color(0xFFA4A9AD),
                Color(0xFFFFFFFF)
            )
        )
    ),
    DALLAS(
        TeamData(
            "Dallas",
            "Dallas Stars",
            R.drawable.dal_d,
            mutableListOf(
                Color(0xFF006847),
                Color(0xFF8F8F8C),
                Color(0xFF111111),
                Color(0xFFFFFFFF)
            )
        )
    ),
    DETROIT(
        TeamData(
            "Detroit",
            "Detroit Red Wings",
            R.drawable.det_d,
            mutableListOf(
                Color(0xFFCE1126),
                Color(0xFFFFFFFF)
            )
        )
    ),
    EDMONTON(
        TeamData(
            "Edmonton",
            "Edmonton Oilers",
            R.drawable.edm_d,
            mutableListOf(
                Color(0xFF041E42),
                Color(0xFFFF4C00),
                Color(0xFFFFFFFF)
            )
        )
    ),
    FLORIDA(
        TeamData(
            "Florida",
            "Florida Panthers",
            R.drawable.fla_d,
            mutableListOf(
                Color(0xFF041E42),
                Color(0xFFC8102E),
                Color(0xFFB9975B),
                Color(0xFFFFFFFF)
            )
        )
    ),
    LOSANGELES(
        TeamData(
            "LosAngeles",
            "Los Angeles Kings",
            R.drawable.lak_d,
            mutableListOf(
                Color(0xFF111111),
                Color(0xFFA2AAAD),
                Color(0xFFFFFFFF)
            )
        )
    ),
    MINNESOTA(
        TeamData(
            "Minnesota",
            "Minnesota Wild",
            R.drawable.min_d,
            mutableListOf(
                Color(0xFFA6192E),
                Color(0xFF154734),
                Color(0xFFEAAA00),
                Color(0xFFDDCBA4),
                Color(0xFFFFFFFF)
            )
        )
    ),
    MONTREAL(
        TeamData(
            "Montreal",
            "Montreal Canadiens",
            R.drawable.mtl_l,
            mutableListOf(
                Color(0xFFAF1E2D),
                Color(0xFF192168),
                Color(0xFFFFFFFF)
            )
        )
    ),
    NASHVILLE(
        TeamData(
            "Nashville",
            "Nashville Predators",
            R.drawable.nsh_d,
            mutableListOf(
                Color(0xFFFFB81C),
                Color(0xFF041E42),
                Color(0xFFFFFFFF)
            )
        )
    ),
    NEWJERSEY(
        TeamData(
            "NewJersey",
            "New Jersey Devils",
            R.drawable.njd_d,
            mutableListOf(
                Color(0xFFCE1126),
                Color(0xFF000000),
                Color(0xFFFFFFFF)
            )
        )
    ),
    NEWYORKISLANDERS(
        TeamData(
            "NewYorkIslanders",
            "New York Islanders",
            R.drawable.nyi_d,
            mutableListOf(
                Color(0xFF00539B),
                Color(0xFFF47D30),
                Color(0xFFFFFFFF)
            )
        )
    ),
    NEWYORKRANGERS(
        TeamData(
            "NewYorkRangers",
            "New York Rangers",
            R.drawable.nyr_d,
            mutableListOf(
                Color(0xFF0038A8),
                Color(0xFFCE1126),
                Color(0xFFFFFFFF)
            )
        )
    ),
    OTTAWA(
        TeamData(
            "Ottawa",
            "Ottawa Senators",
            R.drawable.ott_d,
            mutableListOf(
                Color(0xFFC52032),
                Color(0xFFC2912C),
                Color(0xFF000000),
                Color(0xFFFFFFFF)
            )
        )
    ),
    PHILADELPHIA(
        TeamData(
            "Philadelphia",
            "Philadelphia Flyers",
            R.drawable.phi_d,
            mutableListOf(
                Color(0xFFF74902),
                Color(0xFF000000),
                Color(0xFFFFFFFF)
            )
        )
    ),
    PITTSBURGH(
        TeamData(
            "Pittsburgh",
            "Pittsburgh Penguins",
            R.drawable.pit_d,
            mutableListOf(
                Color(0xFF000000),
                Color(0xFFCFC493),
                Color(0xFFFCB514),
                Color(0xFFFFFFFF)
            )
        )
    ),
    STLOUIS(
        TeamData(
            "StLouis",
            "St. Louis Blues",
            R.drawable.stl_l,
            mutableListOf(
                Color(0xFF002F87),
                Color(0xFFFCB514),
                Color(0xFF041E42),
                Color(0xFFFFFFFF)
            )
        )
    ),
    SANJOSE(
        TeamData(
            "SanJose",
            "San Jose Sharks",
            R.drawable.sjs_d,
            mutableListOf(
                Color(0xFF006D75),
                Color(0xFFEA7200),
                Color(0xFF000000),
                Color(0xFFFFFFFF)
            )
        )
    ),
    SEATTLE(
        TeamData(
            "Seattle",
            "Seattle Kraken",
            R.drawable.sea,
            mutableListOf(
                Color(0xFF001628),
                Color(0xFF99D9D9),
                Color(0xFF355464),
                Color(0xFF68A2B9),
                Color(0xFFE9072B),
                Color(0xFFFFFFFF)
            )
        )
    ),
    TAMPABAY(
        TeamData(
            "TampaBay",
            "Tampa Bay Lightning",
            R.drawable.tbl_l,
            mutableListOf(
                Color(0xFF002868),
                Color(0xFFFFFFFF)
            )
        )
    ),
    TORONTO(
        TeamData(
            "Toronto",
            "Toronto Maple Leafs",
            R.drawable.tor_l,
            mutableListOf(
                Color(0xFF00205B),
                Color(0xFFFFFFFF)
            )
        )
    ),
    VANCOUVER(
        TeamData(
            "Vancouver",
            "Vancouver Canucks",
            R.drawable.van_l,
            mutableListOf(
                Color(0xFF00205B),
                Color(0xFF00843D),
                Color(0xFF041C2C),
                Color(0xFF99999A),
                Color(0xFFFFFFFF)
            )
        )
    ),
    LASVEGAS(
        TeamData(
            "Vegas",
            "Las Vegas Golden Knights",
            R.drawable.vgk_l,
            mutableListOf(
                Color(0xFFB4975A),
                Color(0xFF333F42),
                Color(0xFFC8102E),
                Color(0xFF000000),
                Color(0xFFFFFFFF)
            )
        )
    ),
    WASHINGTON(
        TeamData(
            "Washington",
            "Washington Capitals",
            R.drawable.wsh_l,
            mutableListOf(
                Color(0xFF041E42),
                Color(0xFFC8102E),
                Color(0xFFFFFFFF)
            )
        )
    ),
    WINNIPEG(
        TeamData(
            "Winnipeg",
            "Winnipeg Jets",
            R.drawable.wpg_l,
            mutableListOf(
                Color(0xFF041E42),
                Color(0xFF004C97),
                Color(0xFFAC162C),
                Color(0xFF7B303E),
                Color(0xFF55565A),
                Color(0xFF8E9090),
                Color(0xFFFFFFFF)
            )
        )
    ),
}