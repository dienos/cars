package jth.com.thetrive.domain.usecase

import jth.com.thetrive.data.mapper.asBodyType
import jth.com.thetrive.data.mapper.asBrand
import jth.com.thetrive.data.mapper.asPriceRange
import jth.com.thetrive.data.model.local.BodyType
import jth.com.thetrive.data.model.local.Brand
import jth.com.thetrive.data.model.local.CarFilter
import jth.com.thetrive.data.model.local.CarFiltersResult
import jth.com.thetrive.data.model.remote.CarListFilterDataDTO

class MakeCollectionCarsFiltersResultUseCase {
    operator fun invoke(
        data: CarListFilterDataDTO
    ): CarFiltersResult {
        val map = linkedMapOf<String, CarFilter>()

        data.brands?.let {
            if (it.isEmpty().not()) {
                val brandList = arrayListOf<Brand>()

                it.forEach { brand ->
                    brand?.let {
                        brandList.add(brand.asBrand())
                    }
                }

                map["브랜드"] = CarFilter(brand = brandList)
            }
        }

        data.bodyTypes?.let {
            if (it.isEmpty().not()) {
                val bodyTypeList = arrayListOf<BodyType>()

                it.forEach { bodyType ->
                    bodyType?.let {
                        bodyTypeList.add(bodyType.asBodyType())
                    }
                }

                map["바디타입"] = CarFilter(bodyType = bodyTypeList)
            }
        }

        data.priceRange?.let {
            map["구독료"] = CarFilter(priceRange = it.asPriceRange())
        }

        data.clientAgeSpans?.let {
            map["찜한 자동차만 보기"] = CarFilter()
        }

        return CarFiltersResult(
            filterMap = map,
            favoritesOnly = data.favoritesOnly,
            tradingOnly = data.tradingOnly
        )
    }
}