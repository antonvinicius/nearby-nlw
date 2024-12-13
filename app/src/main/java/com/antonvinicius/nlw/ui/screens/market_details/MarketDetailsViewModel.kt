package com.antonvinicius.nlw.ui.screens.market_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antonvinicius.nlw.core.network.NearbyRemoteDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MarketDetailsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MarketDetailsUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: MarketDetailsUiEvent) {
        when (event) {
            is MarketDetailsUiEvent.OnFetchCoupon -> fetchCoupon(event.qrCodeContent)
            is MarketDetailsUiEvent.OnFetchRules -> fetchRules(event.marketId)
            MarketDetailsUiEvent.OnResetCoupon -> resetCoupon()
        }
    }

    private fun fetchCoupon(qrCodeContent: String) {
        viewModelScope.launch {
            NearbyRemoteDataSource.patchCoupon(marketId = qrCodeContent)
                .onSuccess { coupon ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(
                            coupon = coupon.coupon
                        )
                    }
                }
                .onFailure { error ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(
                            coupon = ""
                        )
                    }
                }
        }
    }

    private fun fetchRules(marketId: String) {
        viewModelScope.launch {
            NearbyRemoteDataSource.getMarketDetails(marketId)
                .onSuccess { marketDetails ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(
                            rules = marketDetails.rules
                        )
                    }
                }
                .onFailure { error ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(
                            rules = emptyList()
                        )
                    }
                }
        }
    }

    private fun resetCoupon() {
        _uiState.update {
            it.copy(coupon = null)
        }
    }
}