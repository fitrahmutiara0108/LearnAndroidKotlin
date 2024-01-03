package com.mandiri.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.mandiriapps.databinding.ItemSavingBinding
import com.mandiri.mandiriapps.model.SavingModel
import java.security.PrivateKey

class SavingAdapter (
    private val savingData: MutableList<SavingModel>,
    private var MAX_ITEM: Int = 2
): RecyclerView.Adapter<SavingAdapter.SavingViewHolder>() {
   inner class SavingViewHolder(private val itemBinding: ItemSavingBinding) :
    RecyclerView.ViewHolder(itemBinding.root){

        fun bind(data: SavingModel){
            itemBinding.tvSavingName.text = data.savingName
            itemBinding.tcAccountNumber.text = data.accountNumber
            itemBinding.ivSavingCard.setImageResource(data.imageCard)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavingViewHolder {
        return SavingViewHolder(
            ItemSavingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() =
        if (savingData.size > MAX_ITEM) MAX_ITEM else savingData.size

    override fun onBindViewHolder(holder: SavingViewHolder, position: Int) {
        holder.bind(savingData[position])
    }

    fun updateQuantitySize(sizeUpdate: Int){
        MAX_ITEM=sizeUpdate
        notifyDataSetChanged()
    }


    companion object {
        const val MAX_ITEM = 2
    }

}