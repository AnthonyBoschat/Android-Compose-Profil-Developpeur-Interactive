package com.example.kotlin_1.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Thème clair : rouge sombre sur fond clair
val DarkRed   = Color(0xFF651212)
val Brick     = Color(0xFFA84B3C)
val Gold      = Color(0xFFB8862E)



private val DarkColorScheme = darkColorScheme(
    primary   = Color(0xFFF6CFC9),
    secondary = Color(0xFFE7BDB3),
    tertiary  = Color(0xFFE9C27F),



    tertiaryContainer = Color(0xFFFFCD7A),
    onTertiaryContainer = Color(0xFFC3FD9F),
)

private val LightColorScheme = lightColorScheme(
    primary   = Color(0xFF651212),
    secondary = Color(0xFFA84B3C),
    tertiary  = Color(0xFFB8862E),

    tertiaryContainer = Color(0xFFB97B01),
    onTertiaryContainer = Color(0xFF245E01),

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun Kotlin1Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
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

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}