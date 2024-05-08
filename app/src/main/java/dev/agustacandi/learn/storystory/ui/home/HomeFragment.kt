package dev.agustacandi.learn.storystory.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dev.agustacandi.learn.storystory.R
import dev.agustacandi.learn.storystory.base.BaseFragment
import dev.agustacandi.learn.storystory.databinding.FragmentHomeBinding
import dev.agustacandi.learn.storystory.utils.PreferenceManager
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by inject()
    private val preferenceManager: PreferenceManager by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
        binding.apply {
            userLabel.text = preferenceManager.getName?.first().toString().uppercase()
            greetingText.text = getString(R.string.greeting, preferenceManager.getName)
        }
    }

    override fun initAction() {
        binding.addStoryButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addStoryFragment)
        }
    }

    override fun initProcess() {
        homeViewModel.getAllStories()
    }

    override fun initObservers() {
            val storyAdapter = StoryAdapter()
            val linearLayoutManager = LinearLayoutManager(requireActivity())
            val itemDecoration = DividerItemDecoration(
                requireActivity(),
                linearLayoutManager.orientation
            )
            binding.rvStory.apply {
                adapter = storyAdapter.withLoadStateFooter(
                    footer = LoadingStateAdapter { storyAdapter.retry() }
                )
                layoutManager = linearLayoutManager
                addItemDecoration(itemDecoration)
            }
        homeViewModel.storyResult.observe(viewLifecycleOwner) { result ->
            storyAdapter.submitData(viewLifecycleOwner.lifecycle, result)
        }
    }
}