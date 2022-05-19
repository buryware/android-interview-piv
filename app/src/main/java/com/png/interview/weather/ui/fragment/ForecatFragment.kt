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
import com.png.interview.databinding.FragmentSettingsBinding
import com.png.interview.ui.InjectedFragment
import kotlinx.coroutines.FlowPreview
import android.content.Intent as Intent


@FlowPreview
class SettingsFragment : InjectedFragment() {

    var units_imprial: String = "imprial"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var strImperialFlag : String? = savedInstanceState?.getString("units_imprial", "imprial")
        if (strImperialFlag == null) {
            units_imprial = "imprial"
        } else {
            units_imprial = strImperialFlag
        }

        var settingView = FragmentSettingsBinding.inflate(inflater, container, false).root

        val buttonImperial = settingView?.findViewById<View>(R.id.radiobtn_imperial) as Button
        val buttonMetric = settingView?.findViewById<View>(R.id.radiobtn_metric) as Button
        buttonImperial.setOnClickListener{
            units_imprial = "imprial"
        }
        buttonMetric.setOnClickListener{
            units_imprial = "metric"
        }


        return settingView
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle)
    {
        // Store UI state to the savedInstanceState.
        // This bundle will be passed to onCreate on next call.
        savedInstanceState?.putCharSequence("units_imprial", units_imprial.toString())
    }

}