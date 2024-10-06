package com.coding.myapplication.data

import com.coding.myapplication.domain.Repository.PlanetRepository

class PlanetRepositoryImp: PlanetRepository{

    val mercury = Planet("Mercury", 0)
    val venus = Planet("Venus", 0)
    val earth = Planet("Earth", 1)
    val mars = Planet("Mars", 2)
    val jupiter = Planet("Jupiter", 67)
    val saturn = Planet("Saturn", 82)

    val planets = listOf(mercury, venus, earth, mars, jupiter, saturn)
    override fun getPlanetsCo(): List<Planet> {
        return planets
    }

}