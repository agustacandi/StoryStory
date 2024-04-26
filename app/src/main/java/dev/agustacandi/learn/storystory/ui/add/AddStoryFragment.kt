package dev.agustacandi.learn.storystory.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import dev.agustacandi.learn.storystory.base.BaseFragment
import dev.agustacandi.learn.storystory.databinding.FragmentAddStoryBinding

class AddStoryFragment : BaseFragment<FragmentAddStoryBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentAddStoryBinding = FragmentAddStoryBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
        binding.apply {

        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
    }


}