package com.mandiri.mandiriapps.presentation

import android.os.Bundle
import android.provider.CalendarContract.Instances
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.bumptech.glide.Glide
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.ActivityProfileBinding
import com.mandiri.mandiriapps.databinding.FragmentHomeBinding
import com.mandiri.mandiriapps.databinding.FragmentProfileBinding
import java.util.zip.Inflater

class PromoFragment : BaseFragment<FragmentProfileBinding>() {
    //    private var _binding: FragmentProfileBinding? = null
//    private val binding get() = _binding!!
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        val imageUrl =
            "https://docs.google.com/forms/d/e/1FAIpQLSc3L8meqRaAfPE4emJlKZ-fpBgLtFI6GB0QciiXEvhClTZfFw/viewscore?chromeless=true&viewscore=AE0zAgDWWRt0G1CkuGOE4rDou-9dZ_JqnKtjEEufVofnFNlWZk3u4j3TiyjAthfJajteYBs"
        // Use Glide to load the image into the ImageView
        Glide.with(this)
            .load(imageUrl)
            .placeholder(R.drawable.baseline_app_shortcut_24) // Placeholder image while loading
            .error(R.drawable.baseline_alternate_email_24) // Image to show if loading fails
            .into(binding.userImage)
    }
//    simbol ! untuk menandakan tidak null

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentProfileBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}