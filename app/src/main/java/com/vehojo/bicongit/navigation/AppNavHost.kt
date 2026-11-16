package com.vehojo.bicongit.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vehojo.bicongit.ui.NavBar
import com.vehojo.bicongit.ui.screens.FavoritesScreen
import com.vehojo.bicongit.ui.screens.ProfileScreen
import com.vehojo.bicongit.ui.screens.SearchScreen


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
            SearchScreen()
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
            FavoritesScreen()
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
            ProfileScreen()
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