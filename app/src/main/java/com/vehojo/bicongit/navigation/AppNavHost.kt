package com.vehojo.bicongit.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vehojo.bicongit.ui.NavBar
import com.vehojo.bicongit.ui.screens.FavoritesScreen
import com.vehojo.bicongit.ui.screens.ProfileScreen
import com.vehojo.bicongit.ui.screens.SearchScreen
import com.vehojo.bicongit.ui.theme.White


@Composable
fun AppNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = Destination.SearchScreen.route,
        modifier = modifier
    ) {
        composable(
            Destination.SearchScreen.route,
            enterTransition = {
                slideIntoContainer(
                    if (getIndex(targetState.destination.route) > getIndex(initialState.destination.route))
                        AnimatedContentTransitionScope.SlideDirection.Left
                    else
                        AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    if (getIndex(targetState.destination.route) > getIndex(initialState.destination.route))
                        AnimatedContentTransitionScope.SlideDirection.Left
                    else
                        AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(500)
                )
            }
        ) {
            val animationFinished = transition.currentState == transition.targetState
            SearchScreen(showContent = animationFinished)
        }

        composable(
            Destination.FavoritesScreen.route,
            enterTransition = {
                slideIntoContainer(
                    if (getIndex(targetState.destination.route) > getIndex(initialState.destination.route))
                        AnimatedContentTransitionScope.SlideDirection.Left
                    else
                        AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    if (getIndex(targetState.destination.route) > getIndex(initialState.destination.route))
                        AnimatedContentTransitionScope.SlideDirection.Left
                    else
                        AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(500)
                )
            }
        ) {
            val animationFinished = transition.currentState == transition.targetState
            FavoritesScreen(showContent = animationFinished)
        }

        composable(
            Destination.ProfileScreen.route,
            enterTransition = {
                slideIntoContainer(
                    if (getIndex(targetState.destination.route) > getIndex(initialState.destination.route))
                        AnimatedContentTransitionScope.SlideDirection.Left
                    else
                        AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    if (getIndex(targetState.destination.route) > getIndex(initialState.destination.route))
                        AnimatedContentTransitionScope.SlideDirection.Left
                    else
                        AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(500)
                )
            }
        ) {
            val animationFinished = transition.currentState == transition.targetState
            ProfileScreen(showContent = animationFinished)
        }
    }
}

fun getIndex(route: String?): Int {
    return when (route) {
        Destination.SearchScreen.route -> 1
        Destination.FavoritesScreen.route -> 2
        Destination.ProfileScreen.route -> 3
        else -> 0
    }
}

fun Modifier.shimmer(): Modifier = composed {
    val transition = rememberInfiniteTransition(label = "shimmer")
    val offset by transition.animateFloat(
        initialValue = -400f,
        targetValue = 1200f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmerOffset"
    )

    background(
        Brush.linearGradient(
            colors = listOf(
                White.copy(alpha = 0.06f),
                White.copy(alpha = 0.18f),
                White.copy(alpha = 0.06f)
            ),
            start = Offset(offset, 0f),
            end = Offset(offset + 400f, 0f)
        )
    )
}

@Composable
fun DevProfileSkeleton() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .shimmer()
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Box(
                modifier = Modifier
                    .width(140.dp)
                    .height(16.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .shimmer()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(12.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .shimmer()
            )
        }
    }
}

