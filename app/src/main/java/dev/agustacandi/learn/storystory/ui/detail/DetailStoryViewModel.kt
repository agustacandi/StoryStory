package dev.agustacandi.learn.storystory.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import dev.agustacandi.learn.storystory.data.story.DetailStoryResponse
import dev.agustacandi.learn.storystory.data.story.Story
import dev.agustacandi.learn.storystory.data.story.StoryRepository
import kotlinx.coroutines.launch

class DetailStoryViewModel(private val storyRepository: StoryRepository) : ViewModel() {
    fun detailStory(id: String) = storyRepository.detailStory(id)
}