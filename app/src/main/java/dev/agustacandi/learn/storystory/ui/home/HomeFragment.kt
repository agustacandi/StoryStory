package dev.agustacandi.learn.storystory.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import dev.agustacandi.learn.storystory.R
import dev.agustacandi.learn.storystory.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        

        binding.addStoryButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_addStoryFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}