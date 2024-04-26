package dev.agustacandi.learn.storystory.data.story

import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StoryRepositoryImpl(private val storyService: StoryService) : StoryRepository {
    override fun getAllStories(): Flow<ApiResponse<StoryResponse>> = flow {
        try {
            emit(ApiResponse.Loading)
            val response = storyService.getAllStories()
            if (response.error) {
                emit(ApiResponse.Error(response.message))
            } else {
                emit(ApiResponse.Success(response))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ApiResponse.Error(e.message.toString()))
        }
    }

    override fun addStory(): Flow<ApiResponse<AddStoryResponse>> = flow {  }

    override fun detailStory(dto: AddStoryRequest): Flow<ApiResponse<DetailStoryResponse>> = flow {  }
}