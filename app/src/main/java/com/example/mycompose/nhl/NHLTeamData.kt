package com.example.mycompose.nhl

import androidx.compose.ui.graphics.Color
import com.example.mycompose.R

class NHLTeamData {

    var listTeam: MutableList<TeamData> = mutableListOf()

    val Anaheim: TeamData = TeamData(
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

    val Arizona: TeamData = TeamData(
        "Arizona",
        "Arizona Coyotes",
        R.drawable.ari_d,
        mutableListOf(
            Color(0xFF8C2633),
            Color(0xFFE2D6B5),
            Color(0xFF111111),
            Color(0xFFFFFFFF)
        ),
    )

    val Boston: TeamData = TeamData(
        "Boston",
        "Boston Bruins",
        R.drawable.bos_d,
        mutableListOf(
            Color(0xFFFFB81C),
            Color(0xFF000000),
            Color(0xFFFFFFFF)
        ),
    )

    val Buffalo: TeamData = TeamData(
        "Buffalo",
        "Buffalo Sabres",
        R.drawable.buf_d,
        mutableListOf(
            Color(0xFF002654),
            Color(0xFFFCB514),
            Color(0xFFADAFAA),
            Color(0xFFC8102E)
        ),
    )

    val Calgary: TeamData = TeamData(
        "Calgary",
        "Calgary Flames",
        R.drawable.cgy_d,
        mutableListOf(
            Color(0xFFC8102E),
            Color(0xFFF1BE48),
            Color(0xFF111111),
            Color(0xFFFFFFFF)
        ),
    )

    val Carolina: TeamData = TeamData(
        "Carolina",
        "Carolina Hurricanes",
        R.drawable.car_d,
        mutableListOf(
            Color(0xFFCC0000),
            Color(0xFF000000),
            Color(0xFFA2AAAD),
            Color(0xFF76232F)
        ),
    )

    val Chicago: TeamData = TeamData(
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
        ),
    )

    val Colorado: TeamData = TeamData(
        "Colorado",
        "Colorado Avalanche",
        R.drawable.col_d,
        mutableListOf(
            Color(0xFF6F263D),
            Color(0xFF236192),
            Color(0xFFA2AAAD),
            Color(0xFF000000),
            Color(0xFFFFFFFF)
        ),
    )

    val Columbus: TeamData = TeamData(
        "Columbus",
        "Columbus Blue Jackets",
        R.drawable.cbj_d,
        mutableListOf(
            Color(0xFF002654),
            Color(0xFFCE1126),
            Color(0xFFA4A9AD),
            Color(0xFFFFFFFF)
        ),
    )

    val Dallas: TeamData = TeamData(
        "Dallas",
        "Dallas Stars",
        R.drawable.dal_d,
        mutableListOf(
            Color(0xFF006847),
            Color(0xFF8F8F8C),
            Color(0xFF111111),
            Color(0xFFFFFFFF)
        ),
    )

    val Detroit: TeamData = TeamData(
        "Detroit",
        "Detroit Red Wings",
        R.drawable.det_d,
        mutableListOf(
            Color(0xFFCE1126),
            Color(0xFFFFFFFF)
        ),
    )

    val Edmonton: TeamData = TeamData(
        "Edmonton",
        "Edmonton Oilers",
        R.drawable.edm_d,
        mutableListOf(
            Color(0xFF041E42),
            Color(0xFFFF4C00),
            Color(0xFFFFFFFF)
        ),
    )

    val Florida: TeamData = TeamData(
        "Florida",
        "Florida Panthers",
        R.drawable.fla_d,
        mutableListOf(
            Color(0xFF041E42),
            Color(0xFFC8102E),
            Color(0xFFB9975B),
            Color(0xFFFFFFFF)
        ),
    )

    val LosAngeles: TeamData = TeamData(
        "LosAngeles",
        "Los Angeles Kings",
        R.drawable.lak_d,
        mutableListOf(
            Color(0xFF111111),
            Color(0xFFA2AAAD),
            Color(0xFFFFFFFF)
        ),
    )

    val Minnesota: TeamData = TeamData(
        "Minnesota",
        "Minnesota Wild",
        R.drawable.min_d,
        mutableListOf(
            Color(0xFFA6192E),
            Color(0xFF154734),
            Color(0xFFEAAA00),
            Color(0xFFDDCBA4),
            Color(0xFFFFFFFF)
        ),
    )

    val Montreal: TeamData = TeamData(
        "Montreal",
        "Montreal Canadiens",
        R.drawable.mtl_l,
        mutableListOf(
            Color(0xFFAF1E2D),
            Color(0xFF192168),
            Color(0xFFFFFFFF)
        ),
    )

    val Nashville: TeamData = TeamData(
        "Nashville",
        "Nashville Predators",
        R.drawable.nsh_d,
        mutableListOf(
            Color(0xFFFFB81C),
            Color(0xFF041E42),
            Color(0xFFFFFFFF)
        ),
    )

    val NewJersey: TeamData = TeamData(
        "NewJersey",
        "New Jersey Devils",
        R.drawable.njd_d,
        mutableListOf(
            Color(0xFFCE1126),
            Color(0xFF000000),
            Color(0xFFFFFFFF)
        ),
    )

    val NewYorkIslanders: TeamData = TeamData(
        "NewYorkIslanders",
        "New York Islanders",
        R.drawable.nyi_d,
        mutableListOf(
            Color(0xFF00539B),
            Color(0xFFF47D30),
            Color(0xFFFFFFFF)
        ),
    )

    val NewYorkRangers: TeamData = TeamData(
        "NewYorkRangers",
        "New York Rangers",
        R.drawable.nyr_d,
        mutableListOf(
            Color(0xFF0038A8),
            Color(0xFFCE1126),
            Color(0xFFFFFFFF)
        ),
    )

    val Ottawa: TeamData = TeamData(
        "Ottawa",
        "Ottawa Senators",
        R.drawable.ott_d,
        mutableListOf(
            Color(0xFFC52032),
            Color(0xFFC2912C),
            Color(0xFF000000),
            Color(0xFFFFFFFF)
        ),
    )

    val Philadelphia: TeamData = TeamData(
        "Philadelphia",
        "Philadelphia Flyers",
        R.drawable.phi_d,
        mutableListOf(
            Color(0xFFF74902),
            Color(0xFF000000),
            Color(0xFFFFFFFF)
        ),
    )

    val Pittsburgh: TeamData = TeamData(
        "Pittsburgh",
        "Pittsburgh Penguins",
        R.drawable.pit_d,
        mutableListOf(
            Color(0xFF000000),
            Color(0xFFCFC493),
            Color(0xFFFCB514),
            Color(0xFFFFFFFF)
        ),
    )

    val StLouis: TeamData = TeamData(
        "StLouis",
        "St. Louis Blues",
        R.drawable.stl_l,
        mutableListOf(
            Color(0xFF002F87),
            Color(0xFFFCB514),
            Color(0xFF041E42),
            Color(0xFFFFFFFF)
        ),
    )

    val SanJose: TeamData = TeamData(
        "SanJose",
        "San Jose Sharks",
        R.drawable.sjs_d,
        mutableListOf(
            Color(0xFF006D75),
            Color(0xFFEA7200),
            Color(0xFF000000),
            Color(0xFFFFFFFF)
        ),
    )

    val Seattle: TeamData = TeamData(
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
        ),
    )

    val TampaBay: TeamData = TeamData(
        "TampaBay",
        "Tampa Bay Lightning",
        R.drawable.tbl_l,
        mutableListOf(
            Color(0xFF002868),
            Color(0xFFFFFFFF)
        ),
    )

    val Toronto: TeamData = TeamData(
        "Toronto",
        "Toronto Maple Leafs",
        R.drawable.tor_l,
        mutableListOf(
            Color(0xFF00205B),
            Color(0xFFFFFFFF)
        ),
    )

    val Vancouver: TeamData = TeamData(
        "Vancouver",
        "Vancouver Canucks",
        R.drawable.van_l,
        mutableListOf(
            Color(0xFF00205B),
            Color(0xFF00843D),
            Color(0xFF041C2C),
            Color(0xFF99999A),
            Color(0xFFFFFFFF)
        ),
    )

    val Vegas: TeamData = TeamData(
        "Vegas",
        "Las Vegas Golden Knights",
        R.drawable.vgk_l,
        mutableListOf(
            Color(0xFFB4975A),
            Color(0xFF333F42),
            Color(0xFFC8102E),
            Color(0xFF000000),
            Color(0xFFFFFFFF)
        ),
    )

    val Washington: TeamData = TeamData(
        "Washington",
        "Washington Capitals",
        R.drawable.wsh_l,
        mutableListOf(
            Color(0xFF041E42),
            Color(0xFFC8102E),
            Color(0xFFFFFFFF)
        ),
    )

    val Winnipeg: TeamData = TeamData(
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
        ),
    )


    fun setTeams() {
        listTeam.add(Anaheim)
        listTeam.add(Arizona)
        listTeam.add(Boston)
        listTeam.add(Buffalo)
        listTeam.add(Calgary)
        listTeam.add(Carolina)
        listTeam.add(Chicago)
        listTeam.add(Colorado)
        listTeam.add(Columbus)
        listTeam.add(Dallas)
        listTeam.add(Detroit)
        listTeam.add(Edmonton)
        listTeam.add(Florida)
        listTeam.add(LosAngeles)
        listTeam.add(Minnesota)
        listTeam.add(Montreal)
        listTeam.add(Nashville)
        listTeam.add(NewJersey)
        listTeam.add(NewYorkIslanders)
        listTeam.add(NewYorkRangers)
        listTeam.add(Ottawa)
        listTeam.add(Philadelphia)
        listTeam.add(Pittsburgh)
        listTeam.add(StLouis)
        listTeam.add(SanJose)
        listTeam.add(Seattle)
        listTeam.add(TampaBay)
        listTeam.add(Toronto)
        listTeam.add(Vancouver)
        listTeam.add(Vegas)
        listTeam.add(Washington)
        listTeam.add(Winnipeg)
    }


}



data class TeamData(
    val primaryName: String,
    val displayName: String,
    val logo: Int,
    val listColors: MutableList<Color>,
)