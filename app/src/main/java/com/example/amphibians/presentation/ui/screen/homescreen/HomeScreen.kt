package com.example.amphibians.presentation.ui.screen.homescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.amphibians.domain.model.AmphibiansUiState
import com.example.amphibians.presentation.ui.screen.homescreen.uistates.ErrorContent
import com.example.amphibians.presentation.ui.screen.homescreen.uistates.LoadingContent
import com.example.amphibians.presentation.ui.screen.homescreen.uistates.SuccessContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    retryAction: () -> Unit
){
    Scaffold(
        topBar = {
            HomeTopBar()
        },
        content = {
            when(amphibiansUiState){
                is AmphibiansUiState.Loading -> LoadingContent()
                is AmphibiansUiState.Success -> SuccessContent(amphibians = amphibiansUiState.data)
                is AmphibiansUiState.Error -> ErrorContent(retryAction = { retryAction() })
            }
        }
    )
}