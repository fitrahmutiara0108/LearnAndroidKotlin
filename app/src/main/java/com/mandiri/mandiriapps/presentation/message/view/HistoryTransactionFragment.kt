package com.mandiri.mandiriapps.presentation.message.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.adapter.HistoryTransactionAdapter
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.FragmentHistoryTransactionBinding
import com.mandiri.mandiriapps.model.HistoryTransactionModel
import com.mandiri.mandiriapps.presentation.DetailTransactionActivity
import com.mandiri.mandiriapps.presentation.message.viewmodel.HistoryTransactionViewModel
import com.mandiri.mandiriapps.utils.ConfirmationDialogUtil

class HistoryTransactionFragment : BaseFragment<FragmentHistoryTransactionBinding>() {
    private lateinit var data: HistoryTransactionModel
    private lateinit var dialogConfirmation: ConfirmationDialogUtil
    private val viewModel: HistoryTransactionViewModel by viewModels()

    private lateinit var historyTransactionAdapter: HistoryTransactionAdapter

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHistoryTransactionBinding {
        return FragmentHistoryTransactionBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.setData()
        dialogConfirmation = ConfirmationDialogUtil(requireContext())

        setupRecyclerView()
        setupSpinner()
    }

    private fun setupRecyclerView() {
        viewModel.historyTransactionData.observe(viewLifecycleOwner) { historyData ->
            historyTransactionAdapter = HistoryTransactionAdapter(
                data = historyData,
                onClickHistoryTransaction = {
                    data = it
                    showConfirmation()
                }
            )

            binding.vHistoryTransaction.rvHistoryTransaction.apply {
                adapter = historyTransactionAdapter
                layoutManager = LinearLayoutManager(activity)
            }
        }
    }

    private fun setupSpinner() {
        val items = arrayOf("Semua", "Debit", "Credit")
        binding.vHistoryTransaction.sTitle.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, items)

        binding.vHistoryTransaction.sTitle.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val spinnerValue = parent?.getItemAtPosition(position).toString()
                    binding.vHistoryTransaction.tvFilterName.text = spinnerValue

                    val filteredData = if (spinnerValue == "Semua") {
                        viewModel.historyTransactionData.value
                    } else {
                        viewModel.historyTransactionData.value?.filter { it.titleTransaction == spinnerValue.lowercase() }
                    }

                    filteredData?.let { historyTransactionAdapter.filterTransactionData(it) }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
    }

    private fun showConfirmation() {
        val icon = R.drawable.ic_home

        dialogConfirmation.showConfirmationDialog(
            title = "Detail History",
            isOnHistoryTransaction = true,
            icon = icon,
            onConfirm = {
                DetailTransactionActivity.navigateToDetailTransaction(
                    activity = requireActivity(),
                    data = data
                )
            }, onCancel =
            {})
    }
}

