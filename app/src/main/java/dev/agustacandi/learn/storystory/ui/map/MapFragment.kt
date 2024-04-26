package dev.agustacandi.learn.storystory.ui.map

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.agustacandi.learn.storystory.R
import dev.agustacandi.learn.storystory.base.BaseFragment
import dev.agustacandi.learn.storystory.databinding.FragmentMapBinding

class MapFragment : BaseFragment<FragmentMapBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentMapBinding = FragmentMapBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
    }

    override fun initProcess() {
    }

    override fun initObservers() {
    }
}