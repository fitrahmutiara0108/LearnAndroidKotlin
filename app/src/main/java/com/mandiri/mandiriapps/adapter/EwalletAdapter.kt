package com.mandiri.mandiriapps.adapter

import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.mandiriapps.databinding.ComponentCardItemBinding
import com.mandiri.mandiriapps.databinding.ItemEwalletBinding
import com.mandiri.mandiriapps.model.EwalletModel

class EwalletAdapter : RecyclerView.Adapter<EwalletAdapter.ViewHolder>() {
    private var listEwallet: MutableList<EwalletModel> = mutableListOf()
    private var onClickEwallet: (EwalletModel) -> Unit = {}

    fun setDataEwallet(data: MutableList<EwalletModel>) {
        this.listEwallet = data
        notifyDataSetChanged()
    }

    fun setOnClickEwallet(listener: (EwalletModel) -> Unit) {
        onClickEwallet = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemEwalletBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listEwallet[position], onClickEwallet)
    }

    override fun getItemCount(): Int = listEwallet.size

    inner class ViewHolder (private val itemBinding: ItemEwalletBinding) : RecyclerView.ViewHolder(itemBinding.root){
//        val exampleList = mutableListOf<EwalletModel>()
//        val ewalletModel = EwalletModel(name = "Tiara", image = 4016, balance = 2.3, isConnected = false)

        fun bind(ewallet: EwalletModel, onClickEwallet: (EwalletModel) -> Unit){

            if(ewallet.isConnected){
                  itemBinding.tvBalance.visibility = View.VISIBLE
                  itemBinding.btnConnectAccount.visibility = View.GONE
            } else {
                itemBinding.tvBalance.visibility = View.GONE
                itemBinding.btnConnectAccount.visibility = View.VISIBLE
            }

            itemBinding.tvBalance.text = ewallet.balance.toString()
            itemBinding.ivEwallet.setImageResource(ewallet.image)
            itemBinding.btnConnectAccount.setOnClickListener{
                onClickEwallet.invoke(ewallet)
            }

        }
    }
}