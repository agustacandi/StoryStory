package dev.agustacandi.learn.storystory.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.agustacandi.learn.storystory.data.auth.LoginResponse
import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import dev.agustacandi.learn.storystory.data.story.StoryRepositoryImpl
import dev.agustacandi.learn.storystory.data.story.StoryResponse
import kotlinx.coroutines.launch

class HomeViewModel(private val storyRepositoryImpl: StoryRepositoryImpl) : ViewModel() {
    private val _storiesResult = MutableLiveData<ApiResponse<StoryResponse>>()
    val storyResult: LiveData<ApiResponse<StoryResponse>> by lazy { _storiesResult }

    fun getAllStories() {
        viewModelScope.launch {
            storyRepositoryImpl.getAllStories().collect {
                _storiesResult.value = it
            }
        }
    }
}