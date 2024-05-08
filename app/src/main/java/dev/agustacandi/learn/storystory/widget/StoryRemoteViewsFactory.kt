package dev.agustacandi.learn.storystory.widget

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import androidx.core.graphics.drawable.toBitmap
import androidx.core.os.bundleOf
import coil.imageLoader
import coil.request.ImageRequest
import dev.agustacandi.learn.storystory.R
import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import dev.agustacandi.learn.storystory.data.story.Story
import dev.agustacandi.learn.storystory.data.story.StoryRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

internal class StoryRemoteViewsFactory(
    private val mContext: Context,
    private val storyRepositoryImpl: StoryRepositoryImpl
) : RemoteViewsService.RemoteViewsFactory,
    CoroutineScope {

    private val parentJob = Job()
    private var mWidgetItems = listOf<Story>()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + parentJob

    override fun onCreate() {
//        launch {
//            storyRepositoryImpl.getAllStories(location = 0).collect {
//                when (it) {
//                    is ApiResponse.Success -> updateWidgetItems(it.data.listStory)
//                    else -> Log.d("StoryWidget", "Error")
//                }
//            }
//
//        }
    }

    override fun onDataSetChanged() {
    }

    override fun onDestroy() {
        parentJob.cancel()
    }

    override fun getCount(): Int = mWidgetItems.size

    override fun getViewAt(position: Int): RemoteViews {
        val rv = RemoteViews(mContext.packageName, R.layout.story_widget)


        mWidgetItems.forEach { data ->
            val photoUrl = data.photoUrl

            launch {
                rv.setImageViewBitmap(
                    R.id.imageView,
                    getImageFromUri(photoUrl.toString()).toBitmap(width = 400, height = 400)
                )
            }

        }

        val extras = bundleOf(
            StoryWidget.EXTRA_ITEM to position
        )
        val fillInIntent = Intent()
        fillInIntent.putExtras(extras)
        rv.setOnClickFillInIntent(R.id.imageView, fillInIntent)

        return rv
    }

    override fun getLoadingView(): RemoteViews? = null

    override fun getViewTypeCount(): Int = 1

    override fun getItemId(i: Int): Long = 0

    override fun hasStableIds(): Boolean = false

    private fun updateWidgetItems(newItems: List<Story>) {
        mWidgetItems = newItems
        AppWidgetManager.getInstance(mContext).notifyAppWidgetViewDataChanged(
            AppWidgetManager.getInstance(mContext).getAppWidgetIds(
                ComponentName(mContext, StoryWidget::class.java)
            ), R.id.stack_view
        )
    }

    private suspend fun getImageFromUri(photoUrl: String): Drawable {
        val request = ImageRequest.Builder(mContext)
            .data(photoUrl)
            .build()
        val drawable = mContext.imageLoader.execute(request).drawable
        return drawable!!
    }
}