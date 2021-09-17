package com.hardiksachan.neonbankmobile_composeui.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hardiksachan.neonbankmobile_composeui.R

val montserrat = FontFamily(
    listOf(
        Font(R.font.montserrat_bold, FontWeight.Bold),
        Font(R.font.montserrat_extra_light, FontWeight.ExtraLight),
        Font(R.font.montserrat_light, FontWeight.Light),
        Font(R.font.montserrat_medium, FontWeight.Medium),
        Font(R.font.montserrat_regular, FontWeight.Normal),
        Font(R.font.montserrat_semi_bold, FontWeight.SemiBold),
        Font(R.font.montserrat_thin, FontWeight.Thin),
    )
)

val yomogi = FontFamily(
    listOf(
        Font(R.font.yomogi_regular, FontWeight.Normal)
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        color = GrayBrown,
        fontFamily = montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    h1 = TextStyle(
        color = GrayBrown,
        fontFamily = montserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    caption = TextStyle(
        color = TextWhite,
        fontFamily = montserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        letterSpacing = 2.sp
    )
)