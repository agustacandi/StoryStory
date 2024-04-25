package dev.agustacandi.learn.storystory.di

import dev.agustacandi.learn.storystory.BuildConfig
import dev.agustacandi.learn.storystory.data.auth.AuthService
import dev.agustacandi.learn.storystory.data.story.StoryService
import dev.agustacandi.learn.storystory.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val loggingInterceptor = if (BuildConfig.DEBUG) {
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
} else {
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }
    single { provideAuthService(get()) }
    single { provideStoryService(get()) }
}

fun provideAuthService(retrofit: Retrofit): AuthService = retrofit.create(AuthService::class.java)

fun provideStoryService(retrofit: Retrofit): StoryService = retrofit.create(StoryService::class.java)