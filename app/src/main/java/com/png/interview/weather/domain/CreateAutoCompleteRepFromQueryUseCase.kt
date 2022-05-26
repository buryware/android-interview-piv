package com.png.interview.weather.domain

import com.png.interview.api.common_model.NetworkResponse
import com.png.interview.weather.ui.model.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import javax.inject.Inject

interface CreateAutoCompleteRepFromQueryUseCase {
    suspend operator fun invoke(query: String): AutoCompleteViewRepresentation
}

class DefaultCreateAutoCompleteRepFromQueryUseCase @Inject constructor(
    private val GetAutoCompleteDataUseCase: GetAutoCompleteDataUseCase
) : CreateAutoCompleteRepFromQueryUseCase {
    override suspend fun invoke(query: String): AutoCompleteViewRepresentation {
        return when (val result = GetAutoCompleteDataUseCase(query)) {
            is NetworkResponse.Success -> {
                AutoCompleteViewRepresentation.AutoCompleteViewRep(
                    AutoCompleteViewData(
                        country = "USA",
                       // todo
                            id = 0,
                            lat = 3.4,
                            lon = 4.5,
                            name = "steve",
                            region = "Crossroads",
                            url = "www.weather.api"
                    )
                )
            }
            else -> {
                AutoCompleteViewRepresentation.Error
            }
        }
    }
}