package dev.agustacandi.learn.storystory.data.remote.retrofit

import dev.agustacandi.learn.storystory.data.remote.response.LoginResponse
import dev.agustacandi.learn.storystory.data.lib.BaseResponse
import dev.agustacandi.learn.storystory.data.remote.response.StoryResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ApiService {
    @GET("stories")
    suspend fun getAllStories(
        @Query("location") location: Boolean
    ): StoryResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Part("email") email: RequestBody,
        @Part("password") password: RequestBody
    ): LoginResponse

    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Part("name") name: RequestBody,
        @Part("email") email: RequestBody,
        @Part("password") password: RequestBody
    ): BaseResponse

    @Multipart
    @POST("stories")
    suspend fun addNewStory(
        @Part("description") description: RequestBody,
        @Part("photo") photo: MultipartBody.Part,
        @Part("lat") lat: RequestBody,
        @Part("lon") lon: RequestBody,
    )
}