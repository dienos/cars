package jth.com.thetrive.domain.model

data class Car(
    val id: Int?,
    val name: String?,
    val imageUrl: String?,
    val brand: Brand?,
    val price: Long?,
    val purchasePrice: Long?,
    val mileage: Int?,
    val plate: String?,
    val modelYear: Int?,
    val registeredAt: String?,
    val hasPromotion: Boolean = false,
    val originalPrice: Int?
)