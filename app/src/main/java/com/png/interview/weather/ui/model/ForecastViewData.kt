package com.png.interview.weather.ui.model

data class ForecastViewData(
    val date: String,
    val min_temperature: String,
    val max_temperature: String,
    val windSpeed: String,
    val condition: String
)