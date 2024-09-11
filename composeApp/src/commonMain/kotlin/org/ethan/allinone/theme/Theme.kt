/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ethan.allinone.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = LightThemeColors.md_theme_light_primary,
    onPrimary = LightThemeColors.md_theme_light_onPrimary,
    primaryContainer = LightThemeColors.md_theme_light_primaryContainer,
    onPrimaryContainer = LightThemeColors.md_theme_light_onPrimaryContainer,
    secondary = LightThemeColors.md_theme_light_secondary,
    onSecondary = LightThemeColors.md_theme_light_onSecondary,
    secondaryContainer = LightThemeColors.md_theme_light_secondaryContainer,
    onSecondaryContainer = LightThemeColors.md_theme_light_onSecondaryContainer,
    tertiary = LightThemeColors.md_theme_light_tertiary,
    onTertiary = LightThemeColors.md_theme_light_onTertiary,
    tertiaryContainer = LightThemeColors.md_theme_light_tertiaryContainer,
    onTertiaryContainer = LightThemeColors.md_theme_light_onTertiaryContainer,
    error = LightThemeColors.md_theme_light_error,
    errorContainer = LightThemeColors.md_theme_light_errorContainer,
    onError = LightThemeColors.md_theme_light_onError,
    onErrorContainer = LightThemeColors.md_theme_light_onErrorContainer,
    background = LightThemeColors.md_theme_light_background,
    onBackground = LightThemeColors.md_theme_light_onBackground,
    surface = LightThemeColors.md_theme_light_surface,
    onSurface = LightThemeColors.md_theme_light_onSurface,
    surfaceVariant = LightThemeColors.md_theme_light_surfaceVariant,
    onSurfaceVariant = LightThemeColors.md_theme_light_onSurfaceVariant,
    outline = LightThemeColors.md_theme_light_outline,
    inverseOnSurface = LightThemeColors.md_theme_light_inverseOnSurface,
    inverseSurface = LightThemeColors.md_theme_light_inverseSurface,
    inversePrimary = LightThemeColors.md_theme_light_inversePrimary,
    surfaceTint = LightThemeColors.md_theme_light_surfaceTint,
    outlineVariant = LightThemeColors.md_theme_light_outlineVariant,
    scrim = LightThemeColors.md_theme_light_scrim,
)

private val DarkColors = darkColorScheme(
    primary = DarkThemeColors.md_theme_dark_primary,
    onPrimary = DarkThemeColors.md_theme_dark_onPrimary,
    primaryContainer = DarkThemeColors.md_theme_dark_primaryContainer,
    onPrimaryContainer = DarkThemeColors.md_theme_dark_onPrimaryContainer,
    secondary = DarkThemeColors.md_theme_dark_secondary,
    onSecondary = DarkThemeColors.md_theme_dark_onSecondary,
    secondaryContainer = DarkThemeColors.md_theme_dark_secondaryContainer,
    onSecondaryContainer = DarkThemeColors.md_theme_dark_onSecondaryContainer,
    tertiary = DarkThemeColors.md_theme_dark_tertiary,
    onTertiary = DarkThemeColors.md_theme_dark_onTertiary,
    tertiaryContainer = DarkThemeColors.md_theme_dark_tertiaryContainer,
    onTertiaryContainer = DarkThemeColors.md_theme_dark_onTertiaryContainer,
    error = DarkThemeColors.md_theme_dark_error,
    errorContainer = DarkThemeColors.md_theme_dark_errorContainer,
    onError = DarkThemeColors.md_theme_dark_onError,
    onErrorContainer = DarkThemeColors.md_theme_dark_onErrorContainer,
    background = DarkThemeColors.md_theme_dark_background,
    onBackground = DarkThemeColors.md_theme_dark_onBackground,
    surface = DarkThemeColors.md_theme_dark_surface,
    onSurface = DarkThemeColors.md_theme_dark_onSurface,
    surfaceVariant = DarkThemeColors.md_theme_dark_surfaceVariant,
    onSurfaceVariant = DarkThemeColors.md_theme_dark_onSurfaceVariant,
    outline = DarkThemeColors.md_theme_dark_outline,
    inverseOnSurface = DarkThemeColors.md_theme_dark_inverseOnSurface,
    inverseSurface = DarkThemeColors.md_theme_dark_inverseSurface,
    inversePrimary = DarkThemeColors.md_theme_dark_inversePrimary,
    surfaceTint = DarkThemeColors.md_theme_dark_surfaceTint,
    outlineVariant = DarkThemeColors.md_theme_dark_outlineVariant,
    scrim = DarkThemeColors.md_theme_dark_scrim,
)

@Composable
fun AllInOneTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColors
        else -> LightColors
    }
    MaterialTheme(
        colorScheme = colorScheme,
        // typography = Typography,
        content = content
    )
}
