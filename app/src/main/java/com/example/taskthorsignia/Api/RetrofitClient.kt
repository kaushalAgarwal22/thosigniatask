package com.example.taskthorsignia.Api

import com.example.taskthorsignia.NetworkService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "http://omyguru.com/flowerbazaar/public/api/"

//    private val okHttpClient = OkHttpClient.Builder()
//        .addInterceptor { chain ->
//            val original = chain.request()
//
////            val requestBuilder = original.newBuilder()
////                .addHeader("Authorization", AUTH)
////                .method(original.method(), original.body())
//
//            val request = requestBuilder.build()
//            chain.proceed(request)
//        }.build()

    val instance: NetworkService by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //.client(okHttpClient)
            .build()

        retrofit.create(NetworkService::class.java)
    }

}