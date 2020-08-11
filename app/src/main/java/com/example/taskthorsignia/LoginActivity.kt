package com.example.taskthorsignia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.taskthorsignia.Api.Common
import com.example.taskthorsignia.Api.RetrofitClient
import com.example.taskthorsignia.Model.LoginResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var networkService: NetworkService

    lateinit var mobile: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// init Service
      //  networkService = Common.networkService

        button_login.setOnClickListener {

            mobile = editTextPhone.text.toString()
            if (editTextPhone.text.isEmpty()) {
                editTextPhone.error = "Please enter phone number"
            } else
                loginapiCall()

        }


    }

    private fun loginapiCall() {
         RetrofitClient.instance.regUser(mobile)
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                   Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {

                        //SharedPrefManager.getInstance(applicationContext).saveUser(response.body()?.user!!)
                        var sellercode = response.body()?.selleruniqueid
                        Log.i("Info",sellercode);
                        val intent = Intent(applicationContext, OtpActivity::class.java)
                        intent.putExtra("seller_code", sellercode)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                        startActivity(intent)


                    } else {
                        // Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    }

                }
            })

    }
}
