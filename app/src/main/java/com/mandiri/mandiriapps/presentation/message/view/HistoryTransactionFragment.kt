package com.mandiri.mandiriapps.presentation.message.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.adapter.HistoryTransactionAdapter
import com.mandiri.mandiriapps.databinding.FragmentHistoryTransactionBinding
import com.mandiri.mandiriapps.model.HistoryTransactionModel
import com.mandiri.mandiriapps.presentation.DetailTransactionActivity

class HistoryTransactionFragment : Fragment() {
    private var _historyAdapter: HistoryTransactionAdapter? = null
    private var _historyTransactionData: List<HistoryTransactionModel>? = null
    private var _binding: FragmentHistoryTransactionBinding? = null
    private val binding get() = _binding!!
//    simbol ! untuk menandakan tidak null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryTransactionBinding.inflate(layoutInflater)

        setupViewHistoryBinding()
        return binding.root
    }

    private fun setupViewHistoryBinding() {
        _historyTransactionData = populateDataHistoryTransaction()
        _historyAdapter = HistoryTransactionAdapter(
            data = populateDataHistoryTransaction(),
            onClickHistoryTransaction = {
//                navigateToDetailHistory()
                DetailTransactionActivity.navigateToDetailTransaction(
                    activity = requireActivity(),
                    data = it
        )
//        binding.vHistoryTransaction.rvHistoryTransaction.adapter = HistoryTransactionAdapter(
//
//                )
            }
        )
        binding.vHistoryTransaction.rvHistoryTransaction.adapter = _historyAdapter
    }


//    private fun navigateToDetailHistory(data: HistoryTransactionModel){
//        val intent = Intent(context, DetailTransactionActivity::class.java)
//        intent.putExtra("", data)
//        startActivity(intent)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewHistoryBinding()

        val items = arrayOf("Semua", "Debit", "Credit")
        binding.vHistoryTransaction.sTitle.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, items)

        binding.vHistoryTransaction.sTitle.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerValue = parent?.getItemAtPosition(position).toString()
                binding.vHistoryTransaction.tvFilterName.text = spinnerValue

                if(spinnerValue == "Semua"){
                    _historyAdapter?.filterTransactionData(populateDataHistoryTransaction())
                }
                else {
                    populateDataHistoryTransaction().filter { it.titleTransaction == spinnerValue.lowercase() }.also {
                            historyData -> _historyAdapter?.filterTransactionData(historyData)
                    }
                }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //to avoid memory leaks, nullify the binding object on this method
        _binding = null
    }

    private fun populateDataHistoryTransaction(): List<HistoryTransactionModel> {
        return listOf(
            HistoryTransactionModel(
                date = "11 Januari 2024",
                titleTransaction = "debit",
                subtitleTransaction = "Transfer Mandiri - Tiara",
                balanceTransaction = "Rp200.000,00",
                iconTransaction = R.drawable.baseline_account_balance_wallet_24,
                statusTransaction = 1
            ),
            HistoryTransactionModel(
                date = "12 Januari 2024",
                titleTransaction = "credit",
                subtitleTransaction = "Transfer Mandiri - Rens",
                balanceTransaction = "Rp300.000,00",
                iconTransaction = R.drawable.baseline_credit_score_24,
                statusTransaction = 2
            )
        )
    }
}