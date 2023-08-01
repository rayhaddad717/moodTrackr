package com.rayhaddadcompany.moodtrackr

import com.rayhaddadcompany.moodtrackr.onboarding.MentalOptions

class Constants {
    companion object{
        val  MENTAL_OPTIONS = listOf<MentalOptions>(
            MentalOptions(
                name = "depression",
                isCustom = false,
            ),
            MentalOptions(
                name = "anxiety",
                isCustom = false,
            ),
            MentalOptions(
                name = "OCD",
                isCustom = false,
            ),
            MentalOptions(
                name = "ADHD",
                isCustom = false,
            ),
        )
    }
}