package com.mandiri.mandiriapps.presentation.message.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mandiri.mandiriapps.adapter.NotificationAdapter
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.FragmentNotificationBinding
import com.mandiri.mandiriapps.presentation.message.viewmodel.NotificationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    private val viewModel: NotificationViewModel by viewModels()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.setData()
        viewModel.notificationData.observe(viewLifecycleOwner){
            val notificationAdapter = NotificationAdapter(it)
            binding.vNotification.rvNotification.apply {
                adapter = notificationAdapter
                layoutManager = LinearLayoutManager(activity)
            }
        }
    }
}