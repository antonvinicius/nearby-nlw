package com.antonvinicius.nlw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.antonvinicius.nlw.data.model.NearbyMarket
import com.antonvinicius.nlw.ui.routes.Home
import com.antonvinicius.nlw.ui.routes.QrCodeScanner
import com.antonvinicius.nlw.ui.routes.Splash
import com.antonvinicius.nlw.ui.routes.Welcome
import com.antonvinicius.nlw.ui.screens.home.HomeScreen
import com.antonvinicius.nlw.ui.screens.home.HomeViewModel
import com.antonvinicius.nlw.ui.screens.market_details.MarketDetailsScreen
import com.antonvinicius.nlw.ui.screens.market_details.MarketDetailsUiEvent
import com.antonvinicius.nlw.ui.screens.market_details.MarketDetailsViewModel
import com.antonvinicius.nlw.ui.screens.qrcode_scanner.QrCodeScannerScreen
import com.antonvinicius.nlw.ui.screens.splash.SplashScreen
import com.antonvinicius.nlw.ui.screens.welcome.WelcomeScreen
import com.antonvinicius.nlw.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NearbyTheme {
                val homeViewModel by viewModels<HomeViewModel>()
                val homeUiState by homeViewModel.uiState.collectAsStateWithLifecycle()

                val marketDetailsViewModel by viewModels<MarketDetailsViewModel>()
                val marketDetailsUiState by marketDetailsViewModel.uiState.collectAsStateWithLifecycle()

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
                            },
                            uiState = homeUiState,
                            onEvent = { homeViewModel.onEvent(it) }
                        )
                    }
                    composable<NearbyMarket> {
                        val selectedMarket = it.toRoute<NearbyMarket>()

                        MarketDetailsScreen(
                            market = selectedMarket,
                            onNavigateBack = {
                                navController.popBackStack()
                            },
                            uiState = marketDetailsUiState,
                            onEvent = { marketDetailsViewModel.onEvent(it) },
                            onNavigateToQrCodeScanner = {
                                navController.navigate(QrCodeScanner)
                            }
                        )
                    }
                    composable<QrCodeScanner> {
                        QrCodeScannerScreen(
                            onCompletedScan = { qrCodeContent ->
                                if (qrCodeContent.isNotEmpty()) {
                                    marketDetailsViewModel.onEvent(
                                        event = MarketDetailsUiEvent.OnFetchCoupon(
                                            qrCodeContent = qrCodeContent
                                        )
                                    )
                                }
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}