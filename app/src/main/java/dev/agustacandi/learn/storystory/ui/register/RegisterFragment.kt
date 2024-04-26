package dev.agustacandi.learn.storystory.ui.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shashank.sony.fancytoastlib.FancyToast
import dev.agustacandi.learn.storystory.R
import dev.agustacandi.learn.storystory.base.BaseFragment
import dev.agustacandi.learn.storystory.data.lib.ApiResponse
import dev.agustacandi.learn.storystory.databinding.FragmentRegisterBinding
import dev.agustacandi.learn.storystory.utils.Helper
import dev.agustacandi.learn.storystory.utils.ext.gone
import dev.agustacandi.learn.storystory.utils.ext.show
import org.koin.android.ext.android.inject

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    private val registerViewModel: RegisterViewModel by inject()

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
                val name = edRegisterName.text.trim().toString()
                val email = edRegisterEmail.text?.trim().toString()
                val password = edRegisterPassword.text?.trim().toString()

                if (name.isEmpty()) {
                    edRegisterName.error = getString(R.string.error_empty_field)
                }
                if (email.isEmpty()) {
                    edRegisterEmail.error = getString(R.string.error_empty_field)
                }
                if (password.isEmpty()) {
                    edRegisterPassword.error = getString(R.string.error_empty_field)
                }

                if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                    registerViewModel.register(name, email, password)
                }

            }
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
        binding.apply {
            registerViewModel.registerResult.observe(viewLifecycleOwner) { result ->
                when (result) {
                    is ApiResponse.Loading -> loadingButton.root.show()
                    is ApiResponse.Success -> {
                        FancyToast.makeText(
                            requireContext(),
                            result.data.message,
                            FancyToast.LENGTH_LONG,
                            FancyToast.SUCCESS,
                            false
                        ).show()
                        findNavController().popBackStack()
                    }

                    is ApiResponse.Error -> {
                        loadingButton.root.gone()
                        FancyToast.makeText(
                            requireContext(),
                            result.errorMessage,
                            FancyToast.LENGTH_LONG,
                            FancyToast.ERROR,
                            false
                        ).show()
                    }

                    else -> binding.root.gone()
                }
            }
        }
    }

}