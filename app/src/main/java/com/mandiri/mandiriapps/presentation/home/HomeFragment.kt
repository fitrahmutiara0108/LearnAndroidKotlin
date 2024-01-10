package com.mandiri.mandiriapps.presentation.home

import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.adapter.EwalletAdapter
import com.mandiri.mandiriapps.adapter.MenuHomeAdapter
import com.mandiri.mandiriapps.adapter.SavingAdapter
import com.mandiri.mandiriapps.adapter.ServiceMenuAdapter
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.FragmentHomeBinding
import com.mandiri.mandiriapps.helper.SharedPrefHelper
import com.mandiri.mandiriapps.model.EwalletModel
import com.mandiri.mandiriapps.model.SavingModel
import com.mandiri.mandiriapps.model.ServiceModel
import com.mandiri.mandiriapps.presentation.home.viewmodel.HomeViewModel
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private lateinit var listSaving: MutableList<SavingModel>
    private lateinit var listServiceMenu: MutableList<ServiceModel>
//    private var dummyEwalletList: MutableList<EwalletModel>? = null
    private val viewModel: HomeViewModel by viewModels()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.setData()

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.homeServiceData.observe(viewLifecycleOwner) {
            listServiceMenu = it
            setUpViewService()
        }
        viewModel.homeSavingData.observe(viewLifecycleOwner) {
            listSaving = it
            updateSaving()
        }
        viewModel.homeEWalletData.observe(viewLifecycleOwner) {
            setupViewWallet(it)
        }
    }

    private fun setupViewWallet(data: MutableList<EwalletModel>) {
        val ewalletAdapter = EwalletAdapter()
        ewalletAdapter.setDataEwallet(data)

        binding.vComponentHomeEwallet.rvEwallet.apply {
            adapter = ewalletAdapter
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)

        }

        ewalletAdapter.setOnClickEwallet { Ewallet ->
            Toast.makeText(
                context,
                "Berhasil menghubungkan ${Ewallet.name}",
                Toast.LENGTH_SHORT
            )
                .show()

            data.forEach() {
                if (it.name == Ewallet.name){
                    it.isConnected = true
//                    ewalletAdapter.setDataEwallet(data.toMutableList())
                }
            }

            ewalletAdapter.setDataEwallet(data.toMutableList() ?: mutableListOf())
        }
    }


    private fun setUpViewService() {
        val serviceMenuAdapter = ServiceMenuAdapter(listServiceMenu)

        binding.vComponentHomeEwallet.rvEwallet.apply {
            binding.vComponentHomeService.rvService.adapter = serviceMenuAdapter
            binding.vComponentHomeService.rvService.layoutManager = GridLayoutManager(
                context,
                2,
                RecyclerView.HORIZONTAL,
                false
            )
            serviceMenuAdapter.setOnClickMenu {
                Toast.makeText(context, it.menuTitle, Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun updateSaving() {
        val savingAdapter = SavingAdapter(listSaving)
        binding.vComponentHomeSaving.apply {
            rvSaving.adapter = savingAdapter
            rvSaving.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            btnShowMore.isVisible = listSaving.size > 2
            btnShowMore.setOnClickListener {
                savingAdapter.updateQuantitySize(listSaving.size)
                btnShowMore.visibility = View.GONE
                btnShowLess.visibility = View.VISIBLE
            }
            btnShowLess.setOnClickListener {
                savingAdapter.updateQuantitySize(2)
                btnShowMore.visibility = View.VISIBLE
                btnShowLess.visibility = View.GONE
            }
        }
    }


}