package com.example.amphibians.data.repository

import com.example.amphibians.data.datasource.api.AmphibianApiService
import com.example.amphibians.domain.model.Amphibian

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

class NetworkAmphibiansRepository(
    private val amphibianApiService: AmphibianApiService
): AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> = amphibianApiService.getAmphibians()
}