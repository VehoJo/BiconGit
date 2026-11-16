package com.vehojo.bicongit.ui.screens

import android.R.attr.top
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vehojo.bicongit.R
import com.vehojo.bicongit.ui.DevProfile
import com.vehojo.bicongit.ui.NavBar
import com.vehojo.bicongit.ui.Test
import com.vehojo.bicongit.ui.theme.Active
import com.vehojo.bicongit.ui.theme.Background
import com.vehojo.bicongit.ui.theme.ButtonColor
import com.vehojo.bicongit.ui.theme.Inactive
import com.vehojo.bicongit.ui.theme.Inter
import com.vehojo.bicongit.ui.theme.White

@Preview
@Composable
fun SearchScreen() {
    Column(modifier = Modifier.fillMaxSize().background(Background)) {
        Spacer(modifier = Modifier.systemBarsPadding().padding(top = 15.dp))
        SearchMain()
        Spacer(modifier = Modifier.navigationBarsPadding())
    }
}

@Composable
fun SearchMain(modifier: Modifier = Modifier) {
    var username by remember {
        mutableStateOf("")
    }
    Column(modifier = modifier.fillMaxWidth().padding(horizontal = 24.dp)) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                modifier = Modifier.size(40.dp).clip(RoundedCornerShape(12.dp)),
                imageVector = ImageVector.vectorResource(id = R.drawable.app_icon),
                contentDescription = "app icon",
                tint = Color.Unspecified,
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = "Observashion - Git",
                color = White,
                fontSize = 26.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Explore the developer community",
            color = White.copy(alpha = 0.55f),
            fontSize = 16.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = username,
            singleLine = true,
            onValueChange = { username = it },
            shape = RoundedCornerShape(12.dp),
            placeholder = {
                Text(
                    "Search GitHub username",
                    color = White.copy(alpha = 0.35f),
                    fontSize = 15.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal
                )
            },
            modifier = Modifier.fillMaxWidth().height(56.dp),
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

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {},
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonColor,
                contentColor = Background
            )
        ) {
            Text(
                text = "Search developers",
                fontSize = 15.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {

            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Recent searches",
                        color = White,
                        fontSize = 18.sp,
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "Clear all",
                        color = ButtonColor,
                        fontSize = 12.sp,
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(17.5.dp))

                DevProfile(
                    icon = R.drawable.user_icon_3,
                    name = "ASHLsdfj152",
                    desctiption = "PLEASE DON'T STOP"
                )

                Spacer(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .fillMaxWidth()
                        .background(White.copy(alpha = 0.25f), shape = RoundedCornerShape(5.dp))
                        .height(1.dp)
                )

                DevProfile(
                    icon = R.drawable.user_icon_1,
                    name = "Fork",
                    desctiption = "Just a Fork"
                )

                Spacer(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .fillMaxWidth()
                        .background(White.copy(alpha = 0.25f), shape = RoundedCornerShape(5.dp))
                        .height(1.dp)
                )

                DevProfile(
                    icon = R.drawable.user_icon_2,
                    name = "Spoon",
                    desctiption = "Just a Spoon"
                )


                Spacer(modifier = Modifier.height(24.dp))
            }

            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Popular Developer",
                        color = White,
                        fontSize = 18.sp,
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "Discover",
                        color = ButtonColor,
                        fontSize = 12.sp,
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(17.5.dp))

                DevProfile(
                    icon = R.drawable.user_icon_2,
                    name = "Spoon",
                    desctiption = "Just a Spoon"
                )

                Spacer(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .fillMaxWidth()
                        .background(White.copy(alpha = 0.25f), shape = RoundedCornerShape(5.dp))
                        .height(1.dp)
                )

                DevProfile(
                    icon = R.drawable.user_icon_1,
                    name = "Fork",
                    desctiption = "Just a Fork"
                )

                Spacer(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .fillMaxWidth()
                        .background(White.copy(alpha = 0.25f), shape = RoundedCornerShape(5.dp))
                        .height(1.dp)
                )

                DevProfile(
                    icon = R.drawable.user_icon_3,
                    name = "ASHLsdfj152",
                    desctiption = "PLEASE DON'T STOP"
                )
            }
        }
    }
}