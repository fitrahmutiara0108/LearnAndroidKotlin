package com.mandiri.mandiriapps.presentation.message.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.adapter.MessageTabAdapter
import com.mandiri.mandiriapps.adapter.NotificationAdapter
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.FragmentMessageBinding
import com.mandiri.mandiriapps.databinding.FragmentNotificationBinding
import com.mandiri.mandiriapps.model.HistoryTransactionModel
import com.mandiri.mandiriapps.model.NotificationModel

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    //    private var _binding: FragmentNotificationBinding? = null
//    private val binding get() = _binding!!
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        setupViewNotificationBinding()
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

    private fun setupViewNotificationBinding() {
        binding.vNotification.rvNotification.adapter = NotificationAdapter(
            data = populateDataNotification()
        )
    }

    private fun populateDataNotification(): List<NotificationModel> {
        return listOf(
            NotificationModel(
                date = "11 Januari 2024",
                title = "Anda mendapat saldo masuk",
                description = "Saldo masuk sebesar Rp2.000.000.000,00"
            ),
            NotificationModel(
                date = "12 Januari 2024",
                title = "Anda mendapat saldo masuk",
                description = "Saldo masuk sebesar Rp5.000.000,00"
            )
        )
    }

}