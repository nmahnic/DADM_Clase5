package com.nicomahnic.dadm.clase5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.dadm.clase5.R
import com.nicomahnic.dadm.clase5.entities.Device

class DevicesAdapter(
    private var devicesList: List<Device>,
    val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<DevicesAdapter.DeviceHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_device,parent,false)
        return (DeviceHolder(view))
    }

    override fun getItemCount(): Int {
        return devicesList.size
    }

    override fun onBindViewHolder(holder: DeviceHolder, position: Int) {

        holder.setName(devicesList[position].name)

        holder.getItem(position)
    }


    inner class DeviceHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setName(name: String) {
            val txt: TextView = itemView.findViewById(R.id.txt_name_item)
            txt.text = name
        }

        fun getItem (position: Int): Unit {
            return itemView.setOnClickListener { onItemClick(position) }
        }
    }
}