package dev.agustacandi.learn.storystory.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dev.agustacandi.learn.storystory.R
import dev.agustacandi.learn.storystory.base.BaseFragment
import dev.agustacandi.learn.storystory.databinding.FragmentSplashBinding
import dev.agustacandi.learn.storystory.utils.SPLASH_SCREEN_DURATION
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSplashBinding = FragmentSplashBinding.inflate(inflater, container, false)

    override fun initIntent() {

    }

    override fun initUI() {
    }

    override fun initAction() {
    }

    override fun initProcess() {
        lifecycleScope.launch {
            delay(SPLASH_SCREEN_DURATION.seconds)
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }
    }

    override fun initObservers() {
    }

}