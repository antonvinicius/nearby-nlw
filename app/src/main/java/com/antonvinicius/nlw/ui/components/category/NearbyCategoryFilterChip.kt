package com.antonvinicius.nlw.ui.components.category

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonvinicius.nlw.data.model.NearbyCategory
import com.antonvinicius.nlw.ui.theme.Gray300
import com.antonvinicius.nlw.ui.theme.Gray400
import com.antonvinicius.nlw.ui.theme.GreenBase
import com.antonvinicius.nlw.ui.theme.NearbyTheme
import com.antonvinicius.nlw.ui.theme.Typography

@Composable
fun NearbyCategoryFilterChip(
    modifier: Modifier = Modifier,
    category: NearbyCategory,
    isSelected: Boolean,
    onClick: (isSelected: Boolean) -> Unit
) {
    FilterChip(
        modifier = modifier
            .padding(2.dp)
            .heightIn(min = 36.dp),
        selected = isSelected,
        onClick = { onClick(!isSelected) },
        label = {
            Text(
                category.name,
                style = Typography.bodyMedium,
                color = if (isSelected) Color.White else Gray400
            )
        },
        elevation = FilterChipDefaults.filterChipElevation(),
        leadingIcon = {
            category.icon?.let {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(it),
                    contentDescription = "ícone do filtro de categoria",
                    tint = if (isSelected) Color.White else Gray400
                )
            }
        },
        border = FilterChipDefaults.filterChipBorder(
            enabled = false,
            selected = isSelected,
            disabledBorderColor = Gray300,
            borderWidth = 1.dp,
            selectedBorderWidth = 0.dp,
            selectedBorderColor = Color.Transparent
        ),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            selectedContainerColor = GreenBase
        )
    )
}

@Preview
@Composable
private fun NearbyCategoryFilterChipPreview() {
    NearbyTheme {
        NearbyCategoryFilterChip(
            category = NearbyCategory("1", "Supermercado"),
            isSelected = true,
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun NearbyCategoryFilterChipNotSelectedPreview() {
    NearbyTheme {
        NearbyCategoryFilterChip(
            category = NearbyCategory("2", "Compras"),
            isSelected = false,
            onClick = {}
        )
    }
}