package dev.agustacandi.learn.storystory.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import dev.agustacandi.learn.storystory.data.story.DetailStoryResponse
import dev.agustacandi.learn.storystory.data.story.StoryRepositoryImpl
import kotlinx.coroutines.launch

class DetailStoryViewModel(private val storyRepositoryImpl: StoryRepositoryImpl) : ViewModel() {
    private val _detailStoryResult = MutableLiveData<ApiResponse<DetailStoryResponse>>()
    val detailStoryResult: LiveData<ApiResponse<DetailStoryResponse>> by lazy { _detailStoryResult }

    fun detailStory(id: String) {
        viewModelScope.launch {
            storyRepositoryImpl.detailStory(id).collect {
                _detailStoryResult.value = it
            }
        }
    }
}