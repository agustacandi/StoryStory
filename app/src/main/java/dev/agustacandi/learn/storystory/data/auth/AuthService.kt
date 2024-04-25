package dev.agustacandi.learn.storystory.data.auth

import dev.agustacandi.learn.storystory.data.remote.response.LoginResponse
import dev.agustacandi.learn.storystory.data.remote.response.Response
import okhttp3.RequestBody
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Part

interface AuthService {
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
    ): Response
}