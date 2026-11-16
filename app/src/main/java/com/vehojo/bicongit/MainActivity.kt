package com.vehojo.bicongit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vehojo.bicongit.navigation.AppNavHost
import com.vehojo.bicongit.navigation.Destination
import com.vehojo.bicongit.ui.NavBar
import com.vehojo.bicongit.ui.theme.BiconGitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BiconGitTheme {
                val navController = rememberNavController()
                val navBackStackEntry by
                navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Column {
                    AppNavHost(
                        navHostController = navController,
                        modifier = Modifier.weight(1f)
                    )

                    NavBar(
                        currentRoute = currentRoute,
                        onSearchScreen = { navController.navigate(Destination.SearchScreen.route) },
                        onProfileScreen = { navController.navigate(Destination.ProfileScreen.route) },
                        onFavoritesScreen = { navController.navigate(Destination.FavoritesScreen.route) }
                    )
                }
            }
        }
    }
}