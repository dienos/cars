package jth.com.thetrive.data.model.remote

import com.google.gson.annotations.SerializedName

data class CarListFilterDataDTO(
    @SerializedName("brands")
    val brands: List<BrandDTO?>?,

    @SerializedName("bodyTypes")
    val bodyTypes: List<BodyTypeDTO?>?,

    @SerializedName("priceRange")
    val priceRange: PriceRangeDTO?,

    @SerializedName("fuelTypes")
    val fuelTypes: List<Int?>?,

    @SerializedName("clientAgeSpans")
    val clientAgeSpans: List<String?>?,

    @SerializedName("favoritesOnly")
    val favoritesOnly: Boolean = false,

    @SerializedName("tradingOnly")
    val tradingOnly: Boolean = false,
    )
