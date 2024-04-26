package dev.agustacandi.learn.storystory.ui.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.agustacandi.learn.storystory.data.story.Story
import dev.agustacandi.learn.storystory.databinding.ItemStoryBinding
import dev.agustacandi.learn.storystory.utils.ext.formatDate

class StoryAdapter :
    ListAdapter<Story, StoryAdapter.MyViewHolder>(DIFF_CALLBACK) {
    class MyViewHolder(private val binding: ItemStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(story: Story) {
            with(binding) {
                Glide.with(root).load(story.photoUrl).placeholder(ColorDrawable(Color.LTGRAY))
                    .into(ivItemPhoto)
                tvItemUserLabel.text = story.name?.first().toString().uppercase()
                tvItemName.text = story.name
                tvItemDescription.text = story.description
                tvItemTimestamp.text = story.createdAt?.formatDate()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Story>() {
            override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
                return oldItem == newItem
            }
        }
    }
}
