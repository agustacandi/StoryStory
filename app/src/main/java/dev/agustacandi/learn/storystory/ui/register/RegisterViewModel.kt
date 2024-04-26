package dev.agustacandi.learn.storystory.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.agustacandi.learn.storystory.data.auth.AuthRepositoryImpl
import dev.agustacandi.learn.storystory.data.auth.RegisterRequest
import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import dev.agustacandi.learn.storystory.data.lib.BaseResponse
import kotlinx.coroutines.launch

class RegisterViewModel(private val authRepositoryImpl: AuthRepositoryImpl) : ViewModel() {
    private val _registerResult = MutableLiveData<ApiResponse<BaseResponse>>()
    val registerResult: LiveData<ApiResponse<BaseResponse>> by lazy { _registerResult }

    fun register(name: String, email: String, password: String) {
        viewModelScope.launch {
            authRepositoryImpl.register(RegisterRequest(name, email, password)).collect {
                _registerResult.value = it
            }
        }
    }
}