package com.coding.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coding.myapplication.data.Planet
import com.coding.myapplication.domain.UseCase.GetPlanetUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlanetViewModel(private val getPlanetUseCase: GetPlanetUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Initial)
    val uiState: StateFlow<UiState> = _uiState

    init {
        getPlanets()
    }

    private fun getPlanets() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            delay(1000)
            val planets = getPlanetUseCase()
            _uiState.value = UiState.Success(planets)
        }
    }
}

sealed class UiState {
    object Initial : UiState()
    object Loading : UiState()
    data class Success(val data: List<Planet>) : UiState()
    data class Error(val message: String) : UiState()
}