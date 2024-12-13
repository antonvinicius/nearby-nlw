package com.antonvinicius.nlw.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.antonvinicius.nlw.R
import com.antonvinicius.nlw.ui.theme.GreenLight
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToWelcome: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(3.seconds)
        onNavigateToWelcome()
    }

    Box(
        modifier = modifier
            .background(GreenLight)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.img_logo_logo_logo_text),
            contentDescription = "Logo da aplicação",
            modifier = Modifier.align(Alignment.Center)
        )

        Image(
            painter = painterResource(R.drawable.bg_splash_screen),
            contentDescription = null,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen(
        onNavigateToWelcome = {}
    )
}