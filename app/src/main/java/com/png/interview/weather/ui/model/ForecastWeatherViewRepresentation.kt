package com.png.interview.weather.ui.model

sealed class ForecastViewRepresentation {
    class ForecastWeatherViewRep(val data: ForecastWeatherViewData) : ForecastViewRepresentation()
    object Empty : ForecastViewRepresentation()
    object Error : ForecastViewRepresentation()
}
