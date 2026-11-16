package com.vehojo.bicongit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.vehojo.bicongit.navigation.AppNavHost
import com.vehojo.bicongit.ui.theme.BiconGitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BiconGitTheme {
                val navController = rememberNavController()
                AppNavHost(navHostController = navController)
            }
        }
    }
}