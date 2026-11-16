package com.vehojo.bicongit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vehojo.bicongit.navigation.Destination
import com.vehojo.bicongit.ui.NavBar
import com.vehojo.bicongit.ui.Test
import com.vehojo.bicongit.ui.theme.Active
import com.vehojo.bicongit.ui.theme.Background
import com.vehojo.bicongit.ui.theme.Inactive

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize().background(Background)) {
        Spacer(modifier = Modifier.systemBarsPadding().padding(30.dp))
        Test(test = "Profile Screen")
        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.navigationBarsPadding())
    }
}