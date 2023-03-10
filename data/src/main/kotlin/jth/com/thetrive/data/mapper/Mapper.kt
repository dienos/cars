package jth.com.thetrive.data.mapper

import jth.com.thetrive.data.model.local.*
import jth.com.thetrive.data.model.remote.*
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
        it.asKoreanPrice()
    } ?: "",
    purchasePrice = purchasePrice,
    mileage = mileage?.let {
        it.asMileageString()
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

fun BodyTypeDTO.asBodyType(): BodyType = BodyType(
    id = id,
    name = name,
)

fun PriceRangeDTO.asPriceRange(): PriceRange = PriceRange(
    min = min.toString(),
    max = max.toString()
)

fun Int.asMileageString(): String {
    return this.asCommaFormatter() + "km"
}

fun Long.asKoreanPrice(): String {
    val price = this
    return if (price > 0) {
        if (price < 10000) {
            "$price 원"
        } else {
            val div = price / 10000

            if (div >= 1000) {
                "$div 억원"
            } else {
                "$div 만원"
            }
        }
    } else {
        ""
    }
}

