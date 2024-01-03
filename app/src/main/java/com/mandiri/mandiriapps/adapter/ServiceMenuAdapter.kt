package com.mandiri.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.mandiriapps.databinding.ItemServiceBinding
import com.mandiri.mandiriapps.model.ServiceModel

class ServiceMenuAdapter(
    private val serviceMenuData: MutableList<ServiceModel>
):RecyclerView.Adapter<ServiceMenuAdapter.ServiceMenuViewHolder>(){

    private var _onClickMenu: (ServiceModel)->Unit={}
    fun setOnClickMenu(listener: (ServiceModel)->Unit){
        _onClickMenu = listener
    }

    override fun onBindViewHolder(holder: ServiceMenuAdapter.ServiceMenuViewHolder, position: Int) {
        holder.bind(serviceMenuData[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceMenuAdapter.ServiceMenuViewHolder {
        return ServiceMenuViewHolder(
            ItemServiceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = serviceMenuData.size

    inner class ServiceMenuViewHolder(private val itemBinding: ItemServiceBinding):
            RecyclerView.ViewHolder(itemBinding.root){
                fun bind(model:ServiceModel){
                    itemBinding.tvServiceMenu.text=model.menuTitle
                    itemBinding.btnServiceMenu.setOnClickListener{ _onClickMenu.invoke(model)}
                }
            }
}