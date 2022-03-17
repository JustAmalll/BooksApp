package dev.amal.booksapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = primaryNight,
    primaryVariant = textNight,
    secondary = Teal200,
    onSurface = cardNight,
    background = backgroundNight
)

private val LightColorPalette = lightColors(
    primary = primary,
    primaryVariant = text,
    secondary = Teal200,
    onSurface = card,
    background = background
)

@Composable
fun BooksAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}