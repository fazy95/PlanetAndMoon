package com.coding.myapplication.di

import com.coding.myapplication.data.PlanetRepositoryImp
import com.coding.myapplication.domain.Repository.PlanetRepository
import com.coding.myapplication.domain.UseCase.GetPlanetUseCase
import com.coding.myapplication.ui.PlanetViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{
    single<PlanetRepository> { PlanetRepositoryImp() }
    single { GetPlanetUseCase(get()) }
    viewModel { PlanetViewModel(get()) }
}
