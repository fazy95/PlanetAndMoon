package com.coding.myapplication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.coding.myapplication.data.Planet
import org.koin.androidx.compose.koinViewModel

@Composable
fun MyApplicationScreen(
    viewModel: PlanetViewModel = koinViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        when (val state = uiState.value) {
            is UiState.Initial -> Text(text = "Setting up planets")
            is UiState.Loading -> Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
            { CircularProgressIndicator() }
            is UiState.Success -> PlanetList(planets = state.data, modifier = Modifier.padding(innerPadding))
            is UiState.Error -> Text(
                text = state.message,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}


@Composable
fun PlanetList(planets: List<Planet>, modifier: Modifier) {
    LazyColumn(modifier = modifier.fillMaxHeight()
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        item {
            planets.forEach { planet ->
                PlanetItem(planet = planet, modifier = modifier)
            }
        }

    }
}

@Composable
fun PlanetItem(planet: Planet, modifier: Modifier)  {
    Row(modifier = modifier.fillMaxWidth()
        .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly)
    {
        Text(
            text = planet.name,
            modifier = modifier
        )

        Text(
            text = planet.moons.toString(),
            modifier = modifier
        )
    }
}