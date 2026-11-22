package com.example.android_workshop.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = TomatoDarkPrimary,
    onPrimary = TomatoDarkOnPrimary,
    primaryContainer = TomatoDarkPrimaryContainer,
    onPrimaryContainer = TomatoDarkOnPrimaryContainer,
    secondary = TomatoDarkSecondary,
    onSecondary = TomatoDarkOnSecondary,
    secondaryContainer = TomatoDarkSecondaryContainer,
    onSecondaryContainer = TomatoDarkOnSecondaryContainer,
    tertiary = TomatoDarkTertiary,
    onTertiary = TomatoDarkOnTertiary,
    tertiaryContainer = TomatoDarkTertiaryContainer,
    onTertiaryContainer = TomatoDarkOnTertiaryContainer
)

private val LightColorScheme = lightColorScheme(
    primary = TomatoPrimary,
    onPrimary = TomatoOnPrimary,
    primaryContainer = TomatoPrimaryContainer,
    onPrimaryContainer = TomatoOnPrimaryContainer,
    secondary = TomatoSecondary,
    onSecondary = TomatoOnSecondary,
    secondaryContainer = TomatoSecondaryContainer,
    onSecondaryContainer = TomatoOnSecondaryContainer,
    tertiary = TomatoTertiary,
    onTertiary = TomatoOnTertiary,
    tertiaryContainer = TomatoTertiaryContainer,
    onTertiaryContainer = TomatoOnTertiaryContainer
)

@Composable
fun AndroidworkshopTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
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

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
