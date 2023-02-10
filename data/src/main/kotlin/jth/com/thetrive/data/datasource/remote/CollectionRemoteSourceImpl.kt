package jth.com.thetrive.data.datasource.remote

import jth.com.thetrive.data.api.TheTriveService
import jth.com.thetrive.data.model.CarDataDTO
import jth.com.thetrive.data.model.CarListFilterDataDTO
import jth.com.thetrive.data.model.CommonDTO
import javax.inject.Inject

interface CollectionRemoteSource {
    suspend fun getCollectionCars(): CommonDTO<List<CarDataDTO>>
    suspend fun getCarListFilters(): CommonDTO<CarListFilterDataDTO>
}

class CollectionRemoteSourceImpl @Inject constructor(
    private val service: TheTriveService
) : CollectionRemoteSource {
    override suspend fun getCollectionCars(): CommonDTO<List<CarDataDTO>> =
        service.getCollectionCars()

    override suspend fun getCarListFilters(): CommonDTO<CarListFilterDataDTO> =
        service.getCarListFilter()
}