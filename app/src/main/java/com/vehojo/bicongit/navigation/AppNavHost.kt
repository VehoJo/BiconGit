package com.vehojo.bicongit.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
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
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Destination.SearchScreen.route,
    ) {
        composable(Destination.SearchScreen.route) {
            SearchScreen(
                onSearchScreen = {
                    navHostController.safeNavigate(Destination.SearchScreen.route) {
                        launchSingleTop = true
                    }
                },
                onFavoritesScreen = {
                    navHostController.safeNavigate(Destination.FavoritesScreen.route) {
                        launchSingleTop = true
                    }
                },
                onProfileScreen = {
                    navHostController.safeNavigate(Destination.ProfileScreen.route) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Destination.FavoritesScreen.route) {
            FavoritesScreen(
                onSearchScreen = {
                    navHostController.safeNavigate(Destination.SearchScreen.route) {
                        launchSingleTop = true
                    }
                },
                onFavoritesScreen = {
                    navHostController.safeNavigate(Destination.FavoritesScreen.route) {
                        launchSingleTop = true
                    }
                },
                onProfileScreen = {
                    navHostController.safeNavigate(Destination.ProfileScreen.route) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Destination.ProfileScreen.route) {
            ProfileScreen(
                onSearchScreen = {
                    navHostController.safeNavigate(Destination.SearchScreen.route) {
                        launchSingleTop = true
                    }
                },
                onFavoritesScreen = {
                    navHostController.safeNavigate(Destination.FavoritesScreen.route) {
                        launchSingleTop = true
                    }
                },
                onProfileScreen = {
                    navHostController.safeNavigate(Destination.ProfileScreen.route) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}