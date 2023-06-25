package com.exercise.cafechatmaterial3ver.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = MainColor,
    secondary = BtnColor,
    tertiary = TFColor
)

private val LightColorScheme = lightColorScheme(
    primary = MainColor,
)

@Composable
fun CafeChatMaterial3verTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme
/*
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
        }
    }
*/
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}