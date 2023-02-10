package jth.com.thetrive.domain.mapper

import jth.com.thetrive.data.model.BrandDTO
import jth.com.thetrive.data.model.CarDTO
import jth.com.thetrive.data.model.CarDataDTO
import jth.com.thetrive.domain.model.Brand
import jth.com.thetrive.domain.model.Car
import jth.com.thetrive.domain.model.CarData

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
    price = price,
    purchasePrice = purchasePrice,
    mileage = mileage,
    plate = plate,
    modelYear = modelYear,
    registeredAt = registeredAt,
    hasPromotion = hasPromotion,
    originalPrice = originalPrice
)

fun BrandDTO.asBrand(): Brand = Brand(
    id = id,
    name = name,
    logoUrl = logoUrl
)

