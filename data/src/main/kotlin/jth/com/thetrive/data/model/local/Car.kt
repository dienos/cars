package jth.com.thetrive.data.model.local

data class Car(
    val id: Int?,
    val name: String?,
    val imageUrl: String?,
    val brand: Brand?,
    val price: String?,
    val purchasePrice: Long?,
    val mileage: String?,
    val plate: String?,
    val modelYear: String?,
    val registeredAt: String?,
    val hasPromotion: Boolean = false,
    val originalPrice: Int?
)