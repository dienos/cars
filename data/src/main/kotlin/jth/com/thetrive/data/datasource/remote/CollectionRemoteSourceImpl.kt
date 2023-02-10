package jth.com.thetrive.data.datasource.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import jth.com.thetrive.data.api.TheTriveService
import jth.com.thetrive.data.model.CarDataDTO
import jth.com.thetrive.data.model.CarListFilterDataDTO
import jth.com.thetrive.data.model.CommonDTO
import javax.inject.Inject

interface CollectionRemoteSource {
    suspend fun getCollectionCars(cursor: Int?): CommonDTO<List<CarDataDTO>>
    suspend fun getCarListFilters(): CommonDTO<CarListFilterDataDTO>
    fun getCollectionCarsPaging() : Pager<Int, CarDataDTO>
}

class CollectionRemoteSourceImpl @Inject constructor(
    private val service: TheTriveService
) :  CollectionRemoteSource {
    override suspend fun getCollectionCars(cursor: Int?): CommonDTO<List<CarDataDTO>> =
        service.getCollectionCars(cursor = cursor)

    override suspend fun getCarListFilters(): CommonDTO<CarListFilterDataDTO> =
        service.getCarListFilter()

    override fun getCollectionCarsPaging(): Pager<Int, CarDataDTO> {
       return Pager(
            config = PagingConfig(
                pageSize = 5,
                maxSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CollectionPagingSource(service)}
        )
    }
}