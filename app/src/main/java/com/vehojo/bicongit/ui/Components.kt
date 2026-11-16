package com.vehojo.bicongit.ui

import android.media.Image
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vehojo.bicongit.R
import com.vehojo.bicongit.ui.theme.Active
import com.vehojo.bicongit.ui.theme.Background
import com.vehojo.bicongit.ui.theme.Inactive
import com.vehojo.bicongit.ui.theme.Inter
import com.vehojo.bicongit.ui.theme.Purple40
import com.vehojo.bicongit.ui.theme.White
import com.vehojo.bicongit.ui.theme.onBackground

@Composable
fun NavBar(
    onSearchScreen: () -> Unit,
    onFavoritesScreen: () -> Unit,
    onProfileScreen: () -> Unit,
    searchCol: Color = Inactive,
    favoritesCol: Color = Inactive,
    profileCol: Color = Inactive,
    searchWeight: FontWeight = FontWeight.Normal,
    favoritesWeight: FontWeight = FontWeight.Normal,
    profilesWeight: FontWeight = FontWeight.Normal
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(Background)
    ) {
        Spacer(modifier = Modifier.background(onBackground).fillMaxWidth().height(2.dp))
        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {

            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable{onSearchScreen()}) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.search_icon),
                    contentDescription = "search",
                    tint = searchCol
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Search",
                    color = searchCol,
                    fontSize = 13.sp,
                    fontFamily = Inter,
                    fontWeight = searchWeight
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable{onFavoritesScreen()}) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.favorites_icon),
                    contentDescription = "favorites",
                    tint = favoritesCol
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Favorites",
                    color = favoritesCol,
                    fontSize = 13.sp,
                    fontFamily = Inter,
                    fontWeight = favoritesWeight
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable{onProfileScreen()}) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.profile_icon),
                    contentDescription = "profile",
                    tint = profileCol
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Profile",
                    color = profileCol,
                    fontSize = 13.sp,
                    fontFamily = Inter,
                    fontWeight = profilesWeight
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Composable
fun DevProfile(
    icon: Int,
    name: String,
    desctiption: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
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
        color = Purple40,
        fontSize = 50.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.Medium
    )
}

@Preview
@Composable
fun NavBarPreview() {
    NavBar(
        onFavoritesScreen = {},
        onProfileScreen = {},
        onSearchScreen = {},
        searchCol = Active,
        favoritesCol = Inactive,
        profileCol = Inactive,
        searchWeight = FontWeight.SemiBold,
        favoritesWeight = FontWeight.Normal,
        profilesWeight = FontWeight.Normal
    )
}

@Preview
@Composable
fun DevProfilePreview() {
    DevProfile(
        icon = R.drawable.user_icon_1,
        name = "Fork",
        desctiption = "Just a Fork"
    )
}