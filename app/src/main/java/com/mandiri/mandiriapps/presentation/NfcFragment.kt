package com.mandiri.mandiriapps.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.FragmentMessageBinding

class NfcFragment: BaseFragment<FragmentMessageBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMessageBinding {
        return FragmentMessageBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        TODO("Not yet implemented")
    }
}