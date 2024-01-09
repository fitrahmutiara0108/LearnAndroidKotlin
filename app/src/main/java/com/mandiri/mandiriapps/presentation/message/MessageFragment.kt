package com.mandiri.mandiriapps.presentation.message

import android.os.Bundle
import android.provider.CalendarContract.Instances
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.google.android.material.tabs.TabLayoutMediator
import com.mandiri.mandiriapps.adapter.MessageTabAdapter
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.ActivityDetailTransactionBinding
import com.mandiri.mandiriapps.databinding.ComponentToolbarBinding
import com.mandiri.mandiriapps.databinding.FragmentHomeBinding
import com.mandiri.mandiriapps.databinding.FragmentMessageBinding
import com.mandiri.mandiriapps.databinding.FragmentProfileBinding
import com.mandiri.mandiriapps.presentation.message.view.HistoryTransactionFragment
import com.mandiri.mandiriapps.presentation.message.view.NotificationFragment
import java.util.zip.Inflater

class MessageFragment : BaseFragment<FragmentMessageBinding>() {
//    private var _binding: FragmentMessageBinding? = null
//    private var _testBool = false
    private var adapterMessage : MessageTabAdapter?= null
//    private val binding get() = _binding!!
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMessageBinding {
        return FragmentMessageBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        setUpTabView()

        binding.vToolbar.tvTitle.text = "Message"
    }
//    simbol ! untuk menandakan tidak null

    private fun setUpTabView() {
        val tabLayout = binding.tabMessage
        val viewPager = binding.vpMessage
        adapterMessage = MessageTabAdapter(this)
//        adapterMessage?.addListFragment(NotificationFragment())
//        adapterMessage?.addListFragment(HistoryTransactionFragment())
        viewPager.adapter = adapterMessage

        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            when(position){
                0 -> {
                    tab.text = "Notification"
                }
                1 -> {
                    tab.text = "History"
                }
            }
        }.attach()
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentMessageBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }
//    override fun onDestroyView() {
//        super.onDestroyView()
//        //to avoid memory leaks, nullify the binding object on this method
//        _binding = null
//    }
}