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
import com.mandiri.mandiriapps.databinding.ActivityProfileBinding
import com.mandiri.mandiriapps.databinding.FragmentHomeBinding
import com.mandiri.mandiriapps.databinding.FragmentProfileBinding
import java.util.zip.Inflater

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
//    simbol ! untuk menandakan tidak null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageUrl =
            "https://cdn0-production-images-kly.akamaized.net/7Jn9Xobt5oVf-GtQWnO5kn_alRU=/1200x900/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/4255282/original/094712800_1670569941-mandiri.jpg"
        // Use Glide to load the image into the ImageView
        Glide.with(this)
            .load(imageUrl)
            .placeholder(R.drawable.baseline_app_shortcut_24) // Placeholder image while loading
            .error(R.drawable.baseline_alternate_email_24) // Image to show if loading fails
            .into(binding.userImage)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}