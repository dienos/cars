package jth.com.thetrive.data.repository

import jth.com.thetrive.data.datasource.remote.CollectionRemoteSource
import jth.com.thetrive.data.model.CarDataDTO
import jth.com.thetrive.data.model.CarListFilterDataDTO
import jth.com.thetrive.data.model.CommonDTO
import javax.inject.Inject

interface CollectionRepository {
    suspend fun getCollectionCars(): CommonDTO<List<CarDataDTO>>
    suspend fun getCarListFilters(): CommonDTO<CarListFilterDataDTO>
}

class CollectionRepositoryImpl @Inject constructor(
    private val remoteSource: CollectionRemoteSource
) : CollectionRepository {
    override suspend fun getCollectionCars(): CommonDTO<List<CarDataDTO>> =
        remoteSource.getCollectionCars()

    override suspend fun getCarListFilters(): CommonDTO<CarListFilterDataDTO> =
        remoteSource.getCarListFilters()
}