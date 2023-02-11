package jth.com.thetrive.data.datasource.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import jth.com.thetrive.data.api.TheTriveService
import jth.com.thetrive.data.model.local.CarData
import jth.com.thetrive.data.model.remote.CarDataDTO
import jth.com.thetrive.data.model.remote.CarListFilterDataDTO
import jth.com.thetrive.data.model.remote.CommonDTO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CollectionRemoteSource {
    suspend fun getCarListFilters(): CommonDTO<CarListFilterDataDTO>
    fun getCollectionCarsPaging(pageSize : Int): Flow<PagingData<CarData>>
}

class CollectionRemoteSourceImpl @Inject constructor(
    private val service: TheTriveService
) : CollectionRemoteSource {
    override suspend fun getCarListFilters(): CommonDTO<CarListFilterDataDTO> =
        service.getCarListFilter()

    override fun getCollectionCarsPaging(pageSize : Int): Flow<PagingData<CarData>> {
        return Pager(
            PagingConfig(
                pageSize = pageSize,
            ),
            pagingSourceFactory = {
                CollectionPagingSource(service)
            }
        ).flow
    }
}