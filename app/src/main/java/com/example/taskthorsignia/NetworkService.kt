package com.example.taskthorsignia

import com.example.taskthorsignia.Model.LoginResponse
import com.example.taskthorsignia.Model.OtpResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST

interface NetworkService {

    @FormUrlEncoded
    @POST("sellermobile/reg")
    fun regUser(
        @Field("seller_mobile") mobile:String

        ):Call<LoginResponse>

    @FormUrlEncoded
    @POST("sellermobile/verify")
    fun verifyUser(
        @Field("seller_otp") otp:String,
        @Field("seller_code") sellercode:String

    ):Call<OtpResponse>

//    @@Multipart
//    @POST("store/seller")
//    fun uploadBusinessDetails

}