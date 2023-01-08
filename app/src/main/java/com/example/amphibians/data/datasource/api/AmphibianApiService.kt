package com.example.amphibians.data.datasource.api

import com.example.amphibians.domain.model.Amphibian
import retrofit2.http.GET

interface AmphibianApiService {
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}