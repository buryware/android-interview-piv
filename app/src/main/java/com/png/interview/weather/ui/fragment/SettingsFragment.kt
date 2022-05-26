package com.png.interview.weather.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import com.png.interview.R
import com.png.interview.databinding.FragmentSettingsBinding
import com.png.interview.ui.InjectedFragment
import kotlinx.coroutines.FlowPreview
import timber.log.Timber


@FlowPreview
class SettingsFragment : InjectedFragment() {

    var units_imprial: String = "imprial"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var settingView : View = FragmentSettingsBinding.inflate(inflater, container, false).root

        val unitsRadioGroup = settingView?.findViewById(R.id.units_group) as RadioGroup
        val imperialbtn =  settingView?.findViewById(R.id.radiobtn_imperial) as RadioButton
        val metricbtn =  settingView?.findViewById(R.id.radiobtn_metric) as RadioButton
        var strImperialFlag : String = "imprial"

        if (savedInstanceState == null) {
            units_imprial = "imprial"
        } else {
            strImperialFlag = savedInstanceState.getString("units_imprial", "imprial")
            units_imprial = strImperialFlag
        }

        if (strImperialFlag == "imprial") {
            imperialbtn.isChecked = true
        }else if(strImperialFlag == "metric") {
            metricbtn.isChecked = true
        }else{
            // maybe an error
            Timber.e("Error SettigsFragment bad value: " + strImperialFlag)
        }

        unitsRadioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val idRadioButtonChosen: Int = unitsRadioGroup.getCheckedRadioButtonId()
            if (idRadioButtonChosen > 0) {
                when (checkedId) {
                    R.id.radiobtn_imperial -> {
                        units_imprial = "imprial"
                    }
                    R.id.radiobtn_metric -> {
                        units_imprial = "metric"
                    }
                }
            }
        })

        return settingView
    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save units value
        super.onSaveInstanceState(outState)
        outState.putString("units_imprial", units_imprial)
    }

    fun onRestoreInstanceState(savedInstanceState: Bundle) { // Here You have to restore units value
        units_imprial = savedInstanceState?.getString("units_imprial").toString()
    }
}