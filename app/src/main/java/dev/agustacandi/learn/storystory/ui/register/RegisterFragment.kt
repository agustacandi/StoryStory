package dev.agustacandi.learn.storystory.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.agustacandi.learn.storystory.R
import dev.agustacandi.learn.storystory.base.BaseFragment
import dev.agustacandi.learn.storystory.databinding.FragmentRegisterBinding

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentRegisterBinding = FragmentRegisterBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
        binding.apply {
            registerButton.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
            }
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
    }

}