package dev.agustacandi.learn.storystory.data.remote.response

import com.google.gson.annotations.SerializedName
import dev.agustacandi.learn.storystory.data.lib.BaseResponse

data class StoryResponse(
    @field:SerializedName("listStory")
    val listStory: List<Story> = listOf(),
): BaseResponse()

data class Story(

    @field:SerializedName("photoUrl")
    val photoUrl: String? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("lon")
    val lon: Any? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("lat")
    val lat: Any? = null
)
