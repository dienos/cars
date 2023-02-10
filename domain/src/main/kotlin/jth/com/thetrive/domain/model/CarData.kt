package jth.com.thetrive.domain.model

data class CarData(
    val id: Int?,
    val car: Car?,
    val postExists: Boolean = false,
    val newestPostAt: String?,
    val trading: Boolean = false,
    val soldOut: Boolean = false,
    val subscriptionId: String?,
    val priceHidden: Boolean = false,
)