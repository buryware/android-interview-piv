package com.png.interview.weather.ui.model

sealed class AutoCompleteViewRepresentation {
    class AutoCompleteViewRep(val data: AutoCompleteViewData) : AutoCompleteViewRepresentation()
    object Empty : AutoCompleteViewRepresentation()
    object Error : AutoCompleteViewRepresentation()
}
