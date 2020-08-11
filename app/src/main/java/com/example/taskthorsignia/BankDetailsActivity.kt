package com.example.taskthorsignia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bank_details.*
import kotlinx.android.synthetic.main.activity_business_details.*
import kotlinx.android.synthetic.main.activity_business_details.etConPaswd

class BankDetailsActivity : AppCompatActivity() {

    lateinit var accName: String
    lateinit var accNumber:String
    lateinit var reAccNumber:String
    lateinit var ifscCode:String
    lateinit var bankName:String
    lateinit  var city:String

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_bank_details)




        accName = etAccountName.text.toString()

        accNumber = etNo.text.toString().trim()
        reAccNumber = etReNo.text.toString().trim()
        ifscCode = etIfsc.text.toString().trim()
        bankName = etBankName.text.toString().trim()
        city = etCityName.text.toString().trim()
      //  roadName = etRoad_Name.text.toString()
        //  shopname  =etShop.text.toString()
        //  shopname  =etShop.text.toString()

        button_Save_next.setOnClickListener {
            if (accName.isEmpty()) {
                etAccountName.setError("enter  name")
            } else if (accNumber.isEmpty()) {
                etShop.setError("enter account number")
            } else if (reAccNumber.isEmpty()) {
                etReNo.setError("enter accountt number")
            } else if (reAccNumber != accNumber) {
                etReNo.setError("account  no does notnot match")
            } else if (bankName.isEmpty()) {
                etBankName.setError("enter bank name")
            } else if (ifscCode.isEmpty()) {
                etIfsc.setError("enter ifsc code")
            }
            else
            {
                val intent = Intent(this, VerificationActivity::class.java)
                startActivity(intent)
             }

        }

    }
}