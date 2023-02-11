package jth.com.thetrive.data.mapper

import jth.com.thetrive.data.model.remote.BrandDTO
import jth.com.thetrive.data.model.remote.CarDTO
import jth.com.thetrive.data.model.remote.CarDataDTO
import jth.com.thetrive.data.model.local.Brand
import jth.com.thetrive.data.model.local.Car
import jth.com.thetrive.data.model.local.CarData
import jth.com.thetrive.data.util.asCommaFormatter

fun CarDataDTO.asCarData(): CarData = CarData(
    id = id,
    car = car?.asCar(),
    postExists = postExists,
    newestPostAt = newestPostAt,
    trading = trading,
    soldOut = soldOut,
    subscriptionId = subscriptionId,
    priceHidden = priceHidden
)

fun CarDTO.asCar(): Car = Car(
    id = id,
    name = name,
    imageUrl = imageUrl,
    brand = brand?.asBrand(),
    price = price?.let {
        it.toString()
    } ?: "",
    purchasePrice = purchasePrice,
    mileage = mileage?.let {
        it.toString()
    } ?: "",
    plate = plate,
    modelYear = modelYear?.let {
        it.toString()
    } ?: "",
    registeredAt = registeredAt,
    hasPromotion = hasPromotion,
    originalPrice = originalPrice
)

fun BrandDTO.asBrand(): Brand = Brand(
    id = id,
    name = name,
    logoUrl = logoUrl
)

fun Int.asMileageString(): String {
    val mileageString = this.toString()
    return mileageString.asCommaFormatter()
}

fun Long.asKoreanPrice(): String {
    val price = this
    return if (price > 0) {
        if (price < 10000) {
            price.toString() + "원"
        } else {
            val div = price / 1000

            if (div >= 1000) {
                div.toString() + "억원"
            } else {
                div.toString() + "만원"
            }
        }
    } else {
        ""
    }
}

