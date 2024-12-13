package com.antonvinicius.nlw.core.network

import com.antonvinicius.nlw.core.network.KtorHttpClient.httpClient
import com.antonvinicius.nlw.data.model.Coupon
import com.antonvinicius.nlw.data.model.MarketDetails
import com.antonvinicius.nlw.data.model.NearbyCategory
import com.antonvinicius.nlw.data.model.NearbyMarket
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch

object NearbyRemoteDataSource {
    private const val LOCAL_HOST_EMULATOR_BASE_URL = "http://10.0.2.2:3333"
    private const val LOCAL_HOST_PHYSICAL_BASE_URL = "http://192.168.100.201:3333"

    private const val BASE_URL = LOCAL_HOST_PHYSICAL_BASE_URL

    suspend fun getCategories(): Result<List<NearbyCategory>> = try {
        val categories = httpClient.get("$BASE_URL/categories").body<List<NearbyCategory>>()

        Result.success(categories)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarkets(categoryId: String): Result<List<NearbyMarket>> = try {
        val markets =
            httpClient.get("$BASE_URL/markets/category/$categoryId").body<List<NearbyMarket>>()

        Result.success(markets)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarketDetails(marketId: String): Result<MarketDetails> = try {
        val market = httpClient.get("$BASE_URL/markets/$marketId").body<MarketDetails>()

        Result.success(market)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun patchCoupon(marketId: String): Result<Coupon> = try {
        val coupon = httpClient.patch("$BASE_URL/coupons/$marketId").body<Coupon>()

        Result.success(coupon)
    } catch (e: Exception) {
        Result.failure(e)
    }
}