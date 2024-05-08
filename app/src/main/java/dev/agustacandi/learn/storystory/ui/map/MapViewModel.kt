package dev.agustacandi.learn.storystory.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import dev.agustacandi.learn.storystory.data.story.StoryRepository
import dev.agustacandi.learn.storystory.data.story.StoryResponse
import kotlinx.coroutines.launch

class MapViewModel(private val storyRepository: StoryRepository) : ViewModel() {

    private val _storiesResult = MutableLiveData<ApiResponse<StoryResponse>>()
    val storyResult: LiveData<ApiResponse<StoryResponse>> by lazy { _storiesResult }

    fun getAllStoriesWithLocation() {
        viewModelScope.launch {
            storyRepository.getAllStoriesWithLocation().collect {
                _storiesResult.value = it
            }
        }
    }

}