package com.mandiri.mandiriapps.presentation.message.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.adapter.MessageTabAdapter
import com.mandiri.mandiriapps.adapter.NotificationAdapter
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.FragmentMessageBinding
import com.mandiri.mandiriapps.databinding.FragmentNotificationBinding
import com.mandiri.mandiriapps.model.HistoryTransactionModel
import com.mandiri.mandiriapps.model.NotificationModel
import com.mandiri.mandiriapps.presentation.message.viewmodel.NotificationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    private val viewModel: NotificationViewModel by viewModels()
    //    private var _binding: FragmentNotificationBinding? = null
//    private val binding get() = _binding!!
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
//    simbol ! untuk menandakan tidak null

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupViewNotificationBinding()
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        //to avoid memory leaks, nullify the binding object on this method
//        _binding = null
//    }

//    private fun setupViewNotificationBinding() {
//        binding.vNotification.rvNotification.adapter = NotificationAdapter(
//            data = populateDataNotification()
//        )
//    }


}