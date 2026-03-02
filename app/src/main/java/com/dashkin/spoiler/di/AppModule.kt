package com.dashkin.spoiler.di

import com.dashkin.spoiler.BuildConfig
import org.koin.dsl.module

// Top-level Koin module for the :app module.
// Provides the Gemini API key and aggregates feature module declarations.
// Feature modules register their own modules here as they are implemented.
val appModule = module {
    single<String>(qualifier = org.koin.core.qualifier.named("geminiApiKey")) {
        BuildConfig.GEMINI_API_KEY
    }
}
