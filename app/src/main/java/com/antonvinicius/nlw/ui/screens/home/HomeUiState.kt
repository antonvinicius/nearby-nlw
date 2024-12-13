package com.antonvinicius.nlw.ui.screens.home

import com.antonvinicius.nlw.data.model.NearbyCategory
import com.antonvinicius.nlw.data.model.NearbyMarket
import com.google.android.gms.maps.model.LatLng

data class HomeUiState(
    val categories: List<NearbyCategory>? = null,
    val markets: List<NearbyMarket>? = null,
    val marketLocations: List<LatLng>? = null
)
