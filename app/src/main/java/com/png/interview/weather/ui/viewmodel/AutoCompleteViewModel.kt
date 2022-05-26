package com.png.interview.weather.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.png.interview.weather.domain.CreateAutoCompleteRepFromQueryUseCase
import com.png.interview.weather.ui.model.AutoCompleteViewRepresentation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class AutoCompleteViewModel @Inject constructor(
    private val createAutoCompleteRepFromQueryUseCase: CreateAutoCompleteRepFromQueryUseCase
) : ViewModel() {

    private val _AutoCompleteViewRepresentation = MutableStateFlow<AutoCompleteViewRepresentation>(AutoCompleteViewRepresentation.Empty)

    fun submitAutoCompleteSearch(query: String) {
        viewModelScope.launch {
            _AutoCompleteViewRepresentation.value = createAutoCompleteRepFromQueryUseCase(query)
        }
    }

    val availableAutoCompleteLiveData =
        _AutoCompleteViewRepresentation
            .map { (it as? AutoCompleteViewRepresentation.AutoCompleteViewRep)?.data }
            .asLiveData()

    val isEmptyVisible =
        _AutoCompleteViewRepresentation
            .map { it is AutoCompleteViewRepresentation.Empty }
            .asLiveData()
}