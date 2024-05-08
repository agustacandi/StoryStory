package dev.agustacandi.learn.storystory.ui.settings

import androidx.lifecycle.ViewModel
import dev.agustacandi.learn.storystory.data.auth.AuthRepository

class SettingsViewModel(private val authRepository: AuthRepository) : ViewModel() {
    fun logout() = authRepository.logout()
}