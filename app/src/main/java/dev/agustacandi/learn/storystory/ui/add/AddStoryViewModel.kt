package dev.agustacandi.learn.storystory.ui.add

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import dev.agustacandi.learn.storystory.data.story.AddStoryResponse
import dev.agustacandi.learn.storystory.data.story.StoryRepository
import kotlinx.coroutines.launch

class AddStoryViewModel(private val storyRepository: StoryRepository) : ViewModel() {
    private val _addStoryResult = MutableLiveData<ApiResponse<AddStoryResponse>>()
    val addStoryResult: LiveData<ApiResponse<AddStoryResponse>> by lazy { _addStoryResult }

    fun addStory(imageUri: Uri, description: String, lat: Double = 0.0, lon: Double = 0.0) {
        viewModelScope.launch {
            storyRepository.addStory(imageUri, description, lat, lon).collect {
                _addStoryResult.value = it
            }
        }
    }
}