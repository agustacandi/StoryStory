package dev.agustacandi.learn.storystory.data.story

import com.google.gson.annotations.SerializedName
import dev.agustacandi.learn.storystory.data.lib.BaseResponse

data class StoryResponse(
    @field:SerializedName("listStory")
    val listStory: List<Story> = listOf(),
): BaseResponse()

data class AddStoryRequest(
    val description: String,
    val photo: String
)

class AddStoryResponse: BaseResponse()

data class DetailStoryResponse(
    @field:SerializedName("story")
    val story: Story = Story(),
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
    val lon: Float? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("lat")
    val lat: Float? = null
)