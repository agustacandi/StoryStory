package dev.agustacandi.learn.storystory.ui.settings

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.agustacandi.learn.storystory.R
import dev.agustacandi.learn.storystory.base.BaseFragment
import dev.agustacandi.learn.storystory.databinding.FragmentSettingsBinding
import dev.agustacandi.learn.storystory.utils.ext.showConfirmDialog
import org.koin.android.ext.android.inject

class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {

    private val settingsViewModel: SettingsViewModel by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
        binding.apply {
            actionLogout.setOnClickListener {
                showConfirmDialog(
                    title = getString(R.string.are_you_sure),
                    message = "",
                    positiveButtonText = getString(R.string.yes),
                    negativeButtonText = getString(R.string.no),
                    onPositiveClick = {
                        settingsViewModel.logout()
                        findNavController().navigate(R.id.action_settingsFragment_to_loginFragment)
                    }
                )
            }

            actionChangeLanguage.setOnClickListener {
                startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
            }
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
    }
}