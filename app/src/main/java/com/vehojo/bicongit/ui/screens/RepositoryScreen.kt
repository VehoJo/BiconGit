package com.vehojo.bicongit.ui.screens

import android.widget.Space
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vehojo.bicongit.R
import com.vehojo.bicongit.navigation.safePopBackStack
import com.vehojo.bicongit.ui.Back
import com.vehojo.bicongit.ui.theme.Active
import com.vehojo.bicongit.ui.theme.Background
import com.vehojo.bicongit.ui.theme.ButtonColor
import com.vehojo.bicongit.ui.theme.Inactive
import com.vehojo.bicongit.ui.theme.Inter
import com.vehojo.bicongit.ui.theme.Orange
import com.vehojo.bicongit.ui.theme.White

@Composable
fun RepoScreen(showContent: Boolean = true, navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .navigationBarsPadding()
            .systemBarsPadding()
    ) {
        AnimatedContent(
            targetState = showContent,
            transitionSpec = { fadeIn(tween(250)) togetherWith fadeOut(tween(150)) },
            label = "devProfileContent"
        ) { ready ->
            if (ready) {
                RepoMain(navHostController = navHostController)
            } else {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = ButtonColor)
                }
            }
        }
    }
}

@Composable
fun RepoMain(navHostController: NavHostController) {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Back(
            text = "Repository",
            onClick = {
                navHostController.safePopBackStack()
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.user_icon_1),
                contentDescription = "User Icon",
                modifier = Modifier.size(28.dp).clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Fork",
                color = White.copy(alpha = 0.55f),
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Test",
                color = White,
                fontSize = 28.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.width(12.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(width = 48.dp, height = 22.dp)
                    .border(
                        width = 1.dp,
                        color = White.copy(alpha = 0.45f),
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                Text(
                    text = "Public",
                    color = White.copy(alpha = 0.55f),
                    fontSize = 11.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Test repo",
            color = White,
            fontSize = 14.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                painter = painterResource(R.drawable.star_icon),
                contentDescription = "github star",
                Modifier.size(16.dp),
                tint = White.copy(alpha = 0.55f)
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = "0",
                color = White,
                fontSize = 13.sp,
                fontFamily = Inter,
                lineHeight = 18.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontWeight = FontWeight.Medium,
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = "stars",
                color = White.copy(alpha = 0.55f),
                fontSize = 12.sp,
                fontFamily = Inter,
                lineHeight = 18.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontWeight = FontWeight.Normal,
            )

            Spacer(modifier = Modifier.width(20.dp))

            Icon(
                painter = painterResource(R.drawable.fork_icon),
                contentDescription = "github fork",
                Modifier.size(14.dp),
                tint = White.copy(alpha = 0.55f)
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = "1",
                color = White,
                fontSize = 13.sp,
                fontFamily = Inter,
                lineHeight = 18.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = "forks",
                color = White.copy(alpha = 0.55f),
                fontSize = 12.sp,
                fontFamily = Inter,
                lineHeight = 18.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontWeight = FontWeight.Normal,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {

            Box(modifier = Modifier.clip(CircleShape).size(8.dp).background(Orange))

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = "HTML",
                color = White,
                fontSize = 13.sp,
                fontFamily = Inter,
                lineHeight = 18.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontWeight = FontWeight.Medium,
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Primary language",
                color = White.copy(alpha = 0.55f),
                fontSize = 12.sp,
                fontFamily = Inter,
                lineHeight = 18.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontWeight = FontWeight.Normal,
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        val uriHandler = LocalUriHandler.current
        var username = "VehoJo"
        val repo = "BiconGit"

        Row {

            Button(
                onClick = {  },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .height(50.dp)
                    .border(
                        width = 1.dp,
                        color = White.copy(alpha = 0.35f),
                        shape = RoundedCornerShape(12.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = White.copy(alpha = 0.05f),
                    contentColor = White
                )
            ) {
                Text(
                    text = "Star",
                    fontSize = 15.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.width(8.dp))

                Image(
                    painter = painterResource(R.drawable.star_icon),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    colorFilter = ColorFilter.tint(White)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                onClick = { uriHandler.openUri("https://github.com/$username/$repo") },
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
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                modifier = Modifier.size(25.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.book_icon),
                contentDescription = "book",
                tint = White.copy(alpha = 0.65f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "README",
                fontSize = 15.sp,
                color = White,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "README.md",
                fontSize = 11.sp,
                color = White.copy(alpha = 0.55f),
                fontFamily = Inter,
                fontWeight = FontWeight.Normal
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(White.copy(alpha = 0.05f))
            .border(
                width = 1.dp,
                color = White.copy(alpha = 0.35f),
                shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Text(
                text = "TEST",
                fontSize = 18.sp,
                color = White,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.shield_icon),
                contentDescription = "shield",
                tint = White.copy(alpha = 0.55f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "License",
                fontSize = 12.sp,
                color = White.copy(alpha = 0.55f),
                fontFamily = Inter,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "MIT",
                fontSize = 13.sp,
                color = White,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.branch_icon),
                contentDescription = "branch",
                tint = White.copy(alpha = 0.55f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Default branch",
                fontSize = 12.sp,
                color = White.copy(alpha = 0.55f),
                fontFamily = Inter,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "master",
                fontSize = 13.sp,
                color = White,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.clock_icon),
                contentDescription = "clock",
                tint = White.copy(alpha = 0.55f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Last updated",
                fontSize = 12.sp,
                color = White.copy(alpha = 0.55f),
                fontFamily = Inter,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "3 years ago",
                fontSize = 13.sp,
                color = White,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview
@Composable
fun RepoPreview() {
    RepoScreen(
        navHostController = rememberNavController()
    )
}