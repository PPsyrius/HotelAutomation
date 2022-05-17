package com.example.hotelautomtionproject.presentation.presentation

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName(Config.API_ACCESS_KEY_USERNAME)
    var username: String?,
    @SerializedName(Config.API_ACCESS_KEY_PASSWORD)
    var password: String?,
    @SerializedName(Config.API_ACCESS_KEY_GUEST)
    var guest: Guest?,
    @SerializedName(Config.API_ACCESS_KEY_ACCESS)
    var url: String?,
) {
    data class Guest(
        @SerializedName(Config.API_ACCESS_KEY_GUEST_FNAME)
        var fname: String?,
        @SerializedName(Config.API_ACCESS_KEY_GUEST_LNAME)
        var lname: String?
    )
}
