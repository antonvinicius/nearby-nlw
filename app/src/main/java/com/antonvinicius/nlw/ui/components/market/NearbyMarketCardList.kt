package com.antonvinicius.nlw.ui.components.market

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonvinicius.nlw.data.model.NearbyMarket
import com.antonvinicius.nlw.data.model.mock.mockMarkets
import com.antonvinicius.nlw.ui.theme.NearbyTheme
import com.antonvinicius.nlw.ui.theme.Typography

@Composable
fun NearbyMarketCardList(
    modifier: Modifier = Modifier,
    markets: List<NearbyMarket>,
    onMarketClick: (NearbyMarket) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(text = "Explore locais perto de você", style = Typography.bodyLarge)
        }

        items(
            items = markets,
            key = { it.id }
        ) {
            NearbyMarketCard(
                modifier = Modifier,
                nearbyMarket = it,
                onClick = {
                    onMarketClick(it)
                }
            )
        }
    }
}

@Preview
@Composable
private fun NearbyMarketCardListPreview() {
    NearbyTheme {
        NearbyMarketCardList(
            markets = mockMarkets,
            onMarketClick = {}
        )
    }
}