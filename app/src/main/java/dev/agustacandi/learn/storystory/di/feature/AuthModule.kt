package dev.agustacandi.learn.storystory.di.feature

import dev.agustacandi.learn.storystory.data.auth.AuthRepository
import dev.agustacandi.learn.storystory.data.auth.AuthRepositoryImpl
import org.koin.dsl.module

val authModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
}