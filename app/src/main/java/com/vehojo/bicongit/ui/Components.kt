package com.vehojo.bicongit.ui

import android.widget.ImageButton
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vehojo.bicongit.R
import com.vehojo.bicongit.navigation.Destination
import com.vehojo.bicongit.ui.theme.Active
import com.vehojo.bicongit.ui.theme.Background
import com.vehojo.bicongit.ui.theme.ButtonColor
import com.vehojo.bicongit.ui.theme.Inactive
import com.vehojo.bicongit.ui.theme.Inter
import com.vehojo.bicongit.ui.theme.Orange
import com.vehojo.bicongit.ui.theme.Purple
import com.vehojo.bicongit.ui.theme.White
import com.vehojo.bicongit.ui.theme.Yellow
import com.vehojo.bicongit.ui.theme.onBackground

@Composable
fun NavBar(
    currentRoute: String?,
    onSearchScreen: () -> Unit,
    onFavoritesScreen: () -> Unit,
    onProfileScreen: () -> Unit
) {
    val selectedIndex = when (currentRoute) {
        Destination.SearchScreen.route -> 0
        Destination.FavoritesScreen.route -> 1
        Destination.ProfileScreen.route -> 2
        else -> 0
    }
    val searchSelected = currentRoute == Destination.SearchScreen.route
    val favoritesSelected = currentRoute == Destination.FavoritesScreen.route
    val profileSelected = currentRoute == Destination.ProfileScreen.route

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(Background)
    ) {
        Spacer(modifier = Modifier.background(onBackground).fillMaxWidth().height(2.dp))
        Spacer(modifier = Modifier.height(12.dp))

        Box {
            BoxWithConstraints(
                modifier = Modifier.fillMaxWidth()
            ) {
                val tabWidth = maxWidth / 3
                val indicatorWidth = tabWidth - 12.dp
                val offset by animateDpAsState(
                    targetValue = tabWidth * selectedIndex,
                    animationSpec = tween(500)
                )
                val extraOffset = when (selectedIndex) {
                    0 -> 24.dp
                    1 -> 3.dp
                    2 -> (-18).dp
                    else -> 0.dp
                }

                Box(
                    modifier = Modifier
                        .offset(x = offset + extraOffset, y = (-6).dp)
                        .width(indicatorWidth)
                        .height(65.dp)
                        .padding(horizontal = 6.dp)
                        .border(
                            width = 2.dp,
                            color = ButtonColor,
                            shape = RoundedCornerShape(16.dp)
                        )
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { onSearchScreen() }) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.search_icon),
                        contentDescription = "search",
                        tint = if (searchSelected) Active else Inactive
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Search",
                        color = if (searchSelected) Active else Inactive,
                        fontSize = 13.sp,
                        fontFamily = Inter,
                        fontWeight = if (searchSelected) FontWeight.SemiBold else FontWeight.Normal
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { onFavoritesScreen() }) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.favorites_icon),
                        contentDescription = "favorites",
                        tint = if (favoritesSelected) Active else Inactive
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Favorites",
                        color = if (favoritesSelected) Active else Inactive,
                        fontSize = 13.sp,
                        fontFamily = Inter,
                        fontWeight = if (favoritesSelected) FontWeight.SemiBold else FontWeight.Normal
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { onProfileScreen() }) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.profile_icon),
                        contentDescription = "profile",
                        tint = if (profileSelected) Active else Inactive
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Profile",
                        color = if (profileSelected) Active else Inactive,
                        fontSize = 13.sp,
                        fontFamily = Inter,
                        fontWeight = if (profileSelected) FontWeight.SemiBold else FontWeight.Normal
                    )
                }
            }
        }
        Spacer(modifier = Modifier.navigationBarsPadding())
    }
}

@Composable
fun Repositories(
    name: String,
    description: String,
    backgroundProgLang: Color,
    progLang: String,
    star: String,
    fork: String,
    iconColor: Color
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(12.dp))
        .background(White.copy(alpha = 0.05f))
        .border(
            width = 1.dp,
            color = White.copy(alpha = 0.35f),
            shape = RoundedCornerShape(12.dp)
        )
        .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(15.dp))

        Row {
            Text(
                text = name,
                color = ButtonColor,
                fontSize = 15.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold,
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(R.drawable.favorites_icon),
                contentDescription = "favorites",
                Modifier.size(16.dp),
                tint = iconColor
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = description,
            color = White.copy(alpha = 0.55f),
            fontSize = 13.sp,
            fontFamily = Inter,
            overflow = TextOverflow.Ellipsis,
            lineHeight = 18.sp,
            maxLines = 2,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(85.dp)) {

                Box(modifier = Modifier.clip(CircleShape).size(8.dp).background(backgroundProgLang))

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = progLang,
                    color = White.copy(alpha = 0.55f),
                    fontSize = 13.sp,
                    fontFamily = Inter,
                    lineHeight = 18.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(85.dp)) {

                Icon(
                    painter = painterResource(R.drawable.star_icon),
                    contentDescription = "github star",
                    Modifier.size(14.dp),
                    tint = White.copy(alpha = 0.55f)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = star,
                    color = White.copy(alpha = 0.55f),
                    fontSize = 13.sp,
                    fontFamily = Inter,
                    lineHeight = 18.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontWeight = FontWeight.Medium,
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(85.dp)) {

                Icon(
                    painter = painterResource(R.drawable.fork_icon),
                    contentDescription = "github fork",
                    Modifier.size(14.dp),
                    tint = White.copy(alpha = 0.55f)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = fork,
                    color = White.copy(alpha = 0.55f),
                    fontSize = 13.sp,
                    fontFamily = Inter,
                    lineHeight = 18.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
            }
        }
        Spacer(modifier = Modifier.height(17.5.dp))
    }
    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
fun Back(text: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(45.dp)
    ) {
        Box(modifier = Modifier.clickable{onClick()}) {
            Image(
                painter = painterResource(id = R.drawable.next_icon),
                contentDescription = "Back",
                modifier = Modifier.size(26.dp).scale(scaleX = -1f, scaleY = 1f),
                colorFilter = ColorFilter.tint(White)
            )
        }

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = text,
            color = White,
            fontSize = 18.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun DevProfile(
    icon: Int,
    name: String,
    desctiption: String,
    onDevProfile: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable{onDevProfile()}
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "User Icon",
            modifier = Modifier.size(40.dp).clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = name,
                color = White,
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = desctiption,
                color = White.copy(alpha = 0.35f),
                fontSize = 12.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            modifier = Modifier.size(16.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.next_icon),
            contentDescription = "next",
            tint = White.copy(alpha = 0.35f)
        )

        Spacer(modifier = Modifier.width(13.dp))
    }
}

@Composable
fun Test(
    test: String
) {
    Text(
        text = test,
        color = Purple,
        fontSize = 50.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.Medium
    )
}

@Preview
@Composable
fun NavBarPreview() {
    NavBar(
        currentRoute = null,
        onFavoritesScreen = {},
        onProfileScreen = {},
        onSearchScreen = {}
    )
}

@Preview
@Composable
fun DevProfilePreview() {
    DevProfile(
        icon = R.drawable.user_icon_1,
        name = "Fork",
        desctiption = "Just a Fork",
        onDevProfile = {}
    )
}

@Preview
@Composable
fun RepositoriesPreview() {
    Repositories(
        name = "Author/Repositories",
        description = "Repository description",
        backgroundProgLang = Orange,
        progLang = "HTML",
        star = "0",
        fork = "0",
        iconColor = Yellow
    )
}

@Preview
@Composable
fun BackPreview() {
    Back(
        text = "go to ...",
        onClick = {}
    )
}