package jth.com.thetrive.data.model.local

data class CarFiltersResult(
    val filterMap: HashMap<String, CarFilter>,
    val favoritesOnly: Boolean = false,
    val tradingOnly: Boolean = false)