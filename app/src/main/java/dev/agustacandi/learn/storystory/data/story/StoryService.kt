package dev.agustacandi.learn.storystory.data.story

import dev.agustacandi.learn.storystory.data.remote.response.StoryResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface StoryService {
    @GET("stories")
    suspend fun getAllStories(
        @Query("location") location: Boolean
    ): StoryResponse

    @Multipart
    @POST("stories")
    suspend fun addNewStory(
        @Part("description") description: RequestBody,
        @Part("photo") photo: MultipartBody.Part,
        @Part("lat") lat: RequestBody,
        @Part("lon") lon: RequestBody,
    )
}