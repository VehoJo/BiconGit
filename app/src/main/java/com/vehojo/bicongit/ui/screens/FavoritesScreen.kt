package com.vehojo.bicongit.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vehojo.bicongit.R
import com.vehojo.bicongit.ui.NavBar
import com.vehojo.bicongit.ui.Repositories
import com.vehojo.bicongit.ui.Test
import com.vehojo.bicongit.ui.theme.Active
import com.vehojo.bicongit.ui.theme.Background
import com.vehojo.bicongit.ui.theme.ButtonColor
import com.vehojo.bicongit.ui.theme.Inactive
import com.vehojo.bicongit.ui.theme.Inter
import com.vehojo.bicongit.ui.theme.Orange
import com.vehojo.bicongit.ui.theme.Purple
import com.vehojo.bicongit.ui.theme.Purple80
import com.vehojo.bicongit.ui.theme.PurpleGrey40
import com.vehojo.bicongit.ui.theme.White
import com.vehojo.bicongit.ui.theme.Yellow

@Composable
fun FavoritesScreen(showContent: Boolean = true, onRepoScreen: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().background(Background)) {
        Spacer(modifier = Modifier.systemBarsPadding())
        AnimatedContent(
            targetState = showContent,
            transitionSpec = { fadeIn(tween(250)) togetherWith fadeOut(tween(150)) },
            label = "favoritesContent"
        ) { ready ->
            if (ready) {
                FavoritesMain(onRepoScreen = onRepoScreen)
            } else {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = ButtonColor)
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.navigationBarsPadding())
    }
}

@Composable
fun FavoritesMain(onRepoScreen: () -> Unit) {
    var savedRep by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)) {

        Text(
            text = "Favorites",
            color = White,
            fontSize = 26.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Your saved repositories",
            color = White.copy(alpha = 0.55f),
            fontSize = 16.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = savedRep,
            singleLine = true,
            onValueChange = { savedRep = it },
            shape = RoundedCornerShape(12.dp),
            placeholder = {
                Text(
                    "Filter saved repositories…",
                    color = White.copy(alpha = 0.35f),
                    fontSize = 15.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                )
            },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.search_icon),
                    contentDescription = "search",
                    tint = White.copy(alpha = 0.35f),
                    modifier = Modifier.size(22.5.dp).offset(x = 5.dp)
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = White.copy(alpha = 0.25f),
                focusedBorderColor = White.copy(alpha = 0.35f),
                focusedTextColor = White.copy(alpha = 0.55f),
                unfocusedTextColor = White.copy(alpha = 0.35f),
                cursorColor = White.copy(alpha = 0.45f),
                focusedContainerColor = White.copy(alpha = 0.05f),
                unfocusedContainerColor = White.copy(alpha = 0.05f)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Saved repositories",
                color = White,
                fontSize = 18.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "3 repositories",
                color = ButtonColor,
                fontSize = 12.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {

            item {
                Repositories(
                    name = "VehoJo/Schejul",
                    description = "Schejul is a simple and modern timetable app designed to help students organize their school day. It provides a clean interface for viewing lessons, checking class times, and keeping track of classrooms",
                    backgroundProgLang = Yellow,
                    progLang = "JavaScript",
                    star = "234B",
                    fork = "43.2B",
                    iconColor = Yellow,
                    onRepoScreen = onRepoScreen
                )
            }

            item {
                Repositories(
                    name = "VehoJo/AetherNova",
                    description = "A small single-page application that counts down the time until New Year's",
                    backgroundProgLang = Purple,
                    progLang = "Kotlin",
                    star = "234B",
                    fork = "43.2B",
                    iconColor = Yellow,
                    onRepoScreen = onRepoScreen
                )
            }

            item {
                Repositories(
                    name = "VehoJo/BiconGit",
                    description = "A modern GitHub client for Android, built with Kotlin and Jetpack Compose",
                    backgroundProgLang = Orange,
                    progLang = "HTML",
                    star = "234B",
                    fork = "43.2B",
                    iconColor = Yellow,
                    onRepoScreen = onRepoScreen
                )
            }

            item {
                Repositories(
                    name = "VehoJo/BiconGit",
                    description = "A modern GitHub client for Android, built with Kotlin and Jetpack Compose",
                    backgroundProgLang = Orange,
                    progLang = "HTML",
                    star = "234B",
                    fork = "43.2B",
                    iconColor = Yellow,
                    onRepoScreen = onRepoScreen
                )
            }
        }
    }
}

@Preview
@Composable
fun FavoritesPreview() {
    FavoritesScreen(onRepoScreen = {})
}