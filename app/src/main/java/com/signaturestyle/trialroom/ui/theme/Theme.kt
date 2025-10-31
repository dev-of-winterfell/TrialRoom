package com.signaturestyle.trialroom.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = BurntSienna,
    onPrimary = CreamWhite,
    primaryContainer = Color(0xFFD89077),
    onPrimaryContainer = DeepCharcoal,

    secondary = SageGreen,
    onSecondary = CreamWhite,
    secondaryContainer = Color(0xFFA8B99E),
    onSecondaryContainer = DeepCharcoal,

    tertiary = Terracotta,
    onTertiary = CreamWhite,

    error = Error,
    onError = CreamWhite,

    background = CreamWhite,
    onBackground = DeepCharcoal,

    surface = CreamWhite,
    onSurface = DeepCharcoal,
    surfaceVariant = LightGray,
    onSurfaceVariant = MediumGray,

    outline = MediumGray,
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFD89077),
    onPrimary = SophisticatedBlack,

    secondary = Color(0xFFA8B99E),
    onSecondary = SophisticatedBlack,

    background = SophisticatedBlack,
    onBackground = CreamWhite,

    surface = Color(0xFF1C1B1F),
    onSurface = CreamWhite,
)

@Composable
fun TrialRoomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}