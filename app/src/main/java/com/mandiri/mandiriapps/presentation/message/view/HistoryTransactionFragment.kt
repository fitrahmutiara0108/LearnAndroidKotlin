package com.mandiri.mandiriapps.presentation.message.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mandiri.mandiriapps.adapter.MessageTabAdapter
import com.mandiri.mandiriapps.databinding.FragmentHistoryTransactionBinding
import com.mandiri.mandiriapps.databinding.FragmentMessageBinding

class HistoryTransactionFragment: Fragment() {
    private var _binding: FragmentHistoryTransactionBinding? = null
    private val binding get() = _binding!!
//    simbol ! untuk menandakan tidak null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //to avoid memory leaks, nullify the binding object on this method
        _binding = null
    }
}