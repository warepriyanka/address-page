package com.example.address_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AddressAdpater.CallbackInterface{

    var addressAdpater: AddressAdpater?= null
    val addressList = ArrayList<AddressModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PrepareData()

        addressAdpater = AddressAdpater(this@MainActivity, addressList, callbackInterface = this)
        val recyclerViewLayOutManager = LinearLayoutManager(this@MainActivity)
        recylerViewAddress.layoutManager = recyclerViewLayOutManager
        recylerViewAddress.adapter = addressAdpater
        addressAdpater?.notifyDataSetChanged()

    }

    private fun PrepareData(): ArrayList<AddressModel> {
        addressList.apply {
            add(AddressModel("Dania Cristina", "Mall Road Chandigarh, Chandigarh" + System.getProperty("line.separator")
                    + "Chandigarh - 653136 ", false))
            add(AddressModel("Jhon Dev ", "India Square Mall, Chandigarh" +
                    System.getProperty("line.separator") + "Chandigarh - 563219 ", true))
            add(AddressModel("Testing ", "Testing , test" +
                    System.getProperty("line.separator") + "up - 976345 ", true))
            add(AddressModel("Testing", "Mall Road Chandigarh, Chandigarh" +
                    System.getProperty("line.separator") + "Chandigarh - 753186 ", false))
        }
        return addressList
    }

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_address -> {
                    if (checked) {
                        childLayout.visibility = View.GONE
                        Log.d("Visibility", "Gone")
                    } else {
                        childLayout.visibility = View.VISIBLE
                        Log.d("Visibility", "View")
                    }
                }
            }
        }
    }

    override fun passResultCallback(name: String, address: String) {
        Username.text = name
        address1.text = address
    }

}