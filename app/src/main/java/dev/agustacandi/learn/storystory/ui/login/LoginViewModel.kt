package dev.agustacandi.learn.storystory.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.agustacandi.learn.storystory.data.auth.AuthRepository
import dev.agustacandi.learn.storystory.data.auth.AuthRepositoryImpl
import dev.agustacandi.learn.storystory.data.auth.LoginRequest
import dev.agustacandi.learn.storystory.data.auth.LoginResponse
import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import kotlinx.coroutines.launch

class LoginViewModel(private val authRepository: AuthRepository) : ViewModel() {
    private val _loginResult = MutableLiveData<ApiResponse<LoginResponse>>()
    val loginResult: LiveData<ApiResponse<LoginResponse>> by lazy { _loginResult }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            authRepository.login(LoginRequest(email, password)).collect {
                _loginResult.value = it
            }
        }
    }
}