package com.antonvinicius.nlw.data.model.mock

import com.antonvinicius.nlw.data.model.NearbyMarket
import com.antonvinicius.nlw.data.model.NearbyRule
import java.util.UUID

val mockMarkets = listOf(
    NearbyMarket(
        id = UUID.randomUUID().toString(),
        categoryId = UUID.randomUUID().toString(),
        name = "Sabor Caseiro",
        description = "Comida caseira e restaurante",
        coupons = 10,
//        rules = listOf(
//            NearbyRule(
//                id = UUID.randomUUID().toString(),
//                description = "Disponível até 12/12/2012",
//                marketId = UUID.randomUUID().toString()
//            ),
//            NearbyRule(
//                id = UUID.randomUUID().toString(),
//                description = "Disponível até 31/12/9999",
//                marketId = UUID.randomUUID().toString()
//            ),
//        ),
        latitude = -8.7677919,
        longitude = -63.8925958,
        address = "Rua Jacy Paraná, 2024 - Mato Grosso, Porto Velho - RO, 76804-418",
        phone = "069993002285",
        cover = "https://lh5.googleusercontent.com/p/AF1QipNUQpjoisrMcUBfRAWnxk6HKCHeanx6vSGVzwpw=w408-h306-k-no"
    ),
    NearbyMarket(
        id = UUID.randomUUID().toString(),
        categoryId = UUID.randomUUID().toString(),
        name = "Sabor Caseiro",
        description = "Comida caseira e restaurante",
        coupons = 10,
//        rules = emptyList(),
        latitude = -8.7677919,
        longitude = -63.8925958,
        address = "Rua Jacy Paraná, 2024 - Mato Grosso, Porto Velho - RO, 76804-418",
        phone = "069993002285",
        cover = "https://lh5.googleusercontent.com/p/AF1QipNUQpjoisrMcUBfRAWnxk6HKCHeanx6vSGVzwpw=w408-h306-k-no"
    ),
    NearbyMarket(
        id = UUID.randomUUID().toString(),
        categoryId = UUID.randomUUID().toString(),
        name = "Sabor Caseiro",
        description = "Comida caseira e restaurante",
        coupons = 10,
//        rules = emptyList(),
        latitude = -8.7677919,
        longitude = -63.8925958,
        address = "Rua Jacy Paraná, 2024 - Mato Grosso, Porto Velho - RO, 76804-418",
        phone = "069993002285",
        cover = "https://lh5.googleusercontent.com/p/AF1QipNUQpjoisrMcUBfRAWnxk6HKCHeanx6vSGVzwpw=w408-h306-k-no"
    )
)