package com.example.taskthorsignia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taskthorsignia.Api.RetrofitClient
import com.example.taskthorsignia.Model.OtpResponse
import com.mukesh.OnOtpCompletionListener
import kotlinx.android.synthetic.main.activity_otp.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OtpActivity : AppCompatActivity() {

    lateinit var sellercode: String
    lateinit var otp: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)


        sellercode = intent.getStringExtra("seller_code")

        otp= null.toString()
        otp_view!!.setOtpCompletionListener(object :OnOtpCompletionListener
        {
            override fun onOtpCompleted(otp1: String?) {

             this@OtpActivity.otp = otp1.toString()
            }

        })
        tvResend.setOnClickListener {

            otpVerifyApiCall()
        }
        btVerify.setOnClickListener {

            this@OtpActivity.otp = otp.toString()

              if(otp.isEmpty())
              {
                Toast.makeText(this,"Please enter otp",Toast.LENGTH_SHORT).show()
              }
            else
                  otpVerifyApiCall()
            //}
        }

    }

    private fun otpVerifyApiCall() {
        RetrofitClient.instance.verifyUser(otp, sellercode)
            .enqueue(object : Callback<OtpResponse> {
                override fun onFailure(call: Call<OtpResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<OtpResponse>,
                    response: Response<OtpResponse>
                ) {
                    if (response.isSuccessful) {

                        //SharedPrefManager.getInstance(applicationContext).saveUser(response.body()?.user!!)
                        //   var sellercode = response.body()?.selleruniqueid
                        Log.i("Info", sellercode);
                        val intent = Intent(applicationContext, BusinessDetailsActivity::class.java)
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