package dev.agustacandi.learn.storystory

import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.agustacandi.learn.storystory.data.story.Story

class PaggingData : PagingSource<Int, Story>() {
    override fun getRefreshKey(state: PagingState<Int, Story>): Int = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Story> =
        LoadResult.Page(emptyList(),0,1)

    companion object {
        fun snapshot(items: List<Story>): PagingData<Story> {
            return PagingData.from(items)
        }
    }
}