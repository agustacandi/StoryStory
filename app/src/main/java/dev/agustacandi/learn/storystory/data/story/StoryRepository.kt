package dev.agustacandi.learn.storystory.data.story

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import kotlinx.coroutines.flow.Flow

interface StoryRepository {
    fun getAllStories(size: Int): LiveData<PagingData<Story>>

    fun getAllStoriesWithLocation(): Flow<ApiResponse<StoryResponse>>

    fun addStory(imageUri: Uri, description: String, lat: Double, lon: Double): Flow<ApiResponse<AddStoryResponse>>

    fun detailStory(id: String): LiveData<Story>
}