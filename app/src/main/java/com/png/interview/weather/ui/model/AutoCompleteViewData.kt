package com.png.interview.weather.ui.model

data class AutoCompleteViewData(
    val country: String,
    val id: Int,
    val lat: Double,
    val lon: Double,
    val name: String,
    val region: String,
    val url: String
)