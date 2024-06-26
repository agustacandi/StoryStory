package dev.agustacandi.learn.storystory.utils

import dev.agustacandi.learn.storystory.BuildConfig
import dev.agustacandi.learn.storystory.R
import dev.agustacandi.learn.storystory.di.databaseModule
import dev.agustacandi.learn.storystory.di.feature.authModule
import dev.agustacandi.learn.storystory.di.feature.storyModule
import dev.agustacandi.learn.storystory.di.networkModule
import dev.agustacandi.learn.storystory.di.preferenceModule
import dev.agustacandi.learn.storystory.di.viewModelModule

object ConstVal {
    // Koin Modules
    val koinModules = listOf(
        networkModule,
        preferenceModule,
        viewModelModule,
        databaseModule,
        authModule,
        storyModule,
    )

    // Navigation Bar Destination
    val navBarDestination = listOf(R.id.homeFragment, R.id.mapFragment, R.id.settingsFragment)

    const val SPLASH_SCREEN_DURATION = 3
    const val BASE_URL = BuildConfig.BASE_URL
    const val DATABASE_NAME = "story_database"
    const val INITIAL_PAGE_INDEX = 1

    // Shared Preferences
    const val PREFS_NAME = "storystory.pref"
    const val KEY_TOKEN = "key.token"
    const val KEY_NAME = "key.name"

    const val MAXIMAL_SIZE = 1000000 // 1 MB
    const val FILENAME_FORMAT = "yyyyMMdd_HHmmss"
}