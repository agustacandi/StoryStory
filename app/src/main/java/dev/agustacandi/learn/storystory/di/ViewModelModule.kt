package dev.agustacandi.learn.storystory.di

import dev.agustacandi.learn.storystory.ui.home.HomeViewModel
import dev.agustacandi.learn.storystory.ui.login.LoginViewModel
import dev.agustacandi.learn.storystory.ui.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}