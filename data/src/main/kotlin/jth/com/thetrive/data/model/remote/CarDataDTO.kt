package jth.com.thetrive.data.model.remote

import com.google.gson.annotations.SerializedName

data class CarDataDTO(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("car")
    val car: CarDTO?,

    @SerializedName("postExists")
    val postExists: Boolean = false,

    @SerializedName("newestPostAt")
    val newestPostAt: String?,

    @SerializedName("trading")
    val trading: Boolean = false,

    @SerializedName("soldOut")
    val soldOut: Boolean = false,

    @SerializedName("subscriptionId")
    val subscriptionId: String?,

    @SerializedName("priceHidden")
    val priceHidden: Boolean = false,
)