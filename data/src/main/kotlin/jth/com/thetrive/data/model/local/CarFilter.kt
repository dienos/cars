package jth.com.thetrive.data.model.local

data class CarFilter(
    val selectItem : List<String> = arrayListOf(),
    val brand: List<Brand>? = null,
    val bodyType: List<BodyType>? = null,
    val priceRange: PriceRange? = null,
    val fuelTypes: List<Int?>? = null,
    val clientAgeSpans: List<String?>? = null
)