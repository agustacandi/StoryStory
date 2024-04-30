package dev.agustacandi.learn.storystory.widget

import android.content.Intent
import android.widget.RemoteViewsService
import dev.agustacandi.learn.storystory.data.story.StoryRepositoryImpl
import org.koin.android.ext.android.inject

class StoryWidgetService : RemoteViewsService() {

    private val repo: StoryRepositoryImpl by inject()

    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory =
        StoryRemoteViewsFactory(this.applicationContext, repo)

}