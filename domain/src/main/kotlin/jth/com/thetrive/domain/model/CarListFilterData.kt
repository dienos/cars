package jth.com.thetrive.domain.model

data class CarListFilterData(
    val brands: List<Brand?>?,
    val bodyTypes: List<BodyType?>?,
    val priceRange: PriceRange?,
    val fuelTypes: List<Int?>?,
    val clientAgeSpans: List<String?>?,
    val favoritesOnly: Boolean = false,
    val tradingOnly: Boolean = false,
    )
