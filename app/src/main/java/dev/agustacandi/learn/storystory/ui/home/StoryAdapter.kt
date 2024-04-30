package dev.agustacandi.learn.storystory.ui.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import dev.agustacandi.learn.storystory.data.story.Story
import dev.agustacandi.learn.storystory.databinding.ItemStoryBinding
import dev.agustacandi.learn.storystory.utils.ext.formatDate

class StoryAdapter :
    ListAdapter<Story, StoryAdapter.MyViewHolder>(DIFF_CALLBACK) {
    class MyViewHolder(private val binding: ItemStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(story: Story) {
            with(binding) {
                ivItemPhoto.load(story.photoUrl) {
                    placeholder(ColorDrawable(Color.LTGRAY))
                    transformations(RoundedCornersTransformation(20f, 20f, 20f, 20f))
                }
                tvItemUserLabel.text = story.name?.first().toString().uppercase()
                tvItemName.text = story.name
                tvItemDescription.text = story.description
                tvItemTimestamp.text = story.createdAt?.formatDate()
                root.setOnClickListener {
                    val navigateToDetailStory =
                        HomeFragmentDirections.actionHomeFragmentToDetailStoryFragment(story.id.toString())
                    it.findNavController().navigate(navigateToDetailStory)
                }
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
