package dev.agustacandi.learn.storystory.di

import dev.agustacandi.learn.storystory.ui.add.AddStoryViewModel
import dev.agustacandi.learn.storystory.ui.detail.DetailStoryViewModel
import dev.agustacandi.learn.storystory.ui.home.HomeViewModel
import dev.agustacandi.learn.storystory.ui.login.LoginViewModel
import dev.agustacandi.learn.storystory.ui.map.MapViewModel
import dev.agustacandi.learn.storystory.ui.register.RegisterViewModel
import dev.agustacandi.learn.storystory.ui.settings.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { AddStoryViewModel(get()) }
    viewModel { DetailStoryViewModel(get()) }
    viewModel { SettingsViewModel(get()) }
    viewModel { MapViewModel(get()) }
}