package com.mandiri.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.mandiriapps.databinding.ItemNotificationBinding
import com.mandiri.mandiriapps.model.NotificationModel

class SettingAdapter(
    private val data:List<NotificationModel>
): RecyclerView.Adapter<SettingAdapter.ViewHolder>() {
    inner class ViewHolder(private val itemBinding: ItemNotificationBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bind(model: NotificationModel){
            itemBinding.tvTitleNotif.text=model.title
            itemBinding.tvSubtitleNotif.text=model.description
            itemBinding.tvDate.text=model.date

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNotificationBinding.inflate(
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
}