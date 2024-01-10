package com.mandiri.mandiriapps.presentation.learn

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.mandiriapps.databinding.ActivityMainBinding
import com.mandiri.mandiriapps.databinding.ItemMainBinding

class MainAdapter(): RecyclerView.Adapter<MainAdapter.MainViewHolder>(){
    public lateinit var aContext: Context
    var intNumber: Int? = null
    lateinit var handleWhenTextClicked: (TextView, Int) -> Unit
    private lateinit var data: MutableList<String>
    class MainViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(data:MutableList<String>){
        this.data=data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var itemMainBinding: ItemMainBinding = ItemMainBinding.inflate(layoutInflater, parent, false)
        var mainViewHolder: MainViewHolder = MainViewHolder(itemMainBinding)
        return mainViewHolder
    }

    override fun getItemCount(): Int {
        val size = data.size
        return size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val text = data[position]
        holder.binding.tvTest.text = text

        println(position)
        holder.binding.tvTest.setOnClickListener{
            handleWhenTextClicked(holder.binding.tvTest, position)
//            var message = "Message: " + holder.binding.tvTest.text + position
//            if(position%2 == 0){
//                Toast.makeText(aContext, message, Toast.LENGTH_SHORT).show()
//
//            }

        }
    }

}