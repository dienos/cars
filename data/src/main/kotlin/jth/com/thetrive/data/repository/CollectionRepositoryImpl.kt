package jth.com.thetrive.data.repository

import androidx.paging.PagingData
import jth.com.thetrive.data.datasource.remote.CollectionRemoteSource
import jth.com.thetrive.data.model.local.CarData
import jth.com.thetrive.data.model.remote.CarListFilterDataDTO
import jth.com.thetrive.data.model.remote.CommonDTO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CollectionRepository {
    fun getCollectionCarsPaging(pageSize : Int): Flow<PagingData<CarData>>
    suspend fun getCarListFilters(): CommonDTO<CarListFilterDataDTO>
}

class CollectionRepositoryImpl @Inject constructor(
    private val remoteSource: CollectionRemoteSource
) : CollectionRepository {
    override fun getCollectionCarsPaging(pageSize : Int): Flow<PagingData<CarData>> =
        remoteSource.getCollectionCarsPaging(pageSize)

    override suspend fun getCarListFilters(): CommonDTO<CarListFilterDataDTO> =
        remoteSource.getCarListFilters()
}