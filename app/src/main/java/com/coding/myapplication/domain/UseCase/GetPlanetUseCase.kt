package com.coding.myapplication.domain.UseCase

import com.coding.myapplication.data.Planet
import com.coding.myapplication.domain.Repository.PlanetRepository

class GetPlanetUseCase(private val planetRepository: PlanetRepository) {
    operator fun invoke(): List<Planet> {
        return planetRepository.getPlanetsCo().filter { it.moons < 3 }
    }
}