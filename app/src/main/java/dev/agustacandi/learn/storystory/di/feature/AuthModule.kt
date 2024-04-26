package dev.agustacandi.learn.storystory.di.feature

import dev.agustacandi.learn.storystory.data.auth.AuthRepositoryImpl
import org.koin.dsl.module

val authModule = module {
    single { AuthRepositoryImpl(get(), get()) }
}