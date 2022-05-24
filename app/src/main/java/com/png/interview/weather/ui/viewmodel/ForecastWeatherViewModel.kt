package com.png.interview.weather.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.png.interview.weather.domain.CreateForecastRepFromQueryUseCase
import com.png.interview.weather.domain.CreateForecastWeatherRepFromQueryUseCase
import com.png.interview.weather.ui.model.ForecastWeatherViewRepresentation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class ForecastWeatherViewModel @Inject constructor(
    private val createForecastWeatherRepFromQueryUseCase: CreateForecastRepFromQueryUseCase
) : ViewModel() {

    private val _ForecastWeatherViewRepresentation = MutableStateFlow<ForecastWeatherViewRepresentation>(ForecastWeatherViewRepresentation.Empty)

    fun submitForecastWeatherSearch(query: String) {
        viewModelScope.launch {
            _ForecastWeatherViewRepresentation.value = createForecastWeatherRepFromQueryUseCase(query)
        }
    }

    val availableForecastWeatherLiveData =
        _ForecastWeatherViewRepresentation
            .map { (it as? ForecastWeatherViewRepresentation.ForecastWeatherViewRep)?.data }
            .asLiveData()

    val isEmptyVisible =
        _ForecastWeatherViewRepresentation
            .map { it is ForecastWeatherViewRepresentation.Empty }
            .asLiveData()
}