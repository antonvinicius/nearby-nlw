package com.antonvinicius.nlw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.antonvinicius.nlw.data.model.NearbyMarket
import com.antonvinicius.nlw.ui.screens.HomeScreen
import com.antonvinicius.nlw.ui.screens.MarketDetailsScreen
import com.antonvinicius.nlw.ui.screens.SplashScreen
import com.antonvinicius.nlw.ui.screens.WelcomeScreen
import com.antonvinicius.nlw.ui.screens.routes.Home
import com.antonvinicius.nlw.ui.screens.routes.Splash
import com.antonvinicius.nlw.ui.screens.routes.Welcome
import com.antonvinicius.nlw.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NearbyTheme {
                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            onNavigateToWelcome = {
                                navController.navigate(Welcome)
                            }
                        )
                    }
                    composable<Welcome> {
                        WelcomeScreen(
                            onNavigateToHome = {
                                navController.navigate(Home)
                            }
                        )
                    }
                    composable<Home> {
                        HomeScreen(
                            onNavigateToMarketDetails = { selectedMarket ->
                                navController.navigate(selectedMarket)
                            }
                        )
                    }
                    composable<NearbyMarket> {
                        val selectedMarket = it.toRoute<NearbyMarket>()

                        MarketDetailsScreen(
                            market = selectedMarket,
                            onNavigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}