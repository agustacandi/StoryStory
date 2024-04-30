package dev.agustacandi.learn.storystory.ui.settings

import androidx.lifecycle.ViewModel
import dev.agustacandi.learn.storystory.data.auth.AuthRepositoryImpl

class SettingsViewModel(private val authRepositoryImpl: AuthRepositoryImpl) : ViewModel() {
    fun logout() = authRepositoryImpl.logout()
}