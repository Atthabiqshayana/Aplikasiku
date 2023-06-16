package com.d3if4112.aplikasiku.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://raw.githubusercontent.com/" +
        "indraazimi/galeri-hewan/static-api/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
interface KendaraanApiService {
    @GET("static-api.json")
    suspend fun getHewan(): String
}
object KendaraanApi {
    val service: KendaraanApiService by lazy {
        retrofit.create(KendaraanApiService::class.java)
    }
}
