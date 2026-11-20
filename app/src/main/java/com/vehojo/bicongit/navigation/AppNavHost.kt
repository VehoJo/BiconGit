package com.vehojo.bicongit.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vehojo.bicongit.ui.Back
import com.vehojo.bicongit.ui.screens.FavoritesScreen
import com.vehojo.bicongit.ui.screens.ProfileScreen
import com.vehojo.bicongit.ui.screens.SearchScreen
import com.vehojo.bicongit.ui.screens.DevProfileScreen
import com.vehojo.bicongit.ui.screens.RepoScreen
import com.vehojo.bicongit.ui.theme.Background

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = Destination.SearchScreen.route,
        modifier = modifier.background(Background)
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
            SearchScreen(
                showContent = animationFinished,
                onDevProfileClick = {
                    navHostController.safeNavigate(Destination.DevProfileScreen.route) {
                        launchSingleTop = true
                    }
                }
            )
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
            FavoritesScreen(
                showContent = animationFinished,
                onRepoScreen = {
                    navHostController.safeNavigate(Destination.RepositoryScreen.route) {
                        launchSingleTop = true
                    }
                }
            )
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
            ProfileScreen(
                showContent = animationFinished,
                onRepoScreen = {
                    navHostController.safeNavigate(Destination.RepositoryScreen.route) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            Destination.DevProfileScreen.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(500)
                )
            }
        ) {
            val animationFinished = transition.currentState == transition.targetState

            DevProfileScreen(
                showContent = animationFinished,
                navHostController = navHostController,
                onRepoScreenClick = {
                    navHostController.safeNavigate(Destination.RepositoryScreen.route) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            Destination.RepositoryScreen.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(500)
                )
            }
        ) {
            val animationFinished = transition.currentState == transition.targetState

            RepoScreen(
                navHostController = navHostController
            )
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
