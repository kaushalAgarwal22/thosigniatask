package com.example.taskthorsignia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_business_details.*

class BusinessDetailsActivity : AppCompatActivity() {

    lateinit var onerName: String
    lateinit var shopName: String
    lateinit var password: String
    lateinit var confirmPassword: String
    lateinit var roadName: String
    lateinit var state: String
    lateinit var city: String
    lateinit var accountType: String
    lateinit var sellercode: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business_details)


        sellercode = intent.getStringExtra("seller_code")

        button_Save.setOnClickListener {

            onerName = etOwnerName.text.toString().trim()
            shopName = etShop.text.toString().trim()
            password = etPassword.text.toString().trim()
            confirmPassword = etConPaswd.text.toString().trim()
            state = etState.text.toString().trim()
            city = etCity.text.toString().trim()
            roadName = etRoad_Name.text.toString().trim()

            if (rbGrower.isChecked) {
                accountType = "Grower"
            }
            if (rbResell.isChecked) {
                accountType = "Reseller"
            }
            if (rbWholesell.isChecked) {
                accountType = "WholeSaler"
            }
            //  shopname  =etShop.text.toString()
            //  shopname  =etShop.text.toString()
            if (onerName.isEmpty()) {
                etOwnerName.setError("enter owner name")
            } else if (shopName.isEmpty()) {
                etShop.setError("enter shop name")
            } else if (password.isEmpty()) {
                etPassword.setError("enter password")
            } else if (confirmPassword != password) {
                etConPaswd.setError("password andd conirm password not match")
            } else if (roadName.isEmpty()) {
                etRoad_Name.setError("enter road name")
            } else if (city.isEmpty()) {
                etCity.setError("enter city")
            } else if (state.isEmpty()) {
                etState.setError("enter state")
            } else {
                val intent = Intent(this, BankDetailsActivity::class.java)
                startActivity(intent)
            }


        }
    }
}
