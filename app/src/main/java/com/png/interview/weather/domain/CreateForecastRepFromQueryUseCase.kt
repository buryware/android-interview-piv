package com.png.interview.weather.domain

import com.png.interview.api.common_model.NetworkResponse
import com.png.interview.weather.ui.model.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import javax.inject.Inject

interface CreateForecastRepFromQueryUseCase {
    suspend operator fun invoke(query: String): ForecastViewRepresentation
}

class DefaultCreateForecastRepFromQueryUseCase @Inject constructor(
    private val GetForecastDataUseCase: GetForecastDataUseCase
) : CreateForecastRepFromQueryUseCase {
    override suspend fun invoke(query: String): ForecastViewRepresentation {
        return when (val result = GetForecastDataUseCase(query)) {
            is NetworkResponse.Success -> {
                ForecastViewRepresentation.ForecastViewRep(
                    ForecastViewData(
                        date = result.body.location.localtime,
                        min_temperature = "${result.body.current.temp_f} F",
                        max_temperature = "${result.body.current.temp_f} F",
                        condition = result.body.current.condition.text,
                        windSpeed = "${result.body.current.gust_mph} MPH"
                    )
                )
            }
            else -> {
                ForecastViewRepresentation.Error
            }
        }
    }
}