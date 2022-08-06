package com.example.address_page

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AddressAdpater(innerContext: Context, addressDetailsList: ArrayList<AddressModel>,
                     private val callbackInterface:CallbackInterface):
    RecyclerView.Adapter<AddressAdpater.MyViewHolder>() {

    val context= innerContext
    val addressList= addressDetailsList

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val Name=view.findViewById<TextView>(R.id.name)
        val Address = view.findViewById<TextView>(R.id.address)
        val DefaultValue = view.findViewById<TextView>(R.id.defaultKey)
        val radioButton = view.findViewById<RadioButton>(R.id.radiobtn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return addressList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val addressData=addressList[position]
        if(addressData.defaultValue.equals(true)) {
            holder.DefaultValue.visibility = View.VISIBLE
        }
        holder.Name.text=  addressData.name
        holder.Address.text = addressData.address
        holder.radioButton.setOnClickListener {
            callbackInterface.passResultCallback(addressData.name,addressData.address)
        }
    }

    interface CallbackInterface {
        fun passResultCallback(name: String,address: String)
    }

}