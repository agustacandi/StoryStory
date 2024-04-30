package dev.agustacandi.learn.storystory.data.story

import android.net.Uri
import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import kotlinx.coroutines.flow.Flow

interface StoryRepository {
    fun getAllStories(): Flow<ApiResponse<StoryResponse>>

    fun addStory(imageUri: Uri, description: String): Flow<ApiResponse<AddStoryResponse>>

    fun detailStory(id: String): Flow<ApiResponse<DetailStoryResponse>>
}