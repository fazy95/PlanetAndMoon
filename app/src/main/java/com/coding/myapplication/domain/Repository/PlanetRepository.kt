package com.coding.myapplication.domain.Repository

import com.coding.myapplication.data.Planet

interface PlanetRepository {
 fun getPlanetsCo(): List<Planet>
}