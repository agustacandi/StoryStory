package dev.agustacandi.learn.storystory.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shashank.sony.fancytoastlib.FancyToast
import dev.agustacandi.learn.storystory.R
import dev.agustacandi.learn.storystory.base.BaseFragment
import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import dev.agustacandi.learn.storystory.databinding.FragmentLoginBinding
import dev.agustacandi.learn.storystory.utils.Helper
import dev.agustacandi.learn.storystory.utils.ext.gone
import dev.agustacandi.learn.storystory.utils.ext.show
import org.koin.android.ext.android.inject

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val loginViewModel: LoginViewModel by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
        binding.apply {
            loginButton.setOnClickListener {
                val email = edLoginEmail.text?.trim().toString()
                val password = edLoginPassword.text?.trim().toString()

                if (email.isEmpty()) {
                    edLoginEmail.error = getString(R.string.error_empty_field)
                }
                if (password.isEmpty()) {
                    edLoginPassword.error = getString(R.string.error_empty_field)
                }
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    loginViewModel.login(email, password)
                }

            }

            registerButton.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
        binding.apply {
            loginViewModel.loginResult.observe(viewLifecycleOwner) { result ->
                when (result) {
                    is ApiResponse.Loading -> loadingButton.root.show()
                    is ApiResponse.Success -> {
                        Helper.showSuccessToast(requireActivity(), result.data.message)
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    }
                    is ApiResponse.Error -> {
                        loadingButton.root.gone()
                        Helper.showErrorToast(requireActivity(), result.errorMessage)
                    }
                    else -> binding.root.gone()
                }
            }
        }
    }


}