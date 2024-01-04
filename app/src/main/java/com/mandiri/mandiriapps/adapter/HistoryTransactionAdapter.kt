package com.mandiri.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.databinding.ItemHistoryTransactionBinding
import com.mandiri.mandiriapps.databinding.ItemServiceBinding
import com.mandiri.mandiriapps.model.HistoryTransactionModel
import com.mandiri.mandiriapps.model.StatusTransaction
import com.mandiri.mandiriapps.model.StatusTransfer

class HistoryTransactionAdapter(
    private val data: List<HistoryTransactionModel>,
    private val onClickHistoryTransaction: (HistoryTransactionModel) -> Unit
) : RecyclerView.Adapter<HistoryTransactionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHistoryTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ViewHolder(val binding: ItemHistoryTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HistoryTransactionModel) {
            binding.tvDate.text = data.date
            binding.tvTitle.text = data.titleTransaction
            binding.tvSubtitle.text = data.subtitleTransaction
            binding.tvBalance.text = data.balanceTransaction
            binding.ivTransactionLogo.setImageResource(data.iconTransaction)

            when (data.statusTransaction){
                StatusTransaction.Berhasil.value -> {
                    binding.tvStatus.text = "Berhasil"
                    binding.tvStatus.setTextColor(binding.root.context.getColor(R.color.green))
                }
                StatusTransaction.Gagal.value -> {
                    binding.tvStatus.text = "Gagal"
                    binding.tvStatus.setTextColor(binding.root.context.getColor(R.color.red))
                }
                StatusTransaction.Pending.value -> {
                    binding.tvStatus.text = "Pending"
                    binding.tvStatus.setTextColor(binding.root.context.getColor(R.color.blue))
                }
            }

            when (data.titleTransaction){
                StatusTransfer.Credit.value -> {
                    binding.tvTitle.text = "Credit Transaction"
                    binding.ivTransactionLogo.setImageResource(R.drawable.baseline_credit_score_24)
                }
                StatusTransfer.Credit.value -> {
                    binding.tvTitle.text = "Debit Transaction"
                    binding.ivTransactionLogo.setImageResource(R.drawable.baseline_account_balance_wallet_24)
                }
            }

            binding.constraintItemTransaction.setOnClickListener{
                onClickHistoryTransaction.invoke(data)
            }
        }
    }

}