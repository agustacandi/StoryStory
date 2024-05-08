package dev.agustacandi.learn.storystory.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dev.agustacandi.learn.storystory.data.story.Story
import dev.agustacandi.learn.storystory.data.story.StoryRepository

class HomeViewModel(private val storyRepository: StoryRepository) : ViewModel() {
    private var _storyResult = MutableLiveData<PagingData<Story>>()
    val storyResult: LiveData<PagingData<Story>> = _storyResult

    fun getAllStories(size: Int = 5) {
        storyRepository.getAllStories(size).cachedIn(viewModelScope).observeForever {
            _storyResult.value = it
        }
    }
}