package com.example.amphibians.domain.model

sealed interface AmphibiansUiState {
    data class Success(val data: List<Amphibian>) : AmphibiansUiState
    object Error: AmphibiansUiState
    object Loading: AmphibiansUiState
}