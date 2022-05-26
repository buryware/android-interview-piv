package com.png.interview.weather.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.core.app.BundleCompat
import com.png.interview.App
import com.png.interview.R
import com.png.interview.databinding.FragmentForecastBinding
import com.png.interview.ui.InjectedFragment
import kotlinx.coroutines.FlowPreview
import android.content.Intent as Intent


@FlowPreview
class ForecastFragment : InjectedFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var forecastView = FragmentForecastBinding.inflate(inflater, container, false).root

        return forecastView
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle)
    {
        // Store UI state to the savedInstanceState.
        // This bundle will be passed to onCreate on next call.

    }

}