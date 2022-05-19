package com.png.interview.weather.ui.binder

import android.app.Activity
import android.widget.Toast
import com.png.interview.weather.ui.viewmodel.CurrentWeatherViewModel

class CurrentWeatherFragmentViewBinder(
    private val viewModel: CurrentWeatherViewModel,
    private val activity: Activity,
    private val settingsAction: () -> Unit,
    private val forecastAction: () -> Unit
) {

    val availableWeatherViewData = viewModel.availableCurrentWeatherLiveData
    val isEmpty = viewModel.isEmptyVisible

    var input: String = ""

    fun refreshClicked() {
        //Toast.makeText(activity, "Refresh Clicked TODO", Toast.LENGTH_LONG).show()
        goClicked()
    }

    fun seeForecastClicked() {
        //Toast.makeText(activity, "Forecast Clicked TODO", Toast.LENGTH_LONG).show()
         forecastAction()
    }

    fun settingsClicked() {
        settingsAction()
    }

    fun goClicked() {
        if (input.isEmpty()) {
            Toast.makeText(activity, "Please enter query", Toast.LENGTH_LONG).show()
        } else if (input.length < 3) {
            Toast.makeText(activity, "Please Enter more than 3 characters", Toast.LENGTH_LONG).show()
        } else {
            viewModel.submitCurrentWeatherSearch(input)
        }
    }
}