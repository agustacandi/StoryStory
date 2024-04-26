package dev.agustacandi.learn.storystory.di

import dev.agustacandi.learn.storystory.utils.PreferenceManager
import org.koin.dsl.module

val preferenceModule = module {
    single { PreferenceManager(get()) }
}