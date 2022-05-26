package com.png.interview.weather.domain

import com.png.interview.api.common_model.NetworkResponse
import com.png.interview.weather.api.WeatherApi
import com.png.interview.weather.api.model.AutoCompleteResponse
import javax.inject.Inject

interface GetAutoCompleteDataUseCase {
    suspend operator fun invoke(query: String): NetworkResponse<AutoCompleteResponse, Unit>
}

class DefaultGetAutoCompleteDataUseCase @Inject constructor(
    private val weatherApi: WeatherApi
) : GetAutoCompleteDataUseCase {
    override suspend fun invoke(query: String): NetworkResponse<AutoCompleteResponse, Unit> {
        return weatherApi.getAutocompleteResults(query)
    }
}