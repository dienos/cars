package jth.com.thetrive.data.datasource.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import jth.com.thetrive.data.api.TheTriveService
import jth.com.thetrive.data.model.CarDataDTO
import javax.inject.Inject

class CollectionPagingSource @Inject constructor(
    private val service: TheTriveService
) : PagingSource<Int, CarDataDTO>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CarDataDTO> {
        return try {
            val key = params.key
            val response = service.getCollectionCars(key)
            val result: List<CarDataDTO>? = response.result
            val nextKey = result?.get(result.size.minus(1))?.id

            LoadResult.Page(
                data = result!!,
                prevKey = key,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CarDataDTO>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}