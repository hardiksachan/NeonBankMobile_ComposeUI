package com.hardiksachan.neonbankmobile_composeui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hardiksachan.neonbankmobile_composeui.R
import com.hardiksachan.neonbankmobile_composeui.ui.theme.*

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            GreetingSection(
                painterResource(id = R.drawable.face),
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            StatsSection(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(48.dp))
            SearchBar(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(72.dp))
            CardsSection()
        }
    }
}

@Composable
fun GreetingSection(
    imagePainter: Painter,
    modifier: Modifier = Modifier,
    name: String = "HARDIK"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Welcome back,",
                style = Typography.body1
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = name,
                style = Typography.h1
            )
        }
        Image(
            painter = imagePainter,
            contentDescription = "User image",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            contentScale = ContentScale.FillWidth,
        )
    }
}

@Composable
fun StatsSection(
    modifier: Modifier = Modifier,
    budget: String = "16378",
    spent: String = "10189"
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        StatsTile(title = "TOTAL BUDGET", amount = budget, modifier = Modifier.weight(1f))
        Divider(
            color = GrayBrown.copy(alpha = 0.2f),
            modifier = Modifier
                .width((0.3).dp)
                .fillMaxHeight(0.9f),

            )
        StatsTile(
            title = "TOTAL SPENT",
            amount = spent,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun StatsTile(
    title: String,
    amount: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            style = Typography.caption
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = "$$amount",
            style = TextStyle(
                color = GrayBrown,
                fontSize = 36.sp,
                fontFamily = yomogi
            ),
        )
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(24.dp),
        color = Color(0xff161924),
        contentColor = TextWhite,
        elevation = 4.dp,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        var searchState by remember {
            mutableStateOf("")
        }

        TextField(
            modifier = Modifier,
            value = searchState,
            onValueChange = { searchState = it },
            textStyle = Typography.body1.copy(color = TextWhite),
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search Icon",
                    colorFilter = ColorFilter.tint(TextWhite.copy(alpha = 0.8f)),
                    modifier = Modifier.padding(start = 16.dp).padding(12.dp)
                )
            },
            placeholder = {
                Text(text = "SEARCH", style = Typography.caption)
            }
        )
    }
}


@Composable
fun CardsSection() {

}