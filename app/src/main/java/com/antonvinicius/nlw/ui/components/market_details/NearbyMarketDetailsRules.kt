package com.antonvinicius.nlw.ui.components.market_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antonvinicius.nlw.data.model.NearbyRule
import com.antonvinicius.nlw.data.model.mock.mockMarkets
import com.antonvinicius.nlw.ui.theme.Gray500
import com.antonvinicius.nlw.ui.theme.NearbyTheme
import com.antonvinicius.nlw.ui.theme.Typography

@Composable
fun NearbyMarketDetailsRules(
    modifier: Modifier = Modifier,
    rules: List<NearbyRule>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Regulamento",
            style = Typography.headlineSmall,
            color = Gray500
        )

        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = rules.joinToString(separator = "\n", transform = { "- ${it.description}" }),
            style = Typography.labelMedium,
            lineHeight = 24.sp,
            color = Gray500
        )
    }
}

@Preview
@Composable
private fun MarketDetailsRulesPreview() {
    NearbyTheme {
        NearbyMarketDetailsRules(
            rules = mockMarkets[0].rules
        )
    }
}