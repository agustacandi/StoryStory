package dev.agustacandi.learn.storystory.data.story

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import dev.agustacandi.learn.storystory.data.lib.BaseResponse

data class StoryResponse(
    @field:SerializedName("listStory")
    val listStory: List<Story> = emptyList(),
): BaseResponse()

class AddStoryResponse: BaseResponse()

data class DetailStoryResponse(
    @field:SerializedName("story")
    val story: Story,
): BaseResponse()

@Entity(tableName = "stories")
data class Story(

    @PrimaryKey
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("photoUrl")
    val photoUrl: String,

    @field:SerializedName("createdAt")
    val createdAt: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("lon")
    val lon: Double = 0.0,

    @field:SerializedName("lat")
    val lat: Double = 0.0
)
