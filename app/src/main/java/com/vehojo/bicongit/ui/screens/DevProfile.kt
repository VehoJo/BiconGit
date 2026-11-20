package com.vehojo.bicongit.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vehojo.bicongit.R
import com.vehojo.bicongit.navigation.safePopBackStack
import com.vehojo.bicongit.ui.Back
import com.vehojo.bicongit.ui.Repositories
import com.vehojo.bicongit.ui.theme.Background
import com.vehojo.bicongit.ui.theme.ButtonColor
import com.vehojo.bicongit.ui.theme.Inter
import com.vehojo.bicongit.ui.theme.Orange
import com.vehojo.bicongit.ui.theme.Purple
import com.vehojo.bicongit.ui.theme.White
import com.vehojo.bicongit.ui.theme.Yellow

@Composable
fun DevProfileScreen(
    showContent: Boolean = true,
    navHostController: NavHostController,
    onRepoScreenClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .navigationBarsPadding()
            .systemBarsPadding()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        AnimatedContent(
            targetState = showContent,
            transitionSpec = { fadeIn(tween(250)) togetherWith fadeOut(tween(150)) },
            label = "devProfileContent"
        ) { ready ->
            if (ready) {
                DevProfileMain(
                    navHostController = navHostController,
                    onRepoScreenClick = onRepoScreenClick
                )
            } else {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = ButtonColor)
                }
            }
        }
    }
}

@Composable
fun DevProfileMain(
    navHostController: NavHostController,
    onRepoScreenClick: () -> Unit
) {
    var username = "VehoJo"
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Back(
            text = "Developer profile",
            onClick = {
                navHostController.safePopBackStack()
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(R.drawable.user_icon_2),
                contentDescription = "User Icon",
                modifier = Modifier.size(80.dp).clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.height(80.dp), verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Spoon",
                    color = White,
                    fontSize = 26.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "@$username",
                    color = White.copy(alpha = 0.55f),
                    fontSize = 14.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Just a Spoon",
            color = White,
            fontSize = 14.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.pin_icon),
                contentDescription = "User Icon",
                modifier = Modifier.size(14.dp),
                colorFilter = ColorFilter.tint(White.copy(alpha = 0.55f))
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = "The Hague, Netherlands",
                color = White.copy(alpha = 0.55f),
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.width(20.dp))

            Image(
                painter = painterResource(R.drawable.building_icon),
                contentDescription = "User Icon",
                modifier = Modifier.size(14.dp),
                colorFilter = ColorFilter.tint(White.copy(alpha = 0.55f))
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = "Linux Foundation",
                color = White.copy(alpha = 0.55f),
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Normal
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(White.copy(alpha = 0.05f))
                .border(
                    width = 1.dp,
                    color = White.copy(alpha = 0.35f),
                    shape = RoundedCornerShape(16.dp)
                )
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(110.dp)
            ) {
                Text(
                    text = "105",
                    color = White,
                    fontSize = 18.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "followers",
                    color = White.copy(alpha = 0.55f),
                    fontSize = 12.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(110.dp)
            ) {
                Text(
                    text = "8",
                    color = White,
                    fontSize = 18.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "following",
                    color = White.copy(alpha = 0.55f),
                    fontSize = 12.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(110.dp)
            ) {
                Text(
                    text = "3",
                    color = White,
                    fontSize = 18.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "public repos",
                    color = White.copy(alpha = 0.55f),
                    fontSize = 12.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        val uriHandler = LocalUriHandler.current

        Button(
            onClick = { uriHandler.openUri("https://github.com/$username") },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonColor,
                contentColor = Background
            )
        ) {
            Text(
                text = "View in Github",
                fontSize = 15.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.width(8.dp))

            Image(
                painter = painterResource(R.drawable.url_icon),
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                colorFilter = ColorFilter.tint(Background)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Repositories",
                color = White,
                fontSize = 18.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "4 repositories",
                color = ButtonColor,
                fontSize = 12.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {

            item {
                Repositories(
                    name = "Spoon/Test",
                    description = "Test",
                    backgroundProgLang = Purple,
                    progLang = "Kotlin",
                    star = "234B",
                    fork = "43.2B",
                    iconColor = White.copy(alpha = 0.55f),
                    onRepoScreen = onRepoScreenClick
                )
            }

            item {
                Repositories(
                    name = "Spoon/MyRepo",
                    description = "My 1st repository",
                    backgroundProgLang = Yellow,
                    progLang = "JavaScript",
                    star = "234B",
                    fork = "43.2B",
                    iconColor = White.copy(alpha = 0.55f),
                    onRepoScreen = onRepoScreenClick
                )
            }

            item {
                Repositories(
                    name = "Spoon/Radio",
                    description = "Site-radio on HTML",
                    backgroundProgLang = Orange,
                    progLang = "HTML",
                    star = "234B",
                    fork = "4",
                    iconColor = White.copy(alpha = 0.55f),
                    onRepoScreen = onRepoScreenClick
                )
            }

            item {
                Repositories(
                    name = "Spoon/MyRepo",
                    description = "My 1st repository",
                    backgroundProgLang = Yellow,
                    progLang = "JavaScript",
                    star = "234B",
                    fork = "43.2B",
                    iconColor = White.copy(alpha = 0.55f),
                    onRepoScreen = onRepoScreenClick
                )
            }
        }
    }
}

@Preview
@Composable
fun DevProfilePreview() {
    DevProfileScreen(
        navHostController = rememberNavController(),
        onRepoScreenClick = {}
    )
}