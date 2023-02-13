package com.figgo.cabs.network

import com.figgo.cabs.models.Driver
import retrofit2.Response
import retrofit2.http.GET

interface FiggoAPI {

    @GET("")
    suspend fun addDriver(): Response<ArrayList<Driver>>
}