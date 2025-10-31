package com.signaturestyle.trialroom.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.signaturestyle.trialroom.presentation.splash.SplashScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Splash.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Splash Screen
        composable(route = Screen.Splash.route) {
            SplashScreen(
                onSplashFinished = {
                    // Navigate to home (you'll add this later)
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Splash.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // Temporary Home Screen placeholder
        composable(route = Screen.Home.route) {
            TemporaryHomeScreen()
        }
    }
}

@Composable
fun TemporaryHomeScreen() {
    androidx.compose.foundation.layout.Box(
        modifier = androidx.compose.ui.Modifier.fillMaxSize(),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        androidx.compose.material3.Text(
            text = "Home Screen Coming Soon!",
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium
        )
    }
}