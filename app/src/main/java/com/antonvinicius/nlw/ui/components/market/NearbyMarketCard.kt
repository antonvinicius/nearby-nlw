package com.antonvinicius.nlw.ui.components.market

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.antonvinicius.nlw.R
import com.antonvinicius.nlw.data.model.NearbyMarket
import com.antonvinicius.nlw.ui.theme.Gray100
import com.antonvinicius.nlw.ui.theme.Gray200
import com.antonvinicius.nlw.ui.theme.Gray400
import com.antonvinicius.nlw.ui.theme.Gray500
import com.antonvinicius.nlw.ui.theme.NearbyTheme
import com.antonvinicius.nlw.ui.theme.RedBase
import com.antonvinicius.nlw.ui.theme.Typography
import java.util.UUID

@Composable
fun NearbyMarketCard(
    modifier: Modifier = Modifier,
    nearbyMarket: NearbyMarket,
    onClick: (NearbyMarket) -> Unit
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Gray100)
            .border(
                width = 1.dp,
                color = Gray200,
                shape = RoundedCornerShape(12.dp)
            ),
        onClick = {
            onClick(nearbyMarket)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray100)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(12.dp)
                    )
                    .fillMaxWidth(0.3f)
                    .height(IntrinsicSize.Min)
                    .aspectRatio(
                        ratio = 1f,
                        matchHeightConstraintsFirst = true
                    ),
                contentScale = ContentScale.Crop,
                model = nearbyMarket.cover,
                contentDescription = "Imagem da loja"
            )
            Column {
                Text(
                    text = nearbyMarket.name,
                    style = Typography.headlineSmall.copy(fontSize = 14.sp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = nearbyMarket.description,
                    style = Typography.bodyLarge.copy(fontSize = 12.sp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Gray500
                )
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        tint = if (nearbyMarket.coupons > 0) {
                            RedBase
                        } else {
                            Gray400
                        },
                        painter = painterResource(R.drawable.ic_ticket),
                        contentDescription = "ícone de cupom"
                    )
                    Text(
                        text = "${nearbyMarket.coupons} cupons disponíveis",
                        color = Gray400,
                        style = Typography.bodyMedium.copy(fontSize = 12.sp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun NearbyMarketCardPreview() {
    NearbyTheme {
        NearbyMarketCard(
            modifier = Modifier.fillMaxWidth(),
            nearbyMarket = NearbyMarket(
                id = UUID.randomUUID().toString(),
                categoryId = UUID.randomUUID().toString(),
                name = "Sabor Caseiro",
                description = "Comida caseira e restaurante",
                coupons = 10,
//                rules = emptyList(),
                latitude = -8.7677919,
                longitude = -63.8925958,
                address = "Rua Jacy Paraná, 2024 - Mato Grosso, Porto Velho - RO, 76804-418",
                phone = "069993002285",
                cover = "https://lh5.googleusercontent.com/p/AF1QipNUQpjoisrMcUBfRAWnxk6HKCHeanx6vSGVzwpw=w408-h306-k-no"
            ),
            onClick = {}
        )
    }
}