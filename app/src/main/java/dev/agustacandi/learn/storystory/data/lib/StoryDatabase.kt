package dev.agustacandi.learn.storystory.data.lib

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.agustacandi.learn.storystory.data.remote_keys.RemoteKeys
import dev.agustacandi.learn.storystory.data.remote_keys.RemoteKeysDao
import dev.agustacandi.learn.storystory.data.story.Story
import dev.agustacandi.learn.storystory.data.story.StoryDao

@Database(entities = [Story::class, RemoteKeys::class], version = 2, exportSchema = false)
abstract class StoryDatabase : RoomDatabase() {

    abstract fun storyDao(): StoryDao

    abstract fun remoteKeysDao(): RemoteKeysDao

}