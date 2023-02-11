package jth.com.thetrive.data.mapper

import jth.com.thetrive.data.model.remote.BrandDTO
import jth.com.thetrive.data.model.remote.CarDTO
import jth.com.thetrive.data.model.remote.CarDataDTO
import jth.com.thetrive.data.model.local.Brand
import jth.com.thetrive.data.model.local.Car
import jth.com.thetrive.data.model.local.CarData

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

