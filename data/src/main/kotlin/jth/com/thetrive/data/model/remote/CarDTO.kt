package jth.com.thetrive.data.model.remote

import com.google.gson.annotations.SerializedName

data class CarDTO(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("imageUrl")
    val imageUrl: String?,

    @SerializedName("brand")
    val brand: BrandDTO?,

    @SerializedName("price")
    val price: Long?,

    @SerializedName("purchasePrice")
    val purchasePrice: Long?,

    @SerializedName("mileage")
    val mileage: Int?,

    @SerializedName("plate")
    val plate: String?,

    @SerializedName("modelYear")
    val modelYear: Int?,

    @SerializedName("registeredAt")
    val registeredAt: String?,

    @SerializedName("hasPromotion")
    val hasPromotion: Boolean = false,

    @SerializedName("originalPrice")
    val originalPrice: Int?
)