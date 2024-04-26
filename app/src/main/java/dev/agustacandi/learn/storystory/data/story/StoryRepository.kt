package dev.agustacandi.learn.storystory.data.story

import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import kotlinx.coroutines.flow.Flow

interface StoryRepository {
    fun getAllStories(): Flow<ApiResponse<StoryResponse>>

    fun addStory(): Flow<ApiResponse<AddStoryResponse>>

    fun detailStory(dto: AddStoryRequest): Flow<ApiResponse<DetailStoryResponse>>
}