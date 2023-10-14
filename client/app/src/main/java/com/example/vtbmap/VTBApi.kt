package com.example.vtbmap

import retrofit2.http.GET

interface VTBApi {
    @GET(value = "/bank/12/12/12")
    suspend fun getAllBanks(): List<Atm>

}