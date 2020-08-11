package com.example.taskthorsignia.Model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("success")
	val success: String,

	@field:SerializedName("selleruniqueid")
	val selleruniqueid: String,

	@field:SerializedName("info")
	val info: List<String>
)
