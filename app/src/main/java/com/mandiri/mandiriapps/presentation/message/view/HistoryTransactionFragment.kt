package com.mandiri.mandiriapps.presentation.message.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.adapter.HistoryTransactionAdapter
import com.mandiri.mandiriapps.databinding.FragmentHistoryTransactionBinding
import com.mandiri.mandiriapps.model.HistoryTransactionModel
import com.mandiri.mandiriapps.presentation.DetailTransactionActivity

class HistoryTransactionFragment : Fragment() {
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
        binding.vHistoryTransaction.rvHistoryTransaction.adapter = HistoryTransactionAdapter(
            data = populateDataHistoryTransaction(),
            onClickHistoryTransaction = {
//                navigateToDetailHistory()
                DetailTransactionActivity.navigateToDetailTransaction(
                    activity = requireActivity(),
                    data = it
                )
            }
        )
    }

//    private fun navigateToDetailHistory(data: HistoryTransactionModel){
//        val intent = Intent(context, DetailTransactionActivity::class.java)
//        intent.putExtra("", data)
//        startActivity(intent)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
                titleTransaction = "Debit",
                subtitleTransaction = "Transfer Mandiri - Tiara",
                balanceTransaction = "Rp200.000,00",
                iconTransaction = R.drawable.baseline_account_balance_wallet_24,
                statusTransaction = 1
            ),
            HistoryTransactionModel(
                date = "12 Januari 2024",
                titleTransaction = "Credit",
                subtitleTransaction = "Transfer Mandiri - Rens",
                balanceTransaction = "Rp300.000,00",
                iconTransaction = R.drawable.baseline_credit_score_24,
                statusTransaction = 2
            )
        )
    }
}