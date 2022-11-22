package com.umutcansahin.unit3pathway3sevendaysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Day(
    @StringRes val dayNumber: Int,
    @StringRes val dayTitle: Int,
    @DrawableRes val dayImage: Int,
    @StringRes val dayDescription: Int
)
