package com.vehojo.bicongit.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vehojo.bicongit.navigation.Destination
import com.vehojo.bicongit.ui.NavBar
import com.vehojo.bicongit.ui.Test
import com.vehojo.bicongit.ui.theme.Active
import com.vehojo.bicongit.ui.theme.Background
import com.vehojo.bicongit.ui.theme.ButtonColor
import com.vehojo.bicongit.ui.theme.Inactive

@Composable
fun ProfileScreen(showContent: Boolean = true) {
    Column(modifier = Modifier.fillMaxSize().background(Background)) {
        Spacer(modifier = Modifier.systemBarsPadding().padding(30.dp))
        AnimatedContent(
            targetState = showContent,
            transitionSpec = { fadeIn(tween(250)) togetherWith fadeOut(tween(150)) },
            label = "profileContent"
        ) { ready ->
            if (ready) {
                Test(test = "Profile Screen")
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