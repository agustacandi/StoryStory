package dev.agustacandi.learn.storystory.di

import androidx.room.Room
import dev.agustacandi.learn.storystory.data.lib.StoryDatabase
import dev.agustacandi.learn.storystory.utils.ConstVal
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            StoryDatabase::class.java,
            ConstVal.DATABASE_NAME
        ).build()
    }

    single { get<StoryDatabase>().storyDao() }
    single { get<StoryDatabase>().remoteKeysDao() }
}