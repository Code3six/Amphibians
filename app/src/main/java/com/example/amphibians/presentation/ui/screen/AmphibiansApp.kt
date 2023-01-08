package com.example.amphibians.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.presentation.ui.screen.homescreen.HomeScreen
import com.example.amphibians.presentation.viewmodel.AmphibiansViewModel

@Composable
fun AmphibiansApp(){
    val amphibiansViewModel: AmphibiansViewModel =
        viewModel(factory = AmphibiansViewModel.Factory)
    HomeScreen(amphibiansUiState = amphibiansViewModel.amphibiansUiState, retryAction = { amphibiansViewModel.getAmphibians() })
}