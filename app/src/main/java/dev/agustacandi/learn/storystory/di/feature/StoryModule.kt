package dev.agustacandi.learn.storystory.di.feature

import dev.agustacandi.learn.storystory.data.story.StoryRepository
import dev.agustacandi.learn.storystory.data.story.StoryRepositoryImpl
import org.koin.dsl.module

val storyModule = module {
    single<StoryRepository> { StoryRepositoryImpl(get(), get()) }
}