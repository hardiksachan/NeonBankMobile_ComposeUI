package com.hardiksachan.neonbankmobile_composeui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import com.hardiksachan.neonbankmobile_composeui.BottomMenuContent
import com.hardiksachan.neonbankmobile_composeui.Card
import com.hardiksachan.neonbankmobile_composeui.R
import com.hardiksachan.neonbankmobile_composeui.linearInclinedGradient
import com.hardiksachan.neonbankmobile_composeui.ui.theme.*

val cards = listOf<Card>(
    Card(
        2345,
        "Debit Card",
        1234,
        Color(0xffe11218)
    ),
    Card(
        1234,
        "Credit Card",
        23456,
        Color(0xff000080)
    )
)

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(16.dp),
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
            Spacer(modifier = Modifier.height(48.dp))
            CardsSection(cards = cards)
        }
        BottomBar(
            items = listOf(
                BottomMenuContent(R.drawable.ic_pie),
                BottomMenuContent(R.drawable.ic_wallet),
                BottomMenuContent(R.drawable.ic_chat)
            ), modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun BottomBar(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = Red,
    inactiveHighlightColor: Color = Color(0xff232323),
    activeTextColor: Color = TextWhite,
    inactiveTextColor: Color = GrayBrown,
    initialSelectedItemIndex: Int = 1
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                inactiveHighlightColor = inactiveHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color,
    inactiveHighlightColor: Color,
    activeTextColor: Color,
    inactiveTextColor: Color,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(CircleShape)
                .background(if (isSelected) activeHighlightColor else inactiveHighlightColor)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = "icon",
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}


@Composable
fun CardsSection(
    cards: List<Card>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "MY CARDS",
                style = Typography.h1
            )
            Divider(
                color = GrayBrown.copy(alpha = 0.2f),
                modifier = Modifier
                    .height((0.5).dp)
                    .fillMaxWidth(0.6f),

                )
            Image(
                painter = painterResource(id = R.drawable.ic_plus),
                contentDescription = "plus icon",
                colorFilter = ColorFilter.tint(TextWhite),
                modifier = Modifier.size(16.dp)
            )
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(cards.size) { index ->
                CardTile(cards[index])
            }
        }
    }
}

@Composable
fun CardTile(
    card: Card
) {
    Surface(
        elevation = 4.dp,
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .height(112.dp)
                .background(
                    linearInclinedGradient(
                        GradientBlack,
                        card.color,
                    )
                )
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                elevation = 8.dp,
                color = Color.Transparent
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .fillMaxHeight(0.8f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(
                            linearInclinedGradient(
                                Color(0xff151515),
                                Black,
                            )
                        )
                        .padding(8.dp)

                ) {
                    Text(
                        text = "*  ${card.cardNumber}",
                        style = Typography.body1
                    )
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = card.title,
                    style = Typography.body1
                )
                Text(
                    text = "$${card.amount}",
                    style = TextStyle(
                        color = GrayBrown,
                        fontSize = 18.sp,
                        fontFamily = yomogi
                    ),
                )
            }
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
                .width((0.5).dp)
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
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(16.dp)
                )
            },
            placeholder = {
                Text(text = "SEARCH", style = Typography.caption)
            }
        )
    }
}