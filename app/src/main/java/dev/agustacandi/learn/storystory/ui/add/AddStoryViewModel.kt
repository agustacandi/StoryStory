package dev.agustacandi.learn.storystory.ui.add

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import dev.agustacandi.learn.storystory.data.story.AddStoryResponse
import dev.agustacandi.learn.storystory.data.story.StoryRepositoryImpl
import kotlinx.coroutines.launch

class AddStoryViewModel(private val storyRepositoryImpl: StoryRepositoryImpl) : ViewModel() {
    private val _addStoryResult = MutableLiveData<ApiResponse<AddStoryResponse>>()
    val addStoryResult: LiveData<ApiResponse<AddStoryResponse>> by lazy { _addStoryResult }

    fun addStory(imageUri: Uri, description: String) {
        viewModelScope.launch {
            storyRepositoryImpl.addStory(imageUri, description).collect {
                _addStoryResult.value = it
            }
        }
    }
}