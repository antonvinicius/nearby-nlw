package com.antonvinicius.nlw.ui.screens.market_details

import com.antonvinicius.nlw.data.model.NearbyRule

data class MarketDetailsUiState(
    val rules: List<NearbyRule>? = null,
    val coupon: String? = null
)