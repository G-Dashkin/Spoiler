package com.dashkin.spoiler.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val SpoilerColorScheme = darkColorScheme(
    primary = GreenPrimary,
    onPrimary = BackgroundDark,
    primaryContainer = GreenDark,
    onPrimaryContainer = OnBackgroundDark,
    background = BackgroundDark,
    onBackground = OnBackgroundDark,
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = OnSurfaceVariantDark,
    outline = OutlineDark,
    outlineVariant = SurfaceVariantDark,
)

@Composable
fun SpoilerTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = SpoilerColorScheme,
        typography = SpoilerTypography,
        content = content,
    )
}
